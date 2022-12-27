package com.example.pracyical_3.Util

import androidx.appcompat.app.AlertDialog
import com.example.pracyical_3.R
import com.example.pracyical_3.ThirdActivity

class LoadingDail(val mActivity: ThirdActivity) {
    private lateinit var isdialog : AlertDialog
    fun startLoading (){
        val inflater = mActivity.layoutInflater
        val dailogView = inflater.inflate(R.layout.loading_item,null)
        val builder = AlertDialog.Builder(mActivity)
        builder.setView(dailogView)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog.show()
    }
    fun isDismiss(){
        isdialog.dismiss()
    }
}