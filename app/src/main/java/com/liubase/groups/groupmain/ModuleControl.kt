package com.liubase.groups.groupmain

import android.app.*
import android.content.*
import android.content.res.*
import android.util.*
import android.view.*

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
            "GroupNetwork" -> libFlow(id)
            else                       -> fragmentFlow(id, ma)
        }
    }
    
    private fun appFlow() {
        Log.d("test", "Groups")
    }
    
    private fun mainFlow() {
        Log.d("test", "GroupMain")
    }
    
    private fun libFlow(id : String) {
        val name = moduleMap[id]
        try {
            val moduleClass = Class.forName(name)
            val module = moduleClass.newInstance() as BaseModule
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
            val ft = ma.fm.beginTransaction()
            ft.add(R.id.main_frame2, module.entryFragment())
            ft.commit()
            showPanel(2, ma)
        } catch (e : Exception) {
            throw RuntimeException(e)
        }
    }
    
    private fun showPanel(index : Int, ma : MainActivity) {
        val mode : UiModeManager = ma.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        val density = ma.resources.displayMetrics.densityDpi
        val b : Boolean = (mode.currentModeType == Configuration.UI_MODE_TYPE_DESK) && density == 160
        
        for (i in ma.pAL.indices) {
            if (b || i == index) {
                ma.pAL[i].visibility = View.VISIBLE
            } else {
                ma.pAL[i].visibility = View.GONE
            }
        }
    }
}