package com.vanshika.fragmentactivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vanshika.fragmentactivity2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding ?= null
    var activityInterface : ActivityInterface ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnChangeFragmentText?.setOnClickListener {
            if(binding?.etEnterForFragment?.text?.toString()?.isNullOrEmpty() == true){
                binding?.etEnterForFragment?.error = resources.getString(R.string.enter_something)
            }
            else{
                activityInterface?.changeFragmentText("${binding?.etEnterForFragment?.text?.toString()}")
            }
        }
    }
    fun changeActivityText(string : String){
        binding?.btnChangeFragmentText?.setText(string.toString())
    }
}