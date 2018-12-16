package me.takehiro.whatsyourname

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //  文字を出す
            textView.text = editText.text.toString() + "さんこんにちは！"

            //  画像を出す
            imageView.setImageResource(R.drawable.joke_icon)
        }
    }
}
