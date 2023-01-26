package com.aldoj.mvp_kotlin_template.ui.result

class ResultActivityPresenter : ResultActivityContract.Presenter {

    private var view: ResultActivityContract.View? = null
    override fun onClickGoBackButton() {
        view?.handleOnClickGoBackButton()
    }

    override fun attachView(view: ResultActivityContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

}