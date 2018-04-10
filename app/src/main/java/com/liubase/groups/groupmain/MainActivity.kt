package com.liubase.groups.groupmain

import android.content.*
import android.content.res.*
import android.os.*
import android.preference.*
import android.support.v4.app.*
import android.support.v7.app.*
import android.util.*
import android.widget.*
import java.util.*

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
        
        if (!initLanguage()) {
            val id = applicationInfo.loadLabel(packageManager).toString()
            Log.d(myTag, id)
            ModuleControl.controlFlow(id, this)
        }
    }
    
    override fun attachBaseContext(newBase : Context?) {
        val sp : SharedPreferences =PreferenceManager.getDefaultSharedPreferences(newBase!!)
        val locale = sp.getString("Locale", "US")
        val config : Configuration = newBase!!.resources.configuration
        when (locale) {
            "CN" -> config.setLocale(Locale.SIMPLIFIED_CHINESE)
            else -> config.setLocale(Locale.US)
        }
        val newContext = newBase.createConfigurationContext(config)
        
        super.attachBaseContext(newContext)
    }
    
    private fun initLanguage() : Boolean {
        val sp : SharedPreferences =PreferenceManager.getDefaultSharedPreferences(this)
        val b = sp.getBoolean("ShowLanguage", true)
        if (b) {
            val lf = LanguageFragment()
            val bm = BaseModule()
            bm.ma = this
            bm.addFragment(2,lf)
        }
        
        return b
    }
}
