package com.example.delays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            count++
            tv.text = count.toString()
        }

        btnWait.setOnClickListener {
            val start = System.currentTimeMillis()

//            toast("DELAY started")
//            Not working but why ?

            while ( System.currentTimeMillis() < start + 5000) {}

            toast("DELAY ended")

        }

    }
}
