package com.melabsinthiatum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*


class MainActivity: AppCompatActivity() {

    private lateinit var api: APIController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        api = APIController()
        api.sampleGet {
            GlobalScope.apply {
                launch(Dispatchers.Main) {
                    findViewById<TextView>(R.id.main_text).text = "berry" + it
                }
            }
        }
    }

    private fun handleError(ex: Throwable?) {
        // TODO: use func require() {}
        println("look at it")
        ex?.printStackTrace()
    }
}