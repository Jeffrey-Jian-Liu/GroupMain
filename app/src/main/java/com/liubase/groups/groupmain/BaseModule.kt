package com.liubase.groups.groupmain

import android.support.v4.app.*

/* Created by Jeffrey Liu on 29/03/2018. */
open class BaseModule {
    open fun entryFragment() : Fragment {
        return Fragment()
    }
    
    open fun entryPoint(){}
}