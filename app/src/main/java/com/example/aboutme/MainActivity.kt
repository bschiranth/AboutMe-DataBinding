package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    private val myName: MyName = MyName("Chiranth")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.myName = myName

        //setContentView(R.layout.activity_main)
        dataBinding.doneButton.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {

        dataBinding.apply {
            myName?.nickName = dataBinding.nickNameEdit.text.toString()
            invalidateAll() //need to refresh all binding data
            //nickname_text.text = nickName_edit.text
            view.visibility = View.GONE
            nickName_edit.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
        }

        hideKeyBoard(view)
    }

    private fun hideKeyBoard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0 )
    }
}
