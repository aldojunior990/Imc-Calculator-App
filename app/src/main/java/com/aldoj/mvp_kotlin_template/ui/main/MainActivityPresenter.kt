package com.aldoj.mvp_kotlin_template.ui.main



class MainActivityPresenter: MainActivityContract.Presenter {

    private var view: MainActivityContract.View? = null

    override fun attachView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }


    override fun onAttached() = Unit
    override fun onDetached() = Unit
    override fun onDestroy() = Unit
}