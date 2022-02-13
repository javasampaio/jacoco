/*
* Copyright 2018 Rede S.A.
*************************************************************
*Descriçao : Custom Runner para executar o espresso
*Autor : José Pedretti Neto
*Data : 13/06/2018
*Empresa : CI&T
*************************************************************
*/

package br.com.sampaio.jacocoexample.testing

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.github.tmurakami.dexopener.DexOpener

class CustomRunner : AndroidJUnitRunner(){
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        DexOpener.install(this)
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}