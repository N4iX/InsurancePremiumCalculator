package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinnerAge.setOnItemClickListener(this)

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }

        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.isChecked = false
            textViewPremium.text = getString(R.string.insurance_premium)
        }
    }

    private fun calculatePremium() {
        val position = spinnerAge.selectedItemPosition
        val gender = radioGroupGender.checkedRadioButtonId

        var premium:Int = 0
        var extraPaymentMale:Int = 0
        var extraPaymentSmoker:Int = 0

        if(position == 0){
            premium = 60
        }
        else if(position == 1){
            premium = 70

            if(gender == R.id.radioButtonMale){
                extraPaymentMale = 50
            }

            if(checkBoxSmoker.isChecked){
                extraPaymentSmoker = 100
            }
        }
        else if(position == 2){
            premium = 90

            if(gender == R.id.radioButtonMale){
                extraPaymentMale = 100
            }

            if(checkBoxSmoker.isChecked){
                extraPaymentSmoker = 150
            }
        }
        else if(position == 3){
            premium = 120

            if(gender == R.id.radioButtonMale){
                extraPaymentMale = 150
            }

            if(checkBoxSmoker.isChecked){
                extraPaymentSmoker = 200
            }
        }
        else if(position == 4){
            premium = 150

            if(gender == R.id.radioButtonMale){
                extraPaymentMale = 200
            }

            if(checkBoxSmoker.isChecked){
                extraPaymentSmoker = 250
            }
        }
        else if(position == 5){
            premium = 150

            if(gender == R.id.radioButtonMale){
                extraPaymentMale = 200
            }

            if(checkBoxSmoker.isChecked){
                extraPaymentSmoker = 300
            }
        }

        //textViewPremium.text = "Premium : RM " + premium + "<br>" + "Extra payment for male : RM " + extraPaymentMale + "Extra payment for smoker: RM " + extraPaymentSmoker

        textViewPremium.text = getString(R.string.insurance_premium) + " RM " + (premium + extraPaymentMale + extraPaymentSmoker)

    }
}
