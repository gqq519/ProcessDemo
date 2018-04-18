package com.gqq.processopendemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import butterknife.ButterKnife
import butterknife.OnClick
import com.gqq.processopendemo.model.User
import com.gqq.processopendemo.openprocess.SecondActivity
import com.gqq.processopendemo.openprocess.UserManager
import java.io.*

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

    @OnClick(R.id.btn_serializable)
    fun serialUser() {


        Thread(Runnable {
            kotlin.run {
                val USER_CACHE = applicationContext.filesDir.path
                var user = User(1, "gqq", false)
                var dir = File(USER_CACHE + "/gqq")
                if (!dir.exists()) run {
                    dir.mkdirs()
                }
                var file = File(USER_CACHE + "cache.txt")
                var out = ObjectOutputStream(FileOutputStream(file))
                out.writeObject(user)
                Log.i("TAG", "User-ser:" + user.toString() + "," + user.hashCode())
                out.close()
            }
        }).start()
    }

    @OnClick(R.id.btn_reverse_serializable)
    fun reverseUser() {

        Thread(Runnable {
            kotlin.run {
                val USER_CACHE = applicationContext.filesDir.path
                var file = File(USER_CACHE + "cache.txt")
                var out = ObjectInputStream(FileInputStream(file))
                var user = out.readObject()
                Log.i("TAG", "User-reverse:" + user.toString() + "," + user.hashCode())
                out.close()
            }
        }).start()
    }
}
