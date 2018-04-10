package com.liubase.groups.groupmain

import android.app.*
import android.content.*
import android.content.res.*
import android.support.v4.app.Fragment
import android.view.*

/* Created by Jeffrey Liu on 29/03/2018. */
open class BaseModule {
    
    lateinit var ma : MainActivity
    open var index : Int = 2
    
    fun addFragment(i : Int) {
       addFragment(i,entryFragment())
    }
    
    fun addFragment(i : Int, f : Fragment) {
        val ft = ma.fm.beginTransaction()
        when (i) {
            0 -> ft.add(R.id.frame0, f)
            1 -> ft.add(R.id.frame1, f)
            2 -> ft.add(R.id.frame2, f)
            3 -> ft.add(R.id.frame3, f)
            4 -> ft.add(R.id.frame4, f)
        }
        ft.commit()
        showPanel()
    }
    
    fun swapFragment(i : Int, f : Fragment) {
        val ft = ma.fm.beginTransaction()
        when (i) {
            0 -> ft.replace(R.id.frame0, f)
            1 -> ft.replace(R.id.frame1, f)
            2 -> ft.replace(R.id.frame2, f)
            3 -> ft.replace(R.id.frame3, f)
            4 -> ft.replace(R.id.frame4, f)
        }
        ft.commit()
    }
    
    private fun showPanel() {
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
    
    open fun entryFragment() : Fragment {
        return Fragment()
    }
    
    open fun entryPoint() {}
}