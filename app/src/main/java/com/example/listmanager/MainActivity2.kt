package com.example.listmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var displayMotorcycle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        displayMotorcycle = findViewById(R.id.displayMotorcycle)
        val intent = intent
        var mMake = intent.getStringExtra("mMake" )
        var mId = intent.getIntExtra("mId",0)
        var mModel = intent.getStringExtra("mModel")
        var mSize = intent.getIntExtra("mSize",0)

        var items = String.format("Id: $mId\nModel: $mModel\nMake: $mMake\nEngine Size: $mSize\n")
        displayMotorcycle.text = items


    }

}