package com.android.photoverification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.android.photoverification.VerificationActivity

class PhotoVerification(private val activity: AppCompatActivity) {

    interface CompleteListener {
        fun onComplete(paths: ArrayList<String>)
    }

    private var mainLayoutSet = false
    private var mainLayout: Int = -1
    private var verificationLayouts: ArrayList<Int> = arrayListOf()

    companion object {
        var completeListener: CompleteListener? = null
    }

    fun setMainLayout(id: Int): PhotoVerification {
        if (mainLayoutSet) throw (Exception("You can just add a main layout!"))
        else {
            mainLayout = id
            mainLayoutSet = true
        }
        return this
    }

    fun setVerificationLayout(id: Int): PhotoVerification {
        verificationLayouts.add(id)
        return this
    }

    fun addCompleteListener(cListener: CompleteListener): PhotoVerification {
        completeListener = cListener
        return this
    }

    fun start() {
        if (verificationLayouts.isEmpty()) throw (Exception("You must add at least one verification layout!"))
        if (mainLayout == -1) throw (Exception("You must add main layout!"))

        VerificationActivity.mainLayout = mainLayout
        VerificationActivity.verificationLayouts = verificationLayouts
        activity.startActivity(Intent(activity, VerificationActivity::class.java))
    }

}