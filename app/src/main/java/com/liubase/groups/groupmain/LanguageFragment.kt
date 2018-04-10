package com.liubase.groups.groupmain

import android.content.*
import android.os.*
import android.preference.*
import android.support.v4.app.*
import android.view.*
import android.widget.*

/* Created by Jeffrey Liu on 9/04/2018. */
class LanguageFragment : Fragment(), RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    
    private lateinit var lView : LinearLayout
    private lateinit var rg : RadioGroup
    private lateinit var save : Button
    
    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?,
            savedInstanceState : Bundle?) : View? {
        lView = inflater.inflate(R.layout.main_language, container, false) as LinearLayout
        
        rg = lView.findViewById(R.id.group) as RadioGroup
        rg.setOnCheckedChangeListener(this)
        val en : RadioButton = lView.findViewById(R.id.english) as RadioButton
        val cn : RadioButton = lView.findViewById(R.id.chinese) as RadioButton
        save = lView.findViewById(R.id.save) as Button
        save.setOnClickListener(this)
        
        return lView
    }
    
    override fun onCheckedChanged(group : RadioGroup?, checkedId : Int) {
        when (checkedId) {
            R.id.english -> save.text = getString(R.string.main_save_en)
            R.id.chinese -> save.text = getString(R.string.main_save_cn)
        }
    }
    
    override fun onClick(v : View?) {
        val sp : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        var lg = "US"
        when (rg.checkedRadioButtonId) {
            R.id.chinese -> lg = "CN"
        }
        sp.edit().putString("Locale", lg).apply()
        sp.edit().putBoolean("ShowLanguage", false).apply()
        activity?.recreate()
    }
}