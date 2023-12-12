package com.android.util

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import timber.log.Timber
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

/**
 * https://github.com/xuhongv/TakePhotoAndroidN
 */
class PhotoTakeManger( //布尔值，true：在mActivity进行操作 ；false :Fragment操作
    private val mActivity: Activity
) {
    private val mContext: Context
    private val isActicity: Boolean

    //默认不开启裁剪
    private var isTailor = false

    //裁剪宽高的比例,默认是是 1 ：1
    private var aspectX = 1
    private var aspectY = 1

    //裁剪图片的宽高,默认是是 1 ：1
    private var outputX = 350
    private var outputY = 350
    private val FILE_PROVIDER_AUTHORITY: String
    private var permissionListener: PermissionListener? = null

    //图片回调接口
    private var takeCallBacklistener: takePictureCallBackListener? = null

    //是否压缩图片 默认开启压缩图片的
    private val isCompressor = true

    //临时存储相片地址
    private var imgPath: String? = null

    //最终得到的Url
    private var outputUri: Uri? = null
    fun startTakeByCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Timber.i("startTakeByCamera  requestRuntimePermission")
            requestRuntimePermission(
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                object : PermissionListener {
                    override fun onGranted() {
                        startOpenCamera()
                    }

                    override fun onDenied(deniedPermissions: List<String?>?) {
                        if (takeCallBacklistener != null) {
                            takeCallBacklistener?.failed(1, deniedPermissions)
                        }
                    }
                })
        } else {
            startOpenCamera()
        }
        Timber.i("startTakeByCamera  startOpenCamera")
    }

    private fun startOpenCamera() {
        imgPath = generateImagePath(mContext)
        Timber.i("startOpenCamera  $imgPath")
        val imgFile = File(imgPath)
        var imgUri: Uri? = null
        imgUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(mContext, FILE_PROVIDER_AUTHORITY, imgFile)
        } else {
            Uri.fromFile(imgFile)
        }
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri)
        if (isActicity) {
            mActivity.startActivityForResult(intent, CODE_ORIGINAL_PHOTO_CAMERA)
        } else {
//            mFragment.startActivityForResult(intent, CODE_ORIGINAL_PHOTO_CAMERA);
        }
    }

    /**
     * 对外接口，是否裁剪
     *
     * @param aspectX 要裁剪的宽比例
     * @param aspectY 要裁剪的高比例
     * @param outputX 要裁剪图片的宽
     * @param outputY 要裁剪图片的高
     */
    fun setTailor(aspectX: Int, aspectY: Int, outputX: Int, outputY: Int) {
        isTailor = true
        this.aspectX = aspectX
        this.aspectY = aspectY
        this.outputX = outputX
        this.outputY = outputY
    }

    /**
     * 申请运行时权限
     */
    private fun requestRuntimePermission(permissions: Array<String>, listener: PermissionListener) {
        permissionListener = listener
        val permissionList: MutableList<String?> = ArrayList()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    mContext,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                permissionList.add(permission)
            }
        }

        //此处兼容了无法在fragment回调监听事件
        if (!permissionList.isEmpty()) {
            if (isActicity) {
                ActivityCompat.requestPermissions(
                    (mContext as Activity),
                    permissionList.toTypedArray(),
                    1
                )
            } else {
//                mFragment.requestPermissions(permissionList.toArray(new String[permissionList.size()]), 1);
            }
            if (takeCallBacklistener != null) {
                takeCallBacklistener!!.failed(1, permissionList)
            }
        } else {
            permissionListener!!.onGranted()
        }
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> if (grantResults.size > 0) {
                val deniedPermissions: MutableList<String?> = ArrayList()
                var i = 0
                while (i < grantResults.size) {
                    val grantResult = grantResults[i]
                    val permission = permissions[i]
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        deniedPermissions.add(permission)
                    }
                    i++
                }
                //被拒绝权限
                if (deniedPermissions.isEmpty()) {
                    permissionListener!!.onGranted()
                } else {
                    permissionListener!!.onDenied(deniedPermissions)
                    if (takeCallBacklistener != null) {
                        takeCallBacklistener!!.failed(1, deniedPermissions)
                    }
                }
            }
        }
    }

    fun attachToActivityForResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != -1) {
            return
        }
        var temFile: File? = null
        val srcFile: File
        val outPutFile: File? = null
        when (requestCode) {
            CODE_ORIGINAL_PHOTO_CAMERA -> {
                srcFile = File(imgPath)
                Timber.i("attachToActivityForResult outPutFile    " + srcFile.absolutePath)
                //                outPutFile = new File(generateImagePath(mContext));
//                outputUri = Uri.fromFile(outPutFile);
                val imageContentUri = getImageContentUri(mContext, srcFile)
                if (isTailor) {
                    statZoom(srcFile, outPutFile)
                } else {
                    if (imageContentUri != null) {
                        //如果是拍照的,删除临时文件
                        //返回一个压缩后的图片
                        if (isCompressor) {
                            val deBitmap = martixBitmap(decodeUriAsBitmap(imageContentUri))
                            temFile = outputIamge(mContext, compressImage(deBitmap, 50))
                            Timber.i("attachToActivityForResult temFile    " + temFile.absolutePath)
                            outputUri = Uri.fromFile(temFile)
                            //                            if (temFile.exists()){
//                                temFile.delete();
//                            }
                        }
                        if (takeCallBacklistener != null) {
                            takeCallBacklistener!!.successful(true, temFile, outputUri)
                        }
                    }
                }
            }
        }
    }

    /**
     * 缩放法压缩
     * @param bit
     * @return
     */
    private fun martixBitmap(bit: Bitmap?): Bitmap {
        val matrix = Matrix()
        matrix.setScale(0.5f, 0.5f)
        val bm = Bitmap.createBitmap(bit!!, 0, 0, bit.width, bit.height, matrix, true)
        return createScaledBitamp(bm)
    }

    /**
     * 固定尺寸
     * @param bit
     * @return
     */
    fun createScaledBitamp(bit: Bitmap?): Bitmap {
        return Bitmap.createScaledBitmap(bit!!, 120, 200, true)
    }

    private fun statZoom(srcFile: File, outPutFile: File?) {
//        if (isActicity) {
//            mActivity.startActivityForResult(intent, CODE_TAILOR_PHOTO);
//        } else {
//            mFragment.startActivityForResult(intent, CODE_TAILOR_PHOTO);
//        }
    }

    //裁剪根据文件路径获取uri
    private fun getImageContentUri(context: Context, imgFile: File): Uri? {
        val filePath = imgFile.absolutePath
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOf(MediaStore.Images.Media._ID),
            MediaStore.Images.Media.DATA + "=?", arrayOf(filePath), null
        )
        if (cursor != null && cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID))
            val baseUri = Uri.parse("content://media/external/images/media")
            return Uri.withAppendedPath(baseUri, "" + id)
        } else {
            if (imgFile.exists()) {
                val values = ContentValues()
                values.put(MediaStore.Images.Media.DATA, filePath)
                return context.contentResolver.insert(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
                )
            }
        }
        return null
    }

    //    public static Bitmap compressImageToBitmap(Bitmap bmp) {
    //        ByteArrayOutputStream os = new ByteArrayOutputStream();
    //        bmp.compress(Bitmap.CompressFormat.JPEG, 100, os);
    //        if (os.toByteArray().length / 1024 > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
    //            os.reset();//重置baos即清空baos
    //            bmp.compress(Bitmap.CompressFormat.JPEG, 50, os);//这里压缩50%，把压缩后的数据存放到baos中
    //        }
    //        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
    //        BitmapFactory.Options newOpts = new BitmapFactory.Options();
    //        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
    //        newOpts.inJustDecodeBounds = true;
    //        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
    //        Bitmap bitmap = BitmapFactory.decodeStream(is, null, newOpts);
    //        newOpts.inJustDecodeBounds = false;
    //        int w = newOpts.outWidth;
    //        int h = newOpts.outHeight;
    //        float hh = 240f;// 设置高度为240f时，可以明显看到图片缩小了
    //        float ww = 120f;// 设置宽度为120f，可以明显看到图片缩小了
    //        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
    //        int be = 1;//be=1表示不缩放
    //        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
    //            be = (int) (newOpts.outWidth / ww);
    //        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
    //            be = (int) (newOpts.outHeight / hh);
    //        }
    //        if (be <= 0) be = 1;
    //        newOpts.inSampleSize = be;//设置缩放比例
    //        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
    //        is = new ByteArrayInputStream(os.toByteArray());
    //        bitmap = BitmapFactory.decodeStream(is, null, newOpts);
    //        //压缩好比例大小后再进行质量压缩
    ////      return compress(bitmap, maxSize); // 这里再进行质量压缩的意义不大，反而耗资源，删除
    //        return bitmap;
    //    }
    fun setTakePictureCallBackListener(takeCallBacklistener: takePictureCallBackListener?) {
        this.takeCallBacklistener = takeCallBacklistener
    }

    //得到图片回调接口（内部）
    interface takePictureCallBackListener {
        /**
         * 成功回调
         *
         * @param isTailor 是否开启了裁剪
         * @param outFile
         * @param filePath
         */
        fun successful(isTailor: Boolean, outFile: File?, filePath: Uri?)

        /**
         * 失败回调
         *
         * @param errorCode         错误码  0：图片发生错误  1：被拒绝的权限
         * @param deniedPermissions 被拒绝的权限
         */
        fun failed(errorCode: Int, deniedPermissions: List<String?>?)
    }

    private interface PermissionListener {
        fun onGranted()
        fun onDenied(deniedPermissions: List<String?>?)
    }

    init {
        mContext = mActivity
        isActicity = true
        FILE_PROVIDER_AUTHORITY = mActivity.packageName + ".fileprovider"
    }

    /**
     * 根据uri返回bitmap
     *
     * @param uri
     * @return
     */
    fun decodeUriAsBitmap(uri: Uri?): Bitmap? {
        var bitmap: Bitmap? = null
        bitmap = try {
            // 先通过getContentResolver方法获得一个ContentResolver实例，
            // 调用openInputStream(Uri)方法获得uri关联的数据流stream
            // 把上一步获得的数据流解析成为bitmap
            BitmapFactory.decodeStream(
                mContext.contentResolver.openInputStream(
                    uri!!
                )
            )
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return null
        }
        return bitmap
    }

    companion object {
        //拿到未裁剪相片的回调码（拍照后）
        private const val CODE_ORIGINAL_PHOTO_CAMERA = 101

        //拿到未裁剪相片的回调码（选择本地图库后）
        private const val CODE_ORIGINAL_PHOTO_ALBUM = 102

        //拿到已裁剪相片的回调码
        private const val CODE_TAILOR_PHOTO = 103

        /**
         * 返回一张压缩后的图片
         *
         * @param image 原图片
         * @param size  裁剪之后的大小
         * @return
         */
        private fun compressImage(
            image: Bitmap,
            size: Int
        ): Bitmap? {
            val baos = ByteArrayOutputStream()
            image.compress(
                Bitmap.CompressFormat.JPEG,
                40,
                baos
            ) //质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
            var options = 100
            while (baos.toByteArray().size / 1024 > size) {    //循环判断如果压缩后图片是否大于100kb,大于继续压缩
                baos.reset()
                options -= 10
                if (options > 0 || options < 100) {
                    image.compress(
                        Bitmap.CompressFormat.JPEG,
                        options,
                        baos
                    ) //这里压缩options%，把压缩后的数据存放到baos中
                }
            }
            val isBm =
                ByteArrayInputStream(baos.toByteArray()) //把压缩后的数据baos存放到ByteArrayInputStream中
            return BitmapFactory.decodeStream(isBm, null, null)
        }

        //在自定义目录创建图片
        private fun outputIamge(context: Context, bitmap: Bitmap?): File {
            val outputIamge = File(generateImagePath(context))
            Timber.i("attachToActivityForResult outputIamge   " + outputIamge.absolutePath)
            //创建
            try {
                outputIamge.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            var fOut: FileOutputStream? = null
            try {
                fOut = FileOutputStream(outputIamge)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
            if (fOut != null) {
                bitmap!!.compress(Bitmap.CompressFormat.PNG, 60, fOut)
            }
            try {
                fOut!!.flush()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                fOut!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return outputIamge
        }

        private const val ICON_DIR = "icon"
        private const val APP_STORAGE_ROOT = "AndroidNAdaption"

        //产生图片的路径，带文件夹和文件名，文件名为当前毫秒数
        private fun generateImagePath(mContext: Context): String {
            return StorageUtil.getAppDir(
                mContext,
                APP_STORAGE_ROOT,
                ICON_DIR
            ) + System.currentTimeMillis() + ".jpg"
        }
    }
}