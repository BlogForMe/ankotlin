package com.kot.tool.image

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.android.util.viewbind.viewBinding
import com.kot.databinding.ActivityPhotoBasicsBinding
import com.kot.tool.image.util.ImageUtil
import com.kot.tool.image.util.ImageUtil.getVisualMedia
import com.kot.tool.image.util.StorageAccess
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.File

/**
 * Android 14 support
 */
class PhotoBasicsActivity : AppCompatActivity() {

    val TAG = "PhotoBasicsActivity"

    val binding by viewBinding(ActivityPhotoBasicsBinding::inflate)

    private val coroutineScope = MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btPhotoPicker.setOnClickListener {
            requestPermissions.launch(
                arrayOf(
                    Manifest.permission.READ_MEDIA_IMAGES,
//                    Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED,
                )
            )
//
//            selectPhotos()
        }
    }


    val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (ImageUtil.getStorageAccess(this) != StorageAccess.Denied) {
                selectPhotos()
            }
        }


    fun selectPhotos() {
        // Better logic to handle denied & permanently denied access should be written here.
        // We recommend you to look at the {Single Permission} sample
//            if (value != StorageAccess.Denied) {
        coroutineScope.launch {
            val files = getVisualMedia(contentResolver)
            Log.i(TAG, ": $files")
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, files[0].uri)
            binding.ivBanner1.setImageBitmap(bitmap)
            binding.ivBanner1.setImageBitmap(
                MediaStore.Images.Media.getBitmap(
                    contentResolver,
                    files[1].uri
                )
            )
        }
    }


    // deprecated
    private var mImageUriFromFile: Uri? = null
    private var photoURI: Uri? = null
    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchBasicTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    var photoFile: File? = null
    private fun dispatchTakePictureGalleryIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                //                 Create the File where the photo should go
//                photoFile = try {
//                    createImageFile(this)
//                } catch (ex: IOException) {
//                    Timber.e("createImageFile ${ex.message}")
//                    // Error occurred while creating the File
////                    throw  IOException(ex.message)
//                    null
//                }

                val fileProviderName = "$packageName.fileprovider"
                photoFile?.also {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //7.0以上要通过FileProvider将File转化为Uri
                        photoURI = FileProvider.getUriForFile(this, fileProviderName, it)
                    } else {
                        photoURI = Uri.fromFile(it)
                    }
//                    Timber.i("photoURI ${photoURI.path}")
                    mImageUriFromFile = Uri.fromFile(photoFile)

                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            //            data?.extras?.let {
//            //                val imageBitmap = it.get("data") as Bitmap
//            //                img_show.setImageBitmap(imageBitmap)
//            //            }
//            //如果拍照成功，将Uri用BitmapFactory的decodeStream方法转为Bitmap
//            val imageBitmap = BitmapFactory.decodeStream(photoURI?.let {
//                contentResolver.openInputStream(
//                    it
//                )
//            })
////              photoURI?.let { galleryAddPic(it) }
////              galleryAddPic(mImageUriFromFile)
////              img_show.setImageBitmap(imageBitmap)
//
//        }
//    }


    //不起作用
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            val selectedImage = data?.data
//            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
//            val cursor =
//                selectedImage?.let { contentResolver.query(it, filePathColumn, null, null, null) }
//
//            cursor?.moveToFirst()
//            val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
//            val picturePath = columnIndex?.let { cursor?.getString(it) }
//            cursor?.close()
//            val bitmap = BitmapFactory.decodeFile(picturePath)
//            img_show.setImageBitmap(bitmap)
//        }
//    }


//    private fun galleryAddPic(uri:Uri?) {
//        Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
////            val f = File(currentPhotoPath)
//            mediaScanIntent.data = uri
//            sendBroadcast(mediaScanIntent)
//        }
//    }


    /**
     * 将拍的照片添加到相册
     *
     * @param uri 拍的照片的Uri
     */
    private fun galleryAddPic(uri: Uri?) {
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri)
        sendBroadcast(mediaScanIntent)
    }

//    fun galleryAddPic(){
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
//           this.revokeUriPermission(contentUri,
//                Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//        val storageDir;
//        if (mSpec.captureStrategy.isPublic) {
//            storageDir = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//            if (!storageDir.exists()) storageDir.mkdirs();
//        } else {
//            storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        }
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        Uri storageUri = Uri.fromFile(storageDir);
//        mediaScanIntent.setData(storageUri);
//        sendBroadcast(mediaScanIntent);
//        finish();
//    }
//    }

}
