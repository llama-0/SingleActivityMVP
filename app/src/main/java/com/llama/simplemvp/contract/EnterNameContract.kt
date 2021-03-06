package com.llama.simplemvp.contract

import androidx.annotation.ColorRes
import com.llama.simplemvp.view.model.RadioButtonColorPerId

interface EnterNameContract {

    interface View {
        fun showMessage(message: String)
        fun showName(name: String)
        fun hideKeyboard()
        fun showResponseFragmentWithTextViewBackgroundColor(color: Int)
        fun showCheckedRadioButton(color: Int)
    }

    interface Presenter {
        fun init()
        fun onShowResponseButtonClicked()
        fun onNameChanged(name: String)
        fun onRadioButtonChecked(rbColorPerId: RadioButtonColorPerId)
    }

}