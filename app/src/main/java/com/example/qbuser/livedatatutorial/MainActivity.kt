package com.example.qbuser.livedatatutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.qbuser.livedatatutorial.models.Words
import com.example.qbuser.livedatatutorial.viewmodels.wordviewmodel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    lateinit var viewmodel:wordviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            textView.text = textView.text.toString()+"\n " + editText.text.toString()
            var a = Words()
            a.name = editText.text.toString()
            Thread{
                viewmodel.insertword(a)
            }.start()

        }
        var allword: List<Words>

        Thread{
            viewmodel = wordviewmodel(this.application)
        }.start()

        Thread.sleep(1000)

        loadDataFromDb()



    }

    fun loadDataFromDb(){
        Thread{

            textView.text = null
            var allword = viewmodel.getallword()
            allword.forEach {
                textView.text = textView.text.toString() + "\n" + it.name
            }
        }.start()
    }
}
