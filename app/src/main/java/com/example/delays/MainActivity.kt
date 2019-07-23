package com.example.delays

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
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
            WaitTask(this).execute()
        }
    }

    class WaitTask (val mcontext: Context) : AsyncTask<Void, Void, Context>() {
        override fun doInBackground(vararg p0: Void?): Context? {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() < start + 5000) {}
            return mcontext
        }

        override fun onPostExecute(result: Context) {
            super.onPostExecute(result)
            Toast.makeText(mcontext,"DELAY ended",Toast.LENGTH_SHORT).show()
        }

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(mcontext,"DELAY started",Toast.LENGTH_SHORT).show()
        }

    }

}
