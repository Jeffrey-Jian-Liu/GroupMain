package com.liubase.groupmain

import android.util.*

/* Created by Jeffrey Liu on 30/03/2018. */
object ModuleControl {
    
    private val moduleMap = mapOf("com.liubase.groups" to "com.liubase.groups",
            "com.liubase.groupmain" to "com.liubase.groupmain",
            "com.liubase.grouplogin" to "com.liubase.grouplogin.LoginModule",
            "com.liubase.groupuser" to "com.liubase.groupuser.UserModule")
    
    fun controlFlow(id : String, ma : MainActivity) {
        when (id) {
            "com.liubase.groups"    -> appFlow()
            "com.liubase.groupmain" -> mainFlow()
            else                    -> moduleFlow(id, ma)
        }
    }
    
    private fun appFlow() {
    
    }
    
    private fun mainFlow() {
        Log.d("test", "Main")
    }
    
    private fun moduleFlow(id : String, ma : MainActivity) {
        val name = moduleMap[id]
        var module : BaseModule
        try {
            val moduleClass = Class.forName(name)
            module = moduleClass.newInstance() as BaseModule
            module.ma = ma
            module.entryPoint()
        } catch (e : Exception) {
            throw RuntimeException(e)
        }
    }
}