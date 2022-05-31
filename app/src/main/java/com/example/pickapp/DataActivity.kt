package com.example.pickapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pickapp.room.Constant
import com.example.pickapp.room.Data
import com.example.pickapp.room.DataDb
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataActivity : AppCompatActivity() {
    val db by lazy { DataDb(this) }
    lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setupListener()
        setupRecyclerView()

        //intent dari firstmileactivity ke add activity
        /*val intentButton: Button = findViewById(R.id.btn_add)
        intentButton.setOnClickListener { viewDetail() }*/
    }

    private fun setupListener() {
        btn_add.setOnClickListener{
            intentEdit(0,Constant.TYPE_CREATE)
        }
    }

    //fungsi intent eedit
    fun intentEdit (dataId: Int, intentType: Int){
        startActivity(
            Intent(applicationContext, AddActivity::class.java)
                .putExtra("intent_id", dataId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun setupRecyclerView() {
        dataAdapter = DataAdapter(arrayListOf(), object : DataAdapter.OnAdapterListener{
            override fun onClick(data: Data) {
                //Toast.makeText(applicationContext, data.code, Toast.LENGTH_SHORT).show()
                /*startActivity(
                    Intent(applicationContext, AddActivity::class.java)
                        .putExtra("intent_id",data.id)
                )*/
                //membaca detail data
                intentEdit(data.id,Constant.TYPE_READ)
            }

            override fun onUpdate(data: Data) {
                intentEdit(data.id,Constant.TYPE_UPDATE)
            }

            override fun onDelete(data: Data) {
                deleteDialog(data)
            }
        })
        rv_data.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = dataAdapter
        }
    }

    //fungsi intent
    private fun viewDetail() {
        val intent = Intent(this,AddActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    fun loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            val datas = db.dataDao().getDatas()
            Log.d("DataActivity", "dbresponse: $datas")
            withContext(Dispatchers.Main){
                dataAdapter.setData(datas)
            }
        }
    }

    private fun deleteDialog(data : Data){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Confirmation")
            setMessage("Delete data: ${data.code}?")
            setNegativeButton("Cancel") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Delete") { dialogInterface, i ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.dataDao().deleteData(data)
                    loadData()
                }
            }
        }
        alertDialog.show()
    }
}