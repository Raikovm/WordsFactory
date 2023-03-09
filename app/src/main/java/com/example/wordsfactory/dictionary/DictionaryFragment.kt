package com.example.wordsfactory.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsfactory.databinding.FragmentDictionaryBinding

class DictionaryFragment : Fragment() {

    private var _binding: FragmentDictionaryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[DictionaryViewModel::class.java]

        _binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val dictionaryMeaningItemsAdapter = DictionaryItemAdapter(
            listOf(
                DictionaryItem(
                    meaning = "The practice or skill of preparing food by combining, mixing, and heating ingredients. \n" +
                            "Example: he developed an interest in cooking."
                ),
                DictionaryItem(
                    meaning = "The practice or skill of preparing food by combining, mixing, and heating ingredients. \n" +
                            "Example: he developed an interest in cooking."
                )
            )

        )

        binding.recyclerViewDictionary.layoutManager = LinearLayoutManager(root.context)
        binding.recyclerViewDictionary.adapter = dictionaryMeaningItemsAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}