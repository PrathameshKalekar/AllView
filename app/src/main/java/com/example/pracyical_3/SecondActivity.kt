package com.example.pracyical_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class SecondActivity : AppCompatActivity() {
    private lateinit var builder : AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val text = findViewById<TextView>(R.id.getTxtFromActivityOne)
        val bundle = intent.extras
        if (bundle != null){
            text.text = "Hello ${bundle.getString("Name")}"
        }

        val listText = findViewById<TextView>(R.id.txtListSelected)
        val list = findViewById<ListView>(R.id.listView)
        val name = arrayOf("Football","Cricket","Bascketball","Kho-Kho")
        list.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,name)
        list.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"You Selected ${name[i]}",Toast.LENGTH_SHORT).show()
            listText.text = "Your favrate sport is ${name[i]}"
        }

        val spinner = findViewById<Spinner>(R.id.ageSpinner)
        val ageTxt = findViewById<TextView>(R.id.txtAge)
         val ageNo = arrayOf("15","16","17","18","19","20")
        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,ageNo)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                ageTxt.text = " Your Age Is ${ageNo.get(position)}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        builder = AlertDialog.Builder(this)
        val submit =  findViewById<Button>(R.id.btnSubmitLast)
        submit.setOnClickListener {
            builder.setTitle("Confirm")
                .setMessage("You want to submit ?")
                .setCancelable(true)
                .setPositiveButton("Yes"){ dialogInterface, _ ->
                    val intent = Intent(this,ThirdActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("No"){ dailogInterface, _ ->
                    Toast.makeText(this,"You clicked on No",Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Help"){ dailogInterface, _ ->
                    Toast.makeText(this,"You clicked on Help",Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}