package com.kot.tool.image.util

import android.Manifest
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import android.provider.MediaStore.Files
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * ClassName:      ImageUtil
 * Description:    Description
 * Author:         zh
 * CreateDate:     11/19/23 18:26
 * UpdateUser:     zh
 * UpdateDate:     11/19/23 18:26
 * UpdateRemark:   Modify the description
 */

object ImageUtil {

    fun getStorageAccess(context: Context): StorageAccess {
        return if (
            ContextCompat.checkSelfPermission(
                context,
                READ_MEDIA_IMAGES
            ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                context,
                READ_MEDIA_VIDEO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Full access on Android 13+
            StorageAccess.Full
        } else if (
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Partial access on Android 13+
            StorageAccess.Partial
        } else if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Full access up to Android 12
            StorageAccess.Full
        } else {
            // Access denied
            StorageAccess.Denied
        }
    }


    /**
     * Query [MediaStore] through [ContentResolver] to get all images & videos sorted by most added date
     * by targeting the [Files] collection
     */
    suspend fun getVisualMedia(contentResolver: ContentResolver): List<FileEntry> {
        return withContext(Dispatchers.IO) {
            // List of columns we want to fetch
            val projection = arrayOf(
                Files.FileColumns._ID,
                Files.FileColumns.DISPLAY_NAME,
                Files.FileColumns.SIZE,
                Files.FileColumns.MIME_TYPE,
                Files.FileColumns.DATE_ADDED,
            )

            val collectionUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // This allows us to query all the device storage volumes instead of the primary only
                Files.getContentUri(MediaStore.VOLUME_EXTERNAL)
            } else {
                Files.getContentUri("external")
            }

            val visualMedia = mutableListOf<FileEntry>()

            contentResolver.query(
                // Queried collection
                collectionUri,
                // List of columns we want to fetch
                projection,
                // Filtering parameters (in this case [MEDIA_TYPE] column)
                "${Files.FileColumns.MEDIA_TYPE} = ? OR ${Files.FileColumns.MEDIA_TYPE} = ?",
                // Filtering values (in this case image or video files)
                arrayOf(
                    Files.FileColumns.MEDIA_TYPE_IMAGE.toString(),
                    Files.FileColumns.MEDIA_TYPE_VIDEO.toString(),
                ),
                // Sorting order (recent -> older files)
                "${Files.FileColumns.DATE_ADDED} DESC",
            )?.use { cursor ->
                val idColumn = cursor.getColumnIndexOrThrow(Files.FileColumns._ID)
                val displayNameColumn = cursor.getColumnIndexOrThrow(Files.FileColumns.DISPLAY_NAME)
                val sizeColumn = cursor.getColumnIndexOrThrow(Files.FileColumns.SIZE)
                val mimeTypeColumn = cursor.getColumnIndexOrThrow(Files.FileColumns.MIME_TYPE)
                val dateAddedColumn = cursor.getColumnIndexOrThrow(Files.FileColumns.DATE_ADDED)

                while (cursor.moveToNext()) {
                    val uri = ContentUris.withAppendedId(collectionUri, cursor.getLong(idColumn))
                    val name = cursor.getString(displayNameColumn)
                    val size = cursor.getLong(sizeColumn)
                    val mimeType = cursor.getString(mimeTypeColumn)
                    val dateAdded = cursor.getLong(dateAddedColumn)

                    visualMedia.add(FileEntry(uri, name, size, mimeType, dateAdded))
                }
            }

            return@withContext visualMedia
        }
    }
}


/**
 * On Android 14+ devices, users can grant full or partial access to their photo library for apps
 * requesting [READ_MEDIA_IMAGES] and/or [READ_MEDIA_VIDEO] permissions.
 * On older devices, the photo library access can either be full or denied
 */
enum class StorageAccess {
    Full, Partial, Denied
}