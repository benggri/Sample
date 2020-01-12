package com.example.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val notificationHandler: NotificationHandler by lazy {
        NotificationHandler(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button:Button = findViewById( R.id.button )
        var conTitle:EditText = findViewById( R.id.conTitle )
        var conText:EditText  = findViewById( R.id.conText )

        button.setOnClickListener( View.OnClickListener {
                v -> notificationHandler.addNotification( conTitle.text.toString(), conText.text.toString() )
        } )
    }

}
