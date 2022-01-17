package com.example.myfoodeat.data

import android.content.res.Resources
import android.util.Log
import com.example.myfoodeat.R
import java.io.InputStream

fun loadJson(resources: Resources): String {
    var input: InputStream? = null
    val jsonString: String

    try {
        input = resources.openRawResource(R.raw.menu)
        val size = input.available()
        val buffer = ByteArray(size)
        input.read(buffer)
        jsonString = String(buffer)
        return jsonString
    } catch (ex: Exception) {
        Log.e("Error", "$ex")
    } finally {
        input?.close()
    }
    return ""
}