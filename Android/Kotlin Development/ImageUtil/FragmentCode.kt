
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import aslam.junaid.aslamagency.databinding.FragmentCustomerBinding
import aslam.junaid.aslamagency.util.ImageUtils

// image pick code
private const val IMAGE_PICK_CODE = 1000
private const val RECORD_REQUEST_CODE = 1001
private const val CAMERA_REQUEST_CODE = 1002


class CustomerFragment : Fragment() {

    private lateinit var viewModelFactory: CustomerViewModelFactory
    private val viewModel: CustomerViewModel by viewModels(
        factoryProducer = { viewModelFactory }
    )

    private var _binding: FragmentCustomerBinding? = null
    // This property only valid between onCreateView and onDestroyView
    private val binding get()= _binding!!

    private lateinit var imageUtils: ImageUtils

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerBinding.inflate(inflater, container, false)
        viewModelFactory = CustomerViewModelFactory()    // Pass args to it if required
        imageUtils = ImageUtils(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewStateObserver = Observer<CustomerViewState> { viewState ->
            // update the UI
            binding.textCustomer.text = viewState.text
            binding.customerImageTest.setImageURI(viewState.customerIconUri)

            binding.customerAddImage.setOnClickListener {
                pickImageFromGallery()
            }

            binding.fabTakePic.setOnClickListener {
                pickImageFromCamera()
            }

            binding.fabLoadStorage.setOnClickListener {
                loadFirstImagePresent()
            }

            binding.fabDeleteLast.setOnClickListener {
                deleteLastImage()

            }
        }
        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)
    }

    private  fun loadFirstImagePresent() {
        val listImages = imageUtils.listImageFiles()
        if (listImages.isNotEmpty()) {
            binding.customerImageTest.setImageDrawable(
                imageUtils.loadImageFromInternalStorage(listImages[0]))
        }
    }

    private fun deleteLastImage() {
        var listFiles = imageUtils.listImageFiles()
        println("Mutable List Size: ${listFiles.size}")
        if (listFiles.isNotEmpty()) {
            println("Delete Image: $listFiles[0]")
            imageUtils.deleteImageInInternalStorage(listFiles[0])
            println("Deleted List")
            listFiles = imageUtils.listImageFiles()
            println(listFiles)
        } else {
            println("List file is empty")
        }
        loadFirstImagePresent()
    }

    private fun pickImageFromCamera() {
        val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
    }

    private fun startGalleryIntent() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    private fun pickImageFromGallery() {
        // check permission for WRITE_STORAGE
        val permission = ContextCompat.checkSelfPermission(requireContext(),
            Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(requireContext(), "Permission Deneid", Toast.LENGTH_SHORT).show()
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                RECORD_REQUEST_CODE)
        } else {
            startGalleryIntent()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

        when (requestCode) {
            RECORD_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0]
                    != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(requireContext(),
                        "Permission has been denied by USER", Toast.LENGTH_SHORT).show()

                } else {
                    startGalleryIntent()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            if(requestCode == IMAGE_PICK_CODE || requestCode == CAMERA_REQUEST_CODE) {
                lateinit var bitmap: Bitmap
                var compPercent = 100
                when (requestCode) {
                    IMAGE_PICK_CODE -> {
                        bitmap = imageUtils.uriToBitmap(data.data)
                        compPercent = 10
                    }
                    CAMERA_REQUEST_CODE -> {
                        bitmap = data.extras?.get("data") as Bitmap
                    }
                }

                val newUri = imageUtils.saveImageToInternalStorage(bitmap, compPercent)
                binding.textCustomer.text = newUri.path
                binding.customerImageTest.setImageBitmap(bitmap)

            }

        }
    }
}