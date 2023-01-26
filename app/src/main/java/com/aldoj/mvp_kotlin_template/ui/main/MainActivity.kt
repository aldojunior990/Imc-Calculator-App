package com.aldoj.mvp_kotlin_template.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.aldoj.mvp_kotlin_template.R
import com.aldoj.mvp_kotlin_template.base_contract.BaseActivity
import com.aldoj.mvp_kotlin_template.base_contract.PresenterContract
import com.aldoj.mvp_kotlin_template.base_contract.ViewContract
import com.aldoj.mvp_kotlin_template.databinding.ActivityMainBinding
import com.aldoj.mvp_kotlin_template.model.ImcCalculator
import com.aldoj.mvp_kotlin_template.ui.result.ResultActivity
import java.lang.Double
import java.text.DecimalFormat
import kotlin.math.roundToInt


class MainActivity : BaseActivity<MainActivityContract.Presenter>(R.layout.activity_main),
    MainActivityContract.View {

    private lateinit var binding: ActivityMainBinding
    private val presenter: MainActivityPresenter = MainActivityPresenter()
    private var selectedGenre: String = ""
    private val calculator: ImcCalculator = ImcCalculator()
    override fun getPresenter() = presenter as PresenterContract<ViewContract>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMale.setOnClickListener { presenter.onClickGenreButton(binding.btnMale.id) }
        binding.btnFemale.setOnClickListener { presenter.onClickGenreButton(binding.btnFemale.id) }

        binding.btnCalc.setOnClickListener {
            if (binding.etHeight.text.isEmpty() && binding.etWeight.text.isEmpty()) {
                handleAlerts()
                return@setOnClickListener
            } else {
                presenter.onClickCalculateButton(
                    binding.etHeight.text.toString().toDouble(),
                    binding.etWeight.text.toString().toDouble(),
                    selectedGenre,
                    calculator
                )
            }
        }
    }

    override fun handleOnClickGenreButton(id: Int) {
        if (id == binding.btnMale.id) {
            binding.btnMale.isActivated = true
            binding.btnFemale.isActivated = false
            selectedGenre = "male"
        } else {
            binding.btnMale.isActivated = false
            binding.btnFemale.isActivated = true
            selectedGenre = "female"
        }
    }

    override fun handleOnClickCalculateButton(imc: kotlin.Double, msg: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("imc", DecimalFormat("#.##").format(calculator.getImc()).toString())
        intent.putExtra("message", calculator.getMessage())
        startActivity(intent)
    }

    override fun handleAlerts() {
        Toast.makeText(this, "Insira valores válidos!", Toast.LENGTH_SHORT).show()
    }

}