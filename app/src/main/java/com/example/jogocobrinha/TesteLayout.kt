package com.example.jogocobrinha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class TesteLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste_layout)


        var layout = LinearLayout(this)
        with (layout){
            setPadding(10, 10, 10, 10)
            setOrientation(LinearLayout.VERTICAL)
            setLayoutParams(LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT))
        }
       for (i in 1..100){
           var text = TextView(this)
           with(text){
               setText("Nome:")
               setLayoutParams(LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                   LinearLayout.LayoutParams.WRAP_CONTENT));
           }
           layout.addView(text)
       }

        setContentView(layout)
    }

}
