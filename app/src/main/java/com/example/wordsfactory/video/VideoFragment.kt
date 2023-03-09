package com.example.wordsfactory.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.wordsfactory.R
import com.example.wordsfactory.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[VideoViewModel::class.java]

        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.videoWebView.webViewClient = VideoFragmentWebView()
        binding.videoWebView.loadUrl(getString(R.string.video_link_full))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}