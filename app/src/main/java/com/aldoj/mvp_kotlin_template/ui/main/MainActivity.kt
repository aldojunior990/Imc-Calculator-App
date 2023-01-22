package com.aldoj.mvp_kotlin_template.ui.main

import android.os.Bundle
import com.aldoj.mvp_kotlin_template.R
import com.aldoj.mvp_kotlin_template.base_contract.BaseActivity
import com.aldoj.mvp_kotlin_template.base_contract.PresenterContract
import com.aldoj.mvp_kotlin_template.base_contract.ViewContract
import com.aldoj.mvp_kotlin_template.databinding.ActivityMainBinding


class MainActivity : BaseActivity<MainActivityContract.Presenter>(R.layout.activity_main),
    MainActivityContract.View {

    private lateinit var binding: ActivityMainBinding
    private val presenter: MainActivityPresenter = MainActivityPresenter()
    override fun getPresenter() = presenter as PresenterContract<ViewContract>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}