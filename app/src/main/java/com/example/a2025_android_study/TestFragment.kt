package com.example.a2025_android_study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a2025_android_study.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    // Fragment 뷰바인딩 객체 선언
    // _binding은 nullable로 선언, binding은 안전을 위해 non-null get() 사용
//    private var _binding : FragmentTestBinding? = null
//    private val binding get() = _binding!!

    // DataBinding 객체 선언
    lateinit var binding : FragmentTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        // 뷰바인딩 초기화
//        _binding = FragmentTestBinding.inflate(inflater, container, false)
//        // 루트 뷰 가져오기
//        val view = binding.root
//
//        // 바인딩 객체를 통해 뷰에 접근 및 설정
//        binding.fragmentText.text = "이거는 fragment Text"
//
//        return view

        // 데이터바인딩 초기화
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        // 바인딩 객체를 통해 뷰에 접근
        binding.fragmentText.text = "변경된 텍스트"

        return binding.root
    }
//
//    // 메모리 누수 방지를 위해 onDestroyView에서 바인딩 해제
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}