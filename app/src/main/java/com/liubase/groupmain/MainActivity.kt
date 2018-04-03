package com.liubase.groupmain

import android.os.*
import android.support.v4.app.*
import android.support.v7.app.*
import android.widget.*

class MainActivity : AppCompatActivity() {
    
    private val myTag = "Main Activity"
    
    val pAL : ArrayList<FrameLayout> = ArrayList()
    val fm : FragmentManager = this.supportFragmentManager
    
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        
        val frame0 : FrameLayout = findViewById(R.id.frame0)
        
        val frame1 : FrameLayout = findViewById(R.id.frame1)
        
        val frame2 : FrameLayout = findViewById(R.id.frame2)
        
        val frame3 : FrameLayout = findViewById(R.id.frame3)
        
        val frame4 : FrameLayout = findViewById(R.id.frame4)
        
        pAL.add(frame0)
        pAL.add(frame1)
        pAL.add(frame2)
        pAL.add(frame3)
        pAL.add(frame4)
        
        val id = BuildConfig.APPLICATION_ID
        ModuleControl.controlFlow(id, this)
    }
}
