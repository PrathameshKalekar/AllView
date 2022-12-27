package com.example.pracyical_3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.DatePicker
import android.widget.RatingBar
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import com.example.pracyical_3.Util.LoadingDail
import kotlinx.coroutines.Runnable
import java.util.Calendar

class ThirdActivity : AppCompatActivity() ,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    private  var day=0
    private  var month = 0
    private  var year =0
    private  var minute =0
    private  var second = 0

    private  var savedday=0
    private  var savedmonth = 0
    private  var savedyear =0
    private  var savedminute =0
    private  var savedsecond = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val loading = LoadingDail(this)
        val rating = findViewById<RatingBar>(R.id.rtBarView)

        loading.startLoading()
        val handler = Handler()
        handler.postDelayed(object :Runnable{
            override fun run() {
                loading.isDismiss()
            } },5000)

        rating.rating = 2.5f
        rating.stepSize=.5f

        rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this,"You selected $rating",Toast.LENGTH_SHORT).show()
        }
        pickDate()
    }
    private fun getTimeCalender(){
        val cal : Calendar = Calendar.getInstance()
         day=cal.get(Calendar.DAY_OF_MONTH)
         month = cal.get(Calendar.MONTH)
         year =cal.get(Calendar.YEAR)
         minute =cal.get(Calendar.HOUR)
         second = cal.get(Calendar.MINUTE)
    }

    private fun pickDate(){
        val datePicker = findViewById<TextView>(R.id.datePicker)
        datePicker.setOnClickListener {
            getTimeCalender()
            DatePickerDialog(this,this,year, month, day).show()
        }
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, datOfMonth: Int) {
        savedday=datOfMonth
        savedmonth=month
        savedyear=year

        getTimeCalender()

        TimePickerDialog(this,this,minute,second,true).show()
    }

    override fun onTimeSet(timePicker: TimePicker?, hour: Int, minute: Int) {
        val text = findViewById<TextView>(R.id.timeDisplayTxt)
        savedminute=hour
        savedsecond=minute

        text.text ="$savedday-$savedmonth-$savedyear \n Hour : $savedminute Minute : $savedsecond"
    }
}