package com.liubase.groups.groupmain

import android.util.*

/* Created by Jeffrey Liu on 30/03/2018. */
object ModuleControl {
    
    private val moduleMap = mapOf("Groups" to "com.liubase.groups",
            "GroupMain" to "com.liubase.groups.groupmain",
            "GroupLogin" to "com.liubase.groups.grouplogin.LoginModule",
            "GroupNetwork" to "com.liubase.groups.groupnetwork.NetworkModule",
            "GroupUser" to "com.liubase.groups.groupuser.UserModule")
    
    fun controlFlow(id : String, ma : MainActivity) {
        when (id) {
            "Groups"       -> appFlow()
            "GroupMain"    -> mainFlow()
            "GroupNetwork" -> libFlow(id, ma)
            else           -> fragmentFlow(id, ma)
        }
    }
    
    private fun appFlow() {
        Log.d("test", "Groups")
    }
    
    private fun mainFlow() {
        Log.d("test", "GroupMain")
    }
    
    private fun libFlow(id : String, ma : MainActivity) {
        val name = moduleMap[id]
        try {
            val moduleClass = Class.forName(name)
            val module = moduleClass.newInstance() as BaseModule
            module.ma = ma
            module.entryPoint()
        } catch (e : Exception) {
            throw RuntimeException(e)
        }
    }
    
    private fun fragmentFlow(id : String, ma : MainActivity) {
        val name = moduleMap[id]
        var module : BaseModule
        try {
            val moduleClass = Class.forName(name)
            module = moduleClass.newInstance() as BaseModule
            module.ma = ma
            module.addFragment(module.index)
        } catch (e : Exception) {
            throw RuntimeException(e)
        }
    }
}