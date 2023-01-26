package com.aldoj.mvp_kotlin_template.model

class ImcCalculator {

    private var message: String = ""
    private var imc: Double = 0.0

    private fun setImc(imc: Double) {
        this.imc = imc
    }

    private fun setMessage(msg: String) {
        this.message = msg
    }

    fun getMessage(): String {
        return this.message
    }

    fun getImc(): Double {
        return this.imc
    }

    fun calculate(height: Double, weight: Double, genre: String) {
        setImc(weight / (height * height))

        if (genre == "female") {
            if (imc < 19.1) {
                setMessage("Voce está abaixo do Peso")
            } else if (imc in 19.1..25.8) {
                setMessage("Voce está no peso ideal")
            } else if (imc in 25.9..27.3) {
                setMessage("Voce está um pouco acima do peso")
            } else if (imc in 27.4..32.3) {
                setMessage("Voce está acima do peso")
            } else if (imc >= 32.4) {
                setMessage("Voce está com obesidade")
            }
        } else if (genre == "male") {
            if (imc < 20.7) {
                setMessage("Voce está abaixo do Peso")
            } else if (imc in 20.7..26.4) {
                setMessage("Voce está no peso ideal")
            } else if (imc in 26.5..27.8) {
                setMessage("Voce está um pouco acima do peso")
            } else if (imc in 27.9..31.1) {
                setMessage("Voce está acima do peso")
            } else if (imc >= 31.2) {
                setMessage("Voce está com obesidade")
            }
        }

    }
}