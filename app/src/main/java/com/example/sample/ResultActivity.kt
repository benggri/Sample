package com.example.sample

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_main)

        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val conTitle: String = intent.getStringExtra("conTitle")
        val contText: String = intent.getStringExtra("contText")

        val conTitleTextView: TextView = findViewById(R.id.conTitle)
        conTitleTextView.setText(conTitle)
        val contTextTextView: TextView = findViewById(R.id.contText)
        contTextTextView.setText(contText)

        notificationManager.cancel(1234)
    }

}