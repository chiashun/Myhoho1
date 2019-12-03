package com.example.myhoho

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
     //module-level variable
    private  var like:Int=0
    private var dislike:Int=0
    // Declare an instance of the SharedPref
    private lateinit var sharePreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialize the shared Pref
        sharePreferences=getPreferences(Context.MODE_PRIVATE)

        imageViewLike.setOnClickListener{
            like++
            textViewLike.text=like.toString()
        }
        imageViewDislike.setOnClickListener{
            dislike++
            textViewDislike.text=dislike.toString()
        }

         Log.d("MainActivity","onCreate")
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        //Retrive the Shared Pref
        like=sharePreferences.getInt(getString(R.string.like),0)
        dislike=sharePreferences.getInt(getString(R.string.dislike),0)
        textViewLike.text=like.toString()
        textViewDislike.text=dislike.toString()

        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onPause() {
        Log.d("MainActivity","onPause")
        with(sharePreferences.edit()){
            putInt(getString(R.string.like),like)
            putInt(getString(R.string.dislike),dislike)
            apply()
        }
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
