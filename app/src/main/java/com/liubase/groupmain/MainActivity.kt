package com.liubase.groupmain

import android.os.*
import android.support.v7.app.*
import android.widget.*

class MainActivity : AppCompatActivity() {
    
    private val myTag = "Main Activity"
    
    private val pAL : ArrayList<FrameLayout> = ArrayList()
    private var pIndex : Int = 2
    private val fm = fragmentManager
    
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val id = BuildConfig.APPLICATION_ID
        ModuleControl.controlFlow(id, this)
    }
}
