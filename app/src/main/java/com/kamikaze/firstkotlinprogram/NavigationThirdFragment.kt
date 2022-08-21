package com.kamikaze.firstkotlinprogram

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kamikaze.firstkotlinprogram.databinding.FragmentNavigationThirdBinding
import kotlinx.android.synthetic.main.fragment_navigation_third.*
import java.io.File


class NavigationThirdFragment : Fragment() {
    private lateinit var binding: FragmentNavigationThirdBinding
     var permission = 0
private   var requestPermissionLancher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
  permission =  if (it){
1
    }else{0}
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_navigation_third, container, false)
        binding.Submit.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_navigationThirdFragment_to_navigationFirstFragment)
        }

        binding.appCompatButton4.setOnClickListener {
            requestPermissionLancher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (permission == 1){
                var url23 = linkdownload.text.toString()
                downloadimage(url23 , "Image Download")
            }


        }
        return binding.root
    }

    private fun downloadimage(url: String, title: String) {
        try {
            var downloadmanger =
                activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
            val link = Uri.parse(url)
            var request = DownloadManager.Request(link)
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
                .setMimeType("image/jpeg").setAllowedOverRoaming(false)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_PICTURES,
                    File.separator + title + ".jpg"
                )
            if (downloadmanger != null) {
                downloadmanger.enqueue(request)
            }


        } catch (e: Exception) {
            Toast.makeText(activity, "Error occurred $e", Toast.LENGTH_LONG).show()
        }
    }


}