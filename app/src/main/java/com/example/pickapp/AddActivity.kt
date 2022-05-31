package com.example.pickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pickapp.room.Constant
import com.example.pickapp.room.Data
import com.example.pickapp.room.DataDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    val db by lazy {DataDb(this)}
    private var dataId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupListener()
        setupView()
        //Toast.makeText(this, dataId, Toast.LENGTH_SHORT).show()
    }

    //fungsi setup view
    fun setupView(){
        val intentType = intent.getIntExtra("intent_type", 0)
        when(intentType){
            Constant.TYPE_CREATE -> {
                btn_update.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                btn_save.visibility = View.GONE
                btn_update.visibility = View.GONE
                getData()
            }
            Constant.TYPE_UPDATE -> {
                btn_save.visibility = View.GONE
                getData()
            }
        }
    }

    fun setupListener() {
        btn_save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.dataDao().addData(
                    Data(
                        0, etCode.text.toString(),
                        etFactory.text.toString(),
                        etDsitribution.text.toString()
                    )
                )
                finish()
            }
        }
        btn_update.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.dataDao().updateData(
                    Data(
                        dataId, etCode.text.toString(),
                        etFactory.text.toString(),
                        etDsitribution.text.toString()
                    )
                )
                finish()
            }
        }
    }

    fun getData(){
        dataId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val datas = db.dataDao().getData(dataId)[0]
            etCode.setText( datas.code )
            etFactory.setText( datas.factory )
            etDsitribution.setText( datas.distribution )
        }
    }
}