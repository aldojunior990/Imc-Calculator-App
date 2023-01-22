package com.aldoj.mvp_kotlin_template.ui.main

import com.aldoj.mvp_kotlin_template.base_contract.PresenterContract
import com.aldoj.mvp_kotlin_template.base_contract.ViewContract

interface MainActivityContract {
    interface  View: ViewContract {

    }
    interface Presenter: PresenterContract<View> {

    }
}