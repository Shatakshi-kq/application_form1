package com.example.myapplication3

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.databinding.ActivityMainBinding
import com.example.myapplication3.util.Keys


class MainActivity : AppCompatActivity(), OnClickListener,
RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var fname:String
    private lateinit var lname:String
    private lateinit var mobileno:String
    private lateinit var altmobileno:String
    private lateinit var email:String
    private lateinit var txtGender:String
    private var list=ArrayList<String>()




    /*
    val list: ArrayList<String> = ArrayList()
    private val ischecked:Boolean = false
    private var txtGender: String? = null
    private var coding :String? = null
    private var readingbooks :String? =null
    private var movies :String?=null
    private var playing :String?=null
    private  var traveling  :String?=null

    private lateinit var context: Context
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")




/*
        var first_name: EditText = findViewById(R.id.f_name)
        var last_name: EditText = findViewById(R.id.l_name)
        var mobile_no: EditText = findViewById(R.id.mobile_n)
        var alternate_no: EditText = findViewById(R.id.al_mobile)
        val email: EditText = findViewById(R.id.email_n)
        val btn: Button = findViewById(R.id.btn_s)
*/
        binding.btnS.setOnClickListener(this)
        binding.txtgender.setOnCheckedChangeListener(this)
        binding.check1.setOnCheckedChangeListener(this)
        binding.check2.setOnCheckedChangeListener(this)
        binding.check3.setOnCheckedChangeListener(this)
        binding.check4.setOnCheckedChangeListener(this)
        binding.check5.setOnCheckedChangeListener(this)

    }

    override fun onClick(v: View?) {
        fname=binding.fnameContainer.editText?.text.toString()
        lname=binding.lnamecontainer.editText?.text.toString()
        mobileno=binding.phonecontainer.editText?.text.toString()
        altmobileno=binding.alcontainer.editText?.text.toString()
        if(checkMobileNumber(mobileno,altmobileno)) {
            email = binding.emailcontainer.editText?.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            val bundle = Bundle()
            bundle.putString(Keys.FIRSTNAME, fname)
            bundle.putString(Keys.LASTNAME, lname)
            bundle.putString(Keys.MOBILENUMBER, mobileno)
            bundle.putString(Keys.ALTMOBILENUMBER, altmobileno)
            bundle.putString(Keys.Email, email)
            bundle.putString(Keys.GENDER, txtGender)
            bundle.putStringArrayList(Keys.ARRAYLISTOBJECT, this.list.toString())
            intent.putExtra(Keys.BUNDLEKEY, bundle)
            startActivity(intent)
        }else{
            Toast.makeText(this," Please Enter Alternative Mobile Number Different ",Toast.LENGTH_LONG).show()
            return
        }


    }

    private fun checkMobileNumber(mobileno: String, altmobileno: String):Boolean {
        return mobileno!=altmobileno

    }

    /*
    override fun onClick(view: View?) {
        when(view?.id){

            R.id.btn_s ->{

                if(binding.fName.text!!.isEmpty() && binding.lName.text!!.isEmpty() && binding.mobileN.text!!.isEmpty() && binding.alMobile.text!!.isEmpty() && binding.emailN.text!!.isEmpty()) {
                    binding.fName.requestFocus()
                    Toast.makeText(this,"fill required information ",Toast.LENGTH_SHORT).show()
                }else if(binding.fName.text!!.isEmpty()){
                    binding.fName.requestFocus()
                    Toast.makeText(this,"Please fill your First name",Toast.LENGTH_SHORT).show()

                }
                else if(binding.lName.text!!.isEmpty()){
                    binding.lName.requestFocus()
                    Toast.makeText(this,"Please fill your Last name",Toast.LENGTH_SHORT).show()

                }
                else if(binding.mobileN.text!!.isEmpty()){
                    binding.mobileN.requestFocus()
                    Toast.makeText(this,"Please fill your Phone Number name",Toast.LENGTH_SHORT).show()
                }
                else if(binding.alMobile.text!!.isEmpty()){
                    binding.alMobile.requestFocus()
                    Toast.makeText(this,"Please fill your Alternate Number name",Toast.LENGTH_SHORT).show()
                }else if(binding.emailN.text!!.isEmpty()){
                    binding.emailN.requestFocus()
                    Toast.makeText(this,"Please fill your Email name",Toast.LENGTH_SHORT).show()

                }
                else if(txtGender==null){
                    binding.listN.requestFocus()
                    Toast.makeText(this,"Please Select Your Gender",Toast.LENGTH_SHORT).show()

                }

                else{
                    val firName = binding.fName.text.toString()
                    val lasName = binding.lName.text.toString()
                    val Mobile = binding.mobileN.text.toString()
                    val almobile = binding.alMobile.text.toString()
                    val mailad = binding.emailN.text.toString()
                    val lst=list.toString().replace("["," ").replace("]"," ")

                    binding.result.text =
                        " Name :- $firName  $lasName \n Phone NO :- $Mobile \n Alternate Phone No :- $almobile \n Email :- $mailad \n Gender - $txtGender \n Hobbies \n ${lst}"


                }

            }
        }
    }
*/
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        when(group?.checkedRadioButtonId){
            R.id.male_b ->{
                txtGender = binding.maleB.text.toString()
//
            }
            R.id.female_b ->{
                txtGender = binding.femaleB.text.toString()

            }
            R.id.tr_b ->{
               txtGender = binding.trB.text.toString()
            }

        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.check1 ->{
                if(binding.check1.isChecked){
                    list.add(binding.check1.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                }
                else{
                    list.remove(binding.check1.text.toString())
                }

            }
            R.id.check2 ->{
                if(binding.check2.isChecked){
                    list.add(binding.check2.text.toString())

                }
                else{
                    list.remove(binding.check2.text.toString())
                }

            }
            R.id.check3 ->{
                if(binding.check3.isChecked){
                    list.add(binding.check3.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                }
                else{
                    list.remove(binding.check3.text.toString())
                }

            }
            R.id.check4 ->{
                if(binding.check4.isChecked){
                    list.add(binding.check4.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                }
                else{
                    list.remove(binding.check4.text.toString())
                }

            }
            R.id.check5 ->{
                if(binding.check5.isChecked){
                    list.add(binding.check5.text.toString())
                    // list.toString().replace("[", "").replace("]", "");
                }
                else{
                    list.remove(binding.check5.text.toString())
                }

            }
        }
    }


}

private fun Bundle.putStringArrayList(arraylistobject: String, toString: String){

}

/*
        btn.setOnClickListener {

            var first_name = first_name.text.toString()
            var last_name = last_name.text.toString()
            var m_no = mobile_no.text.toString()
            var al_no = alternate_no.text.toString()
            var e_name = email.text.toString()

            full_n.setText("Your Name is : $first_name $last_name")
            phone_n.setText("Your Mobile Number is : +91 $m_no")
            alter_n.setText("Your alternate number is: $al_no")
            emailad.setText("Your Email Address is: $e_name")


            if(m_no.isNotEmpty() && al_no.isNotEmpty() && m_no == al_no){
                Toast.makeText(this, "mobile no. and alternater no. should not be same.Please! enter different number", Toast.LENGTH_SHORT).show()


            }

        }


    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(group?.checkedRadioButtonId){
            R.id.male_b ->{
                val rbMale = findViewById<RadioButton>(checkedId)
                Toast.makeText(context, rbMale.text.toString(), Toast.LENGTH_SHORT).show()
            }

            R.id.female_b ->{
                val rbFeMale = findViewById<RadioButton>(checkedId)
                Toast.makeText(context, rbFeMale.text.toString(), Toast.LENGTH_SHORT).show()
            }

            R.id.tr_b ->{
                val rbTransGender = findViewById<RadioButton>(checkedId)
                Toast.makeText(context, rbTransGender.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.male_b ->{
                Toast.makeText(context, binding.maleB.text.toString(), Toast.LENGTH_SHORT).show()
            }

            R.id.female_b ->{
                Toast.makeText(context, binding.femaleB.text.toString(), Toast.LENGTH_SHORT).show()
            }

            R.id.tr_b ->{
                Toast.makeText(context, binding.trB.text.toString(), Toast.LENGTH_SHORT).show()
            }


        }
    }



*/