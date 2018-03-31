package com.liubase.groupmain

/* Created by Jeffrey Liu on 29/03/2018. */
abstract class BaseModule() {
    
    lateinit var ma : MainActivity
    
    abstract fun entryPoint()
}