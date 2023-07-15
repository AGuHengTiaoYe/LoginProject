package com.guheng.LoginProject.user

import android.content.Context
import java.lang.ref.WeakReference

class UserManager private constructor(val context:WeakReference<Context>) {
    companion object{
        private var instance:UserManager? = null
        fun sharedInstance(context:Context):UserManager{
            if (instance == null){ synchronized(this){
                if (instance == null) instance = UserManager(WeakReference(context)) } }
            return instance!!
        }
    }
}