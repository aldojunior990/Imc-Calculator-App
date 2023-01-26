package com.aldoj.mvp_kotlin_template.ui.main

import com.aldoj.mvp_kotlin_template.base_contract.PresenterContract
import com.aldoj.mvp_kotlin_template.base_contract.ViewContract
import com.aldoj.mvp_kotlin_template.model.ImcCalculator

interface MainActivityContract {
    interface View: ViewContract {
        fun handleOnClickGenreButton(id: Int)
        fun handleOnClickCalculateButton(imc: Double, msg: String)
        fun handleAlerts()


    }
    interface Presenter: PresenterContract<View> {
        fun onClickGenreButton(id: Int)
        fun onClickCalculateButton(height: Double, weight:Double, genre: String, calculator: ImcCalculator)

    }
}