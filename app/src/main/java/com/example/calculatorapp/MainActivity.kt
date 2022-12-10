package com.example.calculatorappa2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowId
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash_screen.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    val genre = arrayOf("jaz (default)", "pop", "classic", "rock", "metal", "young adult" )
    val lang = arrayOf("English (default)", "Spanish", "Arabic", "hindi", "French" )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,genre)
        val arrayAdapter2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,lang)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Currently selected genre is: "+genre[position], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinner2.adapter = arrayAdapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Currently selected language is: "+lang[position], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        button.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setIcon(R.mipmap.ic_launcher_round) //set alertdialog icon
            mAlertDialog.setTitle("we Suggest You: ") //set alertdialog title
            if ((spinner.selectedItemPosition==0) and (spinner2.selectedItemPosition==0)){
                mAlertDialog.setMessage("Happy by talor swift\nlove story by talor swift") //set alertdialog message
            }

            mAlertDialog.setPositiveButton("Yes") { dialog, id ->
                //perform some tasks here
                Toast.makeText(this@MainActivity, "Yes", Toast.LENGTH_SHORT).show()
            }
            mAlertDialog.setNegativeButton("No") { dialog, id ->
                //perform som tasks here
                Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
            }
            mAlertDialog.show()
        }


    }




}