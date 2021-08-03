package aslam.junaid.aslamagency.util

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*

private const val DEFAULT_IMAGE_DIR = "images"
private const val IMAGE_EXTENSION = ".jpg"

class ImageUtils(private var context: Context) {

    fun loadImageFromInternalStorage(imageName: String): Drawable? {
        val cw = ContextWrapper(this.context)
        val directory = cw.getDir(DEFAULT_IMAGE_DIR, Context.MODE_PRIVATE)
        val file = File(directory, imageName)
        return Drawable.createFromPath(file.toString())
    }

    fun deleteImageInInternalStorage(imageName: String): Boolean {
        val cw = ContextWrapper(this.context)
        val directory = cw.getDir(DEFAULT_IMAGE_DIR, Context.MODE_PRIVATE)
        val file = File(directory, imageName)
        return file.delete()
    }

    fun listImageFiles(): MutableList<String> {
        val cw = ContextWrapper(this.context)
        val directory = cw.getDir(DEFAULT_IMAGE_DIR, Context.MODE_PRIVATE)
        val list = mutableListOf<String>()
        val files = directory.listFiles()
        if (files != null) {
            for (file in files) {
                if (file != null) {
                    list.add(file.absolutePath.substringAfterLast("/"))
                }
            }
        }
        return list
    }

    // Method to save an image to internal storage
    fun saveImageToInternalStorage(bitmap: Bitmap, compPercent: Int) : Uri {
//        // Get the image from drawable resource as drawable object
//        val drawable = ContextCompat.getDrawable(requireContext(),drawableId)

//        // Get the bitmap from drawable object
//        val bitmap = (drawable as BitmapDrawable).bitmap

        // Get the context wrapper instance
        val wrapper = ContextWrapper(this.context)

        // Initializing a new file
        // The bellow line return a directory in internal storage
        var file = wrapper.getDir(DEFAULT_IMAGE_DIR, Context.MODE_PRIVATE)

        // Create a file to save the image
        file = File(file, "${UUID.randomUUID()}$IMAGE_EXTENSION")

        try {
            // Get the file output stream
            val stream: OutputStream = FileOutputStream(file)

            // Compress bitmap
            bitmap.compress(Bitmap.CompressFormat.JPEG, compPercent, stream)

            // Flush the stream
            stream.flush()

            // Close stream
            stream.close()
        } catch (e: IOException){ // Catch the exception
            e.printStackTrace()
        }
        // Return the saved image uri
        return Uri.parse(file.absolutePath)
    }

    fun uriToBitmap(uri: Uri?): Bitmap {
        lateinit var bitmap: Bitmap
        try {
            uri?.let {
                bitmap = if (Build.VERSION.SDK_INT < 28) {
                    MediaStore.Images.Media.getBitmap(
                        this.context.contentResolver,
                        uri
                    )
                } else {
                    val source = ImageDecoder.createSource(
                        this.context.contentResolver, uri
                    )
                    ImageDecoder.decodeBitmap(source)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }
}
