package com.example.myapplication3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.myapplication3.databinding.ActivityMain2Binding
import com.example.myapplication3.util.Keys

class MainActivity2 : AppCompatActivity() {

    lateinit var fname:String
    lateinit var lname:String
    lateinit var mobileno:String
    lateinit var altmobile:String
    lateinit var email:String
    lateinit var gender:String
    lateinit var hobby1:String
    lateinit var hobby2:String
    lateinit var hobby3:String
    lateinit var hobby4:String
    lateinit var hobby5:String
    lateinit var binding:ViewBinding
    var arrayList=ArrayList<String>()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
            setContentView(binding.root)
        val intent = intent
        val bundle = intent.getBundleExtra(Keys.BUNDLEKEY)
        fname = bundle!!.getString(Keys.FIRSTNAME).toString()
        lname = bundle.getString(Keys.LASTNAME).toString()
        mobileno = bundle.getString(Keys.MOBILENUMBER).toString()
        altmobile = bundle.getString(Keys.ALTMOBILENUMBER).toString()
        email = bundle.getString(Keys.Email).toString()
        gender = bundle.getString(Keys.GENDER).toString()
        arrayList = bundle.getStringArrayList(Keys.ARRAYLISTOBJECT) as ArrayList<String>
    }
}