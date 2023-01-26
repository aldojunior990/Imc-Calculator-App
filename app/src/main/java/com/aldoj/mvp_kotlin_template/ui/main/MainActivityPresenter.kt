package com.aldoj.mvp_kotlin_template.ui.main

import com.aldoj.mvp_kotlin_template.model.ImcCalculator


class MainActivityPresenter : MainActivityContract.Presenter {

    private var view: MainActivityContract.View? = null

    override fun onClickGenreButton(id: Int) {
        view?.handleOnClickGenreButton(id)
    }

    override fun onClickCalculateButton(
        height: Double,
        weight: Double,
        genre: String,
        calculator: ImcCalculator
    ) {
        if (height <= 0.0 || height > 2.5 || weight <= 0.0) {
            view?.handleAlerts()
            return
        } else if (genre == "") {
            view?.handleAlerts()
            return
        }

        calculator.calculate(height, weight, genre)

        view?.handleOnClickCalculateButton(calculator.getImc(), calculator.getMessage())
    }

    override fun attachView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}