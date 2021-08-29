package com.android.photoverification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VerificationActivity : AppCompatActivity() {

    companion object {
        var mainLayout: Int = -1
        var verificationLayouts: ArrayList<Int> = arrayListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
    }
}