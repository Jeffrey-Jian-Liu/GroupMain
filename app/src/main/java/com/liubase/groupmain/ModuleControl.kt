package com.liubase.groupmain

import android.app.*
import android.content.*
import android.content.res.*
import android.util.*
import android.view.*

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
            val ft = ma.fm.beginTransaction()
            ft.add(R.id.frame2, module.entryPoint())
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