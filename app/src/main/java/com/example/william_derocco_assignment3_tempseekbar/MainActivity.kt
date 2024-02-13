package com.example.william_derocco_assignment3_tempseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find display message by id
        val displayMsg = findViewById<TextView>(R.id.displayMessage)

        // Find the SeekBars by their IDs
        val fahrenheitSeekBar = findViewById<SeekBar>(R.id.fahrenheitSeekBar)
        val celsiusSeekBar = findViewById<SeekBar>(R.id.celsiusSeekBar)

        // Find the TextViews by their IDs
        val fahrenheitTextView = findViewById<TextView>(R.id.valueFahrenheit)
        val celsiusTextView = findViewById<TextView>(R.id.valueCelsius)

        // Set an OnSeekBarChangeListener to the Fahrenheit SeekBar
        fahrenheitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    // Update the TextView displaying the Fahrenheit value
                    // handle edge case (F below 32)
                    if (progress < 32) {
                        // update F
                        fahrenheitTextView.text = "32"
                        fahrenheitSeekBar.progress = 32
                        // update C
                        celsiusTextView.text = "0"
                        celsiusSeekBar.progress = 0

                        // update display message
                        displayMsg.text = "I wish it were warmer :o"
                    } else {
                        // Convert Fahrenheit to Celsius
                        val celsiusValue = (progress - 32) * 5 / 9

                        // update F
                        fahrenheitTextView.text = progress.toString()
                        fahrenheitSeekBar.progress = progress

                        // update C
                        celsiusSeekBar.progress = celsiusValue
                        celsiusTextView.text = celsiusValue.toString()

                        // update display message
                        if (celsiusValue <= 20) {
                            displayMsg.text = "I wish it were warmer :o"
                        } else {
                            displayMsg.text = "I wish it were colder :("
                        }
                    }
                }
            }

            // We don't need these two methods for our example, but they must be implemented
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // not required i guess?
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // not required i guess?
            }
        })

        // Set an OnSeekBarChangeListener to the Fahrenheit SeekBar
        celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    // Convert Celsius to Fahrenheit
                    val fahrenheitValue = (progress * 9 / 5) + 32

                    // Update the Fahrenheit TextView and SeekBar
                    fahrenheitTextView.text = fahrenheitValue.toString()
                    fahrenheitSeekBar.progress = fahrenheitValue

                    // Update the Celsius TextView and SeekBar
                    celsiusSeekBar.progress = progress
                    celsiusTextView.text = progress.toString()

                    // update display message
                    if (progress <= 20) {
                        displayMsg.text = "I wish it were warmer :o"
                    } else {
                        displayMsg.text = "I wish it were colder :("
                    }
                }
            }

            // We don't need these two methods for our example, but they must be implemented
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // not required i guess?
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // not required i guess?
            }
        })
    }
}