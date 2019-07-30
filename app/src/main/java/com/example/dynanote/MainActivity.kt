package com.example.dynanote

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // mainTextはcontent_main.xml内に指定したtextのid
        mainText.text = getToday()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    // 画面タッチでのイベント
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val cord: TextView = findViewById(R.id.mainText)
        var x: Int
        var y: Int

        when (event.getAction()){
            // タッチ開始
            MotionEvent.ACTION_DOWN -> {
                x = event.getX().toInt()
                y = event.getY().toInt()
                cord.text = "($x, $y) down"
            }

            // タッチ終了
            MotionEvent.ACTION_UP -> {
                x = event.getX().toInt()
                y = event.getY().toInt()
                cord.text = "($x, $y) up"
            }
        }
        return super.onTouchEvent(event)
    }

    // 現在時刻を取得．
    fun getToday(): String {
        val date = Date()
        val format = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
        return format.format(date)
    }
}
