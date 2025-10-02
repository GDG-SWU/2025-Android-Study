package com.example.viewmodel02

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ViewModel02.R
import com.example.ViewModel02.databinding.FragmentTestBinding

//fragment 라이프사이클 관련 링크
// https://developer.android.com/guide/fragments/lifecycle

class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding

    var countValue = 0

    private lateinit var viewmodel : TestFragmentViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TestFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TestFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        Log.d("TestFragment", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        viewmodel = ViewModelProvider(this).get(TestFragmentViewModel::class.java)

        binding.resultArea.text= viewmodel.getCount().toString()

        //viewmodel 사용 plus minus 버튼
        binding.plus.setOnClickListener{
            viewmodel.plus()
            binding.resultArea.text= viewmodel.getCount().toString()
//            countValue++
//            binding.resultArea.text = countValue.toString()
        }

        binding.minus.setOnClickListener{
            viewmodel.minus()
            binding.resultArea.text= viewmodel.getCount().toString()
//            countValue--
//            binding.resultArea.text = countValue.toString()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("TestFragment", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TestFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TestFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TestFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TestFragment", "onDetach")
    }


}