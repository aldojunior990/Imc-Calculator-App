package com.aldoj.mvp_kotlin_template.ui.result

import com.aldoj.mvp_kotlin_template.base_contract.PresenterContract
import com.aldoj.mvp_kotlin_template.base_contract.ViewContract

interface ResultActivityContract {
    interface View : ViewContract {
        fun handleOnClickGoBackButton()
        fun handleInflateVariables()

    }

    interface Presenter : PresenterContract<View> {
        fun onClickGoBackButton()

    }
}