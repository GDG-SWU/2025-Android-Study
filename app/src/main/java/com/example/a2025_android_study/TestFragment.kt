package com.example.a2025_android_study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a2025_android_study.databinding.FragmentTestBinding


class TestFragment : Fragment() {

    lateinit var binding : FragmentTestBinding


//    private var _binding : FragmentTestBinding? = null
//    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


//        _binding = FragmentTestBinding.inflate(inflater, container, false)
//        val view = binding.root



//2-4
//        binding.fragmentText.text="이거는 fragment Txt"



//        return view

        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_test,container,false)

        binding.fragmentText.text = "변경된 텍스트"

        return binding.root

        //return inflater.inflate(R.layout.fragment_test, container, false)
    }

}