package com.aldoj.mvp_kotlin_template.base_contract

interface NavigationContract {
}

interface ViewContract : NavigationContract {
}

interface PresenterContract<T : ViewContract> {
    fun attachView(view: T)
    fun detachView()
}