package com.aldoj.mvp_kotlin_template.ui.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldoj.mvp_kotlin_template.R
import com.aldoj.mvp_kotlin_template.base_contract.BaseActivity
import com.aldoj.mvp_kotlin_template.base_contract.PresenterContract
import com.aldoj.mvp_kotlin_template.base_contract.ViewContract
import com.aldoj.mvp_kotlin_template.databinding.ActivityResultBinding
import com.aldoj.mvp_kotlin_template.ui.main.MainActivity

class ResultActivity : BaseActivity<ResultActivityContract.Presenter>(R.layout.activity_result), ResultActivityContract.View {

    private val presenter: ResultActivityPresenter = ResultActivityPresenter()
    override fun getPresenter() = presenter as PresenterContract<ViewContract>
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleInflateVariables()
        binding.btnGoBack.setOnClickListener{ presenter.onClickGoBackButton() }
    }

    override fun handleOnClickGoBackButton() {
       val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun handleInflateVariables() {
        val imc = intent.getStringExtra("imc")
        val msg = intent.getStringExtra("message")

        binding.tvResult.text = imc
        binding.tvMessage.text = msg
    }


}