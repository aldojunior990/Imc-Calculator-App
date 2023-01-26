package com.aldoj.mvp_kotlin_template.base_contract

interface NavigationContract {
    fun close(animated: Boolean = true)
    fun goBack(animated: Boolean = true)
}

interface ViewContract : NavigationContract {
}

interface PresenterContract<T : ViewContract> {
    fun attachView(view: T) // use it on BaseFragment to automate the attach process
    fun detachView()        // use it on BaseFragment to automate the detach process
}