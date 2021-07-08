package com.example.moneyconverter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Launcher Icons Created
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.mipmap.ic_launcher_round)

        val currencyAmount = findViewById<EditText>(R.id.inputValue)
        val crypto2Dollar = findViewById<RadioButton>(R.id.Ethr2DollarButton)
        val dollar2Crypto = findViewById<RadioButton>(R.id.Dollar2EthrButton)
        val result = findViewById<TextView>(R.id.idResults)
        val convertButton = findViewById<Button>(R.id.convertButton)

        convertButton.setOnClickListener {
            val tenth = DecimalFormat("#.##")
            var dblCurrency = currencyAmount.text.toString().toDouble()
            val conversionRate = 2146.71 //Value of Ethereum as of 7/8/2021
            var convertedNum: Double?

            if (crypto2Dollar.isChecked) {
                if (dblCurrency != 0.0) {
                    convertedNum = dblCurrency * conversionRate
                    result.text = "$"+tenth.format(convertedNum)
                    if (convertedNum>10000){
                        Toast.makeText(this@MainActivity, "YOU'RE RICH!!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Please enter in a number", Toast.LENGTH_LONG)
                        .show()
                }
            }

            if (dollar2Crypto.isChecked) {
                if (dblCurrency > 100) {
                    convertedNum = dblCurrency / conversionRate
                    result.text = tenth.format(convertedNum) + " ETH"
                } else {
                    result.text = "0 ETH"
                    Toast.makeText(
                        this@MainActivity,
                        "Not worth anything, enter more than $100",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }
}