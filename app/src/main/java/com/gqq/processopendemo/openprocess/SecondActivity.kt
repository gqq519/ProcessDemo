package com.gqq.processopendemo.openprocess

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gqq.processopendemo.R
import com.gqq.processopendemo.UserManager

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            val intent = Intent()
            intent.setClass(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        Log.i("TAG", "SecondActivity:"+UserManager.userId)

    }

}
