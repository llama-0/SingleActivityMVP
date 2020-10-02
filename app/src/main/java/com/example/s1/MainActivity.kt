package com.example.s1

import MainPresenter
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractMain.View {

    private var sharedPreferences: SharedPreferences? = null

    companion object {
        private const val PREFERENCES_TAG = "PREFERENCES_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity","onCreate called")

        sharedPreferences = getSharedPreferences(PREFERENCES_TAG, 0)
        presenter.start()

        button.setOnClickListener {
            showMessage()
        }
    }

    override fun showMessage() {
        Snackbar.make(
            currentFocus?.rootView!!,
            if (editText.text.isNotEmpty()) editText.text else "Please enter your name",
            Snackbar.LENGTH_LONG).show()
    }

    override fun setText(text: String) {
        editText.setText(text)
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause called")
        presenter.saveText(sharedPreferences!!, editText.text.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume called")
        presenter.retrieveText(sharedPreferences!!)?.let { setText(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy called")
    }

    override var presenter: ContractMain.Presenter = MainPresenter()
}