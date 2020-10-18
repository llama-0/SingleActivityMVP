package com.llama.simplemvp.presenters

import android.content.res.Resources
import com.llama.simplemvp.models.Model
import com.llama.simplemvp.R
import com.llama.simplemvp.contracts.ResponseContract

class ResponsePresenter(
    private val view: ResponseContract.View,
    private val model: Model,
    private val resources: Resources
) : ResponseContract.Presenter {

    private fun composeMessage(): String =
        resources.getString(R.string.hello, model.getName())

    override fun initView() {
        view.showMessage(composeMessage())
    }
}