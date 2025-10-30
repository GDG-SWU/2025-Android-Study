package com.example.a2025_android_study

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//16강...?
//복잡해지면 뷰모델로 따로 빼놓는게 좋음
//class MainViewModel : ViewModel() {
//
//    //라이브 데이터 사용
//    private var testMutableLiveData = MutableLiveData(0)
//
//
//    val testLiveData : LiveData<Int>   //얘만 새로 생김, 이번에는 얘를 관찰함
//        get()= testMutableLiveData
//
//    fun plusLiveDataValue(){
//        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)  //1씩 증가
//
//    }
//
////    var testMutableLiveData = MutableLiveData(0)
////
////    fun plusLiveDataValue(){
////        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)  //1씩 증가
////    }
//}
//
////MutableLiveData<->LiveData



//19강
//
//class MainViewModel : ViewModel() {
//
//    // Transformations
//
//    private var _mutableCount = MutableLiveData(0)
//    val liveCount : LiveData<Int>
//        get() = _mutableCount
//
//
//    fun setLiveDataValue(count : Int) {
//        _mutableCount.value = count
//    }
//
//}


//class MainViewModel : ViewModel() {
//
//    // Transformations -> map / switchMap
//
//    // map -> 값을 return
//
//    private var _mutableCount = MutableLiveData(0)
//    val liveCount : LiveData<Int>
//        get() = _mutableCount
//
//    val mapLiveData = Transformations.map(liveCount) {
//        it+it
//    }
//
//    val switchMapLiveData = Transformations.switchMap(liveCount) {
//        changeValue(it)
//    }
//
//    fun setLiveDataValue(count : Int) {
//        _mutableCount.value = count
//    }
//
//    fun changeValue(count : Int) : MutableLiveData<Int> {
//        val testLiveData = MutableLiveData(count*count)
//        return testLiveData
//    }
//
//
//}




// LiveData + DataBinding + ViewModel

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivityMainBinding
//    private lateinit var viewModel: MainViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        binding.vm = viewModel
//        binding.lifecycleOwner = this
//
//        binding.next.setOnClickListener {
//            viewModel.getNextData()
//        }
//
//
//
//    }
//}


//21rkd
class MainViewModel : ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
        get() = _mutableWord

    private var _randomMutableWord = MutableLiveData("")
    val randomLiveWord : LiveData<String>
        get() = _randomMutableWord


    init {
        getNextData()
    }

    fun getNextData(){

        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)

    }

    fun getRandomWordShuffled(word : String) : MutableLiveData<String> {

        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)
        return liveData

    }


}


