package com.andy.cicdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testSonarBug1()
    }

    /**
     * "=+" should not be used instead of "+="
     */
    fun testSonarBug1(){
        var target = -5
        val num = 3
        target =- num // Noncompliant; target = -3. Is that really what's meant?
        target =+ num // Noncompliant; target = 3
    }

    /**
     * fix solution
     * "=+" should not be used instead of "+="
     */
    fun testSonarBug1Fix(){
        var target = -5
        val num = 3

        target = -num // Compliant; intent to assign inverse value of num is clear
        target += num
    }
}