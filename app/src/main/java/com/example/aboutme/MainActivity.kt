package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        done_button.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        nickname_text.text = nickName_edit.text

        view.visibility = View.GONE
        nickName_edit.visibility = View.GONE

        nickname_text.visibility = View.VISIBLE

        hideKeyBoard(view)
    }

    private fun hideKeyBoard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0 )
    }
}
