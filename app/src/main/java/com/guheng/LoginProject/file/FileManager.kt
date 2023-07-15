package com.guheng.LoginProject.file

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guheng.LoginProject.user.User
import java.io.FileReader
import java.io.FileWriter

class FileManager private constructor(){
    companion object{
        private var instance:FileManager? = null    //保存唯一的对象
        fun sharedInstance():FileManager{
            if(instance == null) {
                synchronized(this){
                    if (instance == null) instance = FileManager()
                }
            }
            return instance!!
        }
    }

    //获取文件路径
    private fun filePath(context:Context):String{
        return "${context.filesDir}/userInfo"
    }

    fun readData(context: Context):List<User>{
        FileReader(filePath(context)).use {
            val jsonString = it.readText()
            val token = object : TypeToken<List<User>>() {}
            return Gson().fromJson(jsonString,token)
        }
    }

    fun writeData(context: Context,users:List<User>){
        FileWriter(filePath(context)).use {
            val jsonString = Gson().toJson(users)
            it.write(jsonString)
        }
    }
}