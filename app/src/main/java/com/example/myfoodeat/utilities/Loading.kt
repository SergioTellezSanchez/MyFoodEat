//package com.example.myfoodeat.ui.loading
//
//import android.R
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.app.AlertDialog
//import androidx.fragment.app.Fragment
//
//
//class LoadingFragment : Fragment() {
//
//    // 2 objects activity and dialog
//    private var activity: Activity? = null
//    private var dialog: AlertDialog? = null
//
//    // constructor of dialog class
//    // with parameter activity
//    fun dialog(myActivity: Activity?) {
//        activity = myActivity
//    }
//
//    @SuppressLint("InflateParams")
//    fun startLoadingdialog() {
//
//        // adding ALERT Dialog builder object and passing activity as parameter
//        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
//
//        // layoutinflater object and use activity to get layout inflater
//        val inflater = requireActivity().layoutInflater
//        builder.setView(inflater.inflate(R.layout.fragment_loading, null))
//        builder.setCancelable(true)
//        dialog = builder.create()
//        dialog.show()
//    }
//
//    // dismiss method
//    fun dismissdialog() {
//        dialog?.dismiss()
//    }
//}