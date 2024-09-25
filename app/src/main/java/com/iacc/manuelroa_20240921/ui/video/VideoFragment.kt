package com.iacc.manuelroa_20240921.ui.video

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.iacc.manuelroa_20240921.databinding.VideoLayoutBinding

class VideoFragment : Fragment() {

    private var _binding: VideoLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = VideoLayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val videoView = binding.videoView
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)


        val videoUri = Uri.parse("android.resource://${requireContext().packageName}/raw/video")  // Video desde res/raw

        //val videoUri = Uri.parse("https://www.youtube.com/watch?v=ECw3gVvW2Zk&ab_channel=DavidNewman")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
