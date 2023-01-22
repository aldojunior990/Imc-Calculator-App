package com.aldoj.mvp_kotlin_template.base_contract

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P: PresenterContract<*>>(@LayoutRes contentLayoutId: Int): AppCompatActivity(contentLayoutId), ViewContract {


    abstract fun getPresenter(): PresenterContract<ViewContract>

    override fun onStart() {
        super.onStart()
        getPresenter().attachView(this)
    }

    override fun onStop() {
        super.onStop()
        getPresenter().detachView()
    }

    override fun close(animated: Boolean) = Unit
    override fun goBack(animated: Boolean) = Unit

}