package com.example.listmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.content.Intent
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: RVAdapter
    private lateinit var addBtn: FloatingActionButton
    private lateinit var removeBtn: FloatingActionButton


    val newList = changeList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        rvAdapter = RVAdapter()
        recyclerView.adapter = rvAdapter

        addBtn = findViewById(R.id.addingBtn)
        addBtn.setOnClickListener({addMoto()})
        removeBtn = findViewById(R.id.subtractionBtn)
        removeBtn.setOnClickListener({removeMoto()})

        newList.createList()


    }


    fun addMoto(){
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item, null)

        val mId = v.findViewById<EditText>(R.id.idView)
        val mMake = v.findViewById<EditText>(R.id.makeView)
        val mModel = v.findViewById<EditText>(R.id.modelView)
        val mSize = v.findViewById<EditText>(R.id.engineView)

        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
            dialog,_->
            val newId = mId.text.toString()
            val newMake = mMake.text.toString()
            val newModel = mModel.text.toString()
            val newSize = mSize.text.toString()
            newList.addToList(newId+","+newMake+","+newModel+","+newSize)
            RVAdapter() .notifyDataSetChanged()

            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
        }
        addDialog.create()
        addDialog.show()
    }
    fun removeMoto(){
        val inflter = LayoutInflater.from(this)
        val w = inflter.inflate(R.layout.remove_item, null)

        val removeId = w.findViewById<EditText>(R.id.removeIdView)

        val subDialog = AlertDialog.Builder(this)
        subDialog.setView(w)
        subDialog.setPositiveButton("Ok"){
                dialog,_->
            val newId = removeId.text.toString().toInt()
            val pos = newList.getItemById(newId)
            newList.deleteFromList(newId)
            rvAdapter.notifyDataSetChanged()

            dialog.dismiss()
        }
        subDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
        }
        subDialog.create()
        subDialog.show()

    }
    inner class RVAdapter() : RecyclerView.Adapter<RVAdapter.ItemHolder>() {

        inner class ItemHolder(itemView: View) : ViewHolder(itemView) {
            var itemTextView: TextView

            init {
                itemTextView = itemView as TextView

                itemTextView.setOnClickListener { v: View ->
                    val pos: Int = adapterPosition
                    Toast.makeText(
                        itemTextView.context, newList.motorcycleList[pos].model, Toast.LENGTH_SHORT
                    ).show()
                    val mId = newList.getItemByIndex(pos).ID
                    val mMake = newList.getItemByIndex(pos).make
                    val mModel = newList.getItemByIndex(pos).model
                    val mSize = newList.getItemByIndex(pos).engineCC
                    val intent = Intent(this@MainActivity,MainActivity2::class.java)
                    intent.putExtra("mId",mId)
                    intent.putExtra("mMake",mMake)
                    intent.putExtra("mModel",mModel)
                    intent.putExtra("mSize",mSize)
                    startActivity(intent)
                }

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val v: View = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ItemHolder(v)
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            val item = newList.getItemByIndex(position).model
            val motId = newList.getItemByIndex(position).ID
            holder.itemTextView.text = "ID: " +motId.toString() +",    " + item


        }

        override fun getItemCount(): Int {
            return newList.motorcycleList.size
        }

    }



}