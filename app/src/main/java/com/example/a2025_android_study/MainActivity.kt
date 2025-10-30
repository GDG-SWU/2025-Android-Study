package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a2025_android_study.databinding.ActivityMainBinding

//14강 LiveData

//livedata

//데이터를 관찰해줄 수 있는 친구 (life  cyccle과 결합해서)

//class MainActivity : AppCompatActivity() {
//
//    private var testMutableLiveData = MutableLiveData(0) //초기값0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        findViewById<Button>(R.id.btnArea).setOnClickListener {
//            testMutableLiveData.value = testMutableLiveData.value!!.plus(1) //
//        }
//
//        //변화되는거 관찰
//        //licedata가 변화할 때마다 실행됨 (logcat에 기록됨)
//
//        testMutableLiveData.observe(this, Observer {
//            Log.d("testMutableLiveData", testMutableLiveData.value.toString())
//            findViewById<TextView>(R.id.textArea).text = testMutableLiveData.value.toString()
//        })
//    }
//}



//15강
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var viewModel: MainViewModel
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
//
//        findViewById<Button>(R.id.btnArea).setOnClickListener{
//            viewModel.plusLiveDataValue()
//        }
//
//
//
//        //변화되는거 관찰
//        //licedata가 변화할 때마다 실행됨 (logcat에 기록됨)
//
//        viewModel.testMutableLiveData.observe(this, Observer {
//            findViewById<TextView>(R.id.textArea).text=viewModel.testMutableLiveData.value.toString()
//
//        })
//    }
//}


//16강
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var viewModel: MainViewModel
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
//
//        findViewById<Button>(R.id.btnArea).setOnClickListener{
//            viewModel.plusLiveDataValue()
//        }
//
//
//
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        findViewById<Button>(R.id.btnArea).setOnClickListener {
//            viewModel.plusLiveDataValue()
//        }
//
//        viewModel.testLiveData.observe(this, Observer {
//            findViewById<TextView>(R.id.textArea).text = it.toString()
//        })
//
//        //viewModel.testLiveData.value=10  //라이브 데이터는 외부에서 값 가져오는거 안 됨
////
////
////
////        //변화되는거 관찰
////        //licedata가 변화할 때마다 실행됨 (logcat에 기록됨)
////
////        viewModel.testMutableLiveData.observe(this, Observer {
////            findViewById<TextView>(R.id.textArea).text=viewModel.testMutableLiveData.value.toString()
////
////        })
////
////        viewModel.testMutableLiveData.value=10  //초기값 10
//    }
//}


//17강,18강


// Fragment LiveData/viewLifecyclerOwner

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivityMainBinding
//
//    val manager = supportFragmentManager
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        binding.btn1.setOnClickListener {
//            val transaction1 = manager.beginTransaction()
//            val fragment1 = BlankFragment1()
//            transaction1.replace(R.id.frameArea, fragment1)
//            transaction1.addToBackStack(null)
//            transaction1.commit()
//        }
//
//        binding.btn2.setOnClickListener {
//            val transaction2 = manager.beginTransaction()
//            val fragment2 = BlankFragment2()
//            transaction2.replace(R.id.frameArea, fragment2)
//            transaction2.addToBackStack(null)
//            transaction2.commit()
//        }
//
//
//
//    }
//}



//19강


// LiveData Transformations

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel: MainViewModel
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//// ✅ 수정된 코드 (명시적 캐스팅):
//        //val binding: ActivityMainBinding = setContentView(this, R.layout.activity_main) as ActivityMainBinding   //이거 오류나서 아래로 수정함
//        // ✅ DataBindingUtil 대신 ActivityMainBinding.inflate() 사용 (캐스팅 불필요)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root) // binding.root를 사용하여 뷰 설정
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        viewModel.liveCount.observe(this, Observer {
//
//            binding.resultArea1.text = (it + it).toString()
//            binding.resultArea2.text = (it * it).toString()
//        })
//
//        //버튼 누르면 어떻게 할건지
//        binding.btnArea.setOnClickListener {
//            val count = binding.inputArea.text.toString().toInt()
//            viewModel.setLiveDataValue(count)
//        }
//
//
//    }
//}
//
//

// LiveData Transformations


//20강
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel: MainViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root) // binding.root를 사용하여 뷰 설정
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        viewModel.liveCount.observe(this, Observer {
//            // binding.resultArea1.text = (it + it).toString()
//            // binding.resultArea2.text = (it * it).toString()
//        })
//
//        viewModel.mapLiveData.observe(this, Observer {
//            binding.resultArea1.text = it.toString()
//        })
//
//        viewModel.switchMapLiveData.observe(this, Observer {
//            binding.resultArea2.text = it.toString()
//        })
//
//        binding.btnArea.setOnClickListener {
//            val count = binding.inputArea.text.toString().toInt()
//            viewModel.setLiveDataValue(count)
//        }
//
//
//    }
//}



//21rkd

// LiveData + DataBinding + ViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.next.setOnClickListener {
            viewModel.getNextData()
        }



    }
}