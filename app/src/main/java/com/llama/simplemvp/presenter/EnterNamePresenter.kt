package com.llama.simplemvp.presenter

import android.content.res.Resources
import com.llama.simplemvp.R
import com.llama.simplemvp.contract.EnterNameContract
import com.llama.simplemvp.model.Model
import com.llama.simplemvp.view.getColorCompat
import com.llama.simplemvp.view.RadioButtonColorPerId
import com.llama.simplemvp.view.RadioButtonColorPerId.*


class EnterNamePresenter(
    private val view: EnterNameContract.View,
    private val model: Model,
    private val resources: Resources
) : EnterNameContract.Presenter {

    private fun saveName(name: String) =
        model.setName(name)

    override fun init() {
        view.showName(model.getName())
        view.showCheckedRadioButton(model.getColor())
    }

    override fun onShowResponseButtonClicked() {
        if (model.getName().isEmpty()) {
            view.hideKeyboard()
            view.showMessage(resources.getString(R.string.default_message))
        } else {
            view.showResponseFragmentWithTextViewBackgroundColor(model.getColor())
        }
    }

    override fun onNameChanged(name: String) {
        if (name != model.getName()) {
            saveName(name)
        }
    }

    override fun onRadioButtonChecked(rbIds: RadioButtonColorPerId) {
        val color: Int = getRadioButtonColor(rbIds)
        model.setColor(color)
    }

    private fun getRadioButtonColor(rbIds: RadioButtonColorPerId): Int = when (rbIds) {
        FIRST -> resources.getColorCompat(FIRST.color)
        SECOND -> resources.getColorCompat(SECOND.color)
        THIRD -> resources.getColorCompat(THIRD.color)
    }
}