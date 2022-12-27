package com.example.pracyical_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toggle = findViewById<ToggleButton>(R.id.toggleButton)
        val checkBox = findViewById<RadioGroup>(R.id.hobbiesSelectCheckBox)
        val submitButton = findViewById<Button>(R.id.btnSubmitLast)
        val enterName = findViewById<EditText>(R.id.etName)
        val gender = findViewById<RadioGroup>(R.id.rgGender)
        val textGender = findViewById<TextView>(R.id.txtGender)
        val imgBtn = findViewById<ImageButton>(R.id.imageButton)
        var enteredName = ""

        toggle.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                     checkBox.visibility = View.VISIBLE
                Toast.makeText(applicationContext,"Clicked on yes",Toast.LENGTH_SHORT).show()
            }
            else{
                checkBox.visibility = View.GONE
                Toast.makeText(this,"Clicked no ",Toast.LENGTH_SHORT).show()
            }
        }
        imgBtn.setOnClickListener {
            val rdbtn = gender.checkedRadioButtonId
            when (rdbtn) {
                R.id.rBtnMale -> textGender.text = "You Selected Male Gender"
                R.id.rBtnFemale -> textGender.text = " You Selected Female Gender"
            }
        }

        //Submit Button
        submitButton.setOnClickListener {
            enteredName = enterName.text.toString()

            if(enteredName == ""){
                Toast.makeText(this,"Please Enter your Name ",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent (this,SecondActivity::class.java)
                val bundle = Bundle()
                bundle.putString("Name",enterName.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)

            }
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.testing_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenu -> Toast.makeText(this,"you clicked on info ",Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }
}