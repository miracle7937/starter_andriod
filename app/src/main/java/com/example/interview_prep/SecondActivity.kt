package com.example.interview_prep

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interview_prep.retrofit.APIClient
import com.example.interview_prep.retrofit.APiInterface
import com.example.interview_prep.retrofit.ResponseData
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity(), CellClickListener  {
    lateinit var baseView:BaseView;
    lateinit var itemRecylerAdapter:ItemRecylerAdapter;





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title ="User Data"
        setContentView(R.layout.activity_second)
        baseView = BaseView()
        baseView.fetData();
        val recyclerView: RecyclerView = findViewById(R.id.rvContacts)
        baseView.resultLiveData.observe(this){
           if(it !=null){
               itemRecylerAdapter = ItemRecylerAdapter(it, this)
               val layoutManager = LinearLayoutManager(applicationContext)
               recyclerView.layoutManager = layoutManager
               recyclerView.itemAnimator = DefaultItemAnimator()
               recyclerView.adapter = itemRecylerAdapter
           }
        }


    }





class BaseView :ViewModel(){
    private val  _data = MutableLiveData<List<ResponseData?>>()
    val resultLiveData: LiveData<List<ResponseData?>> = _data;
    fun  fetData(){
        val call = APIClient().getClient().create(APiInterface::class.java).getData();
        CoroutineScope(Dispatchers.IO).launch {
            call?.clone()?.enqueue(object : Callback<List<ResponseData?>?>{
                override fun onResponse(
                    call: Call<List<ResponseData?>?>?,
                    response: Response<List<ResponseData?>?>?
                ) {
                    _data.postValue(response?.body())

                }

                override fun onFailure(call: Call<List<ResponseData?>?>?, t: Throwable?) {
                    println(t?.message.toString())
                }


            })
        }

    }
}

    override fun onCellClickListener(data: ResponseData?) {
        println("helllo");

    }
}



