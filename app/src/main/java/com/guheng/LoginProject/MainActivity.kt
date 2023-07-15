package com.guheng.LoginProject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.guheng.LoginProject.file.FileManager
import com.guheng.LoginProject.user.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = arrayListOf(
            User("GuHeng","12333","4568",false),
            User("ZhangSan","125453","8547",false),
            User("LuoXiang","125453","7412",false)
        )
        FileManager.sharedInstance().writeData(this,users)
        FileManager.sharedInstance().readData(this).onEach { user ->
            Log.v("text","$user")
        }
    }
}