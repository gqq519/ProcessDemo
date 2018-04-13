package com.gqq.processopendemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_main)
    fun onviewClicked() {
        val intent = Intent()
        intent.setClass(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
