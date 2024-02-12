package com.example.william_derocco_assignment3_tempseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the SeekBar for Fahrenheit by its ID
        val fahrenheitSeekBar = findViewById<SeekBar>(R.id.fahrenheitSeekBar)

        // Set an OnSeekBarChangeListener to the Fahrenheit SeekBar
        fahrenheitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the TextView displaying the Fahrenheit value
                val valueTextView = findViewById<TextView>(R.id.valueFahrenheit)
                valueTextView.text = progress.toString()


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