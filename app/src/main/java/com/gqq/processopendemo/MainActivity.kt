package com.gqq.processopendemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import butterknife.ButterKnife
import butterknife.OnClick
import com.gqq.processopendemo.model.User
import com.gqq.processopendemo.model.UserModelParcel
import com.gqq.processopendemo.model.UserParcel
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

    @OnClick(R.id.btn_Parcelable)
    fun parcelUser() {
        var user = UserModelParcel(12, "hhh", false, UserParcel(1234, "内部", true))
        var intent = Intent()
        intent.setClass(this, SecondActivity::class.java)
        var bundle = Bundle()
        bundle.putParcelable("user", user)
        intent.putExtras(bundle)
        startActivity(intent)
    }


//    // 序列化过程
//    User user = new User(1, "gqq", false);
//    ObjectOutputStream out = ObjectOutputStream(new FileOutputStream(file));
//    out.writeObject();
//    out.close();
//    // 反序列化过程
//    ObjectInputStream in = ObjectInputStream(new FileInputStream(file));
//    User user = in.readObject();
//    in.close();

}
