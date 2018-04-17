package com.gqq.processopendemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import butterknife.ButterKnife
import butterknife.OnClick
import com.gqq.processopendemo.openprocess.SecondActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        UserManager.userId = 2
        Log.i("TAG", "MainActivity:" + UserManager.userId)

    }

    @OnClick(R.id.btn_main)
    fun onviewClicked() {
        val intent = Intent()
        intent.setClass(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
