package com.example.a2025_android_study

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.a2025_android_study.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {

    private val TAG = "BlankFragment1"

    private var _binding : FragmentBlank1Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel1: BlankViewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        val view = binding.root

        viewModel1 = ViewModelProvider (this).get(BlankViewModel1::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            viewModel1.plusCountValue()
        }

        viewModel1.liveCount.observe(viewLifecycleOwner, Observer{
            binding.text1.text = it.toString()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "OnDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy")
    }

}