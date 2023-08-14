package com.example.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.test.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create an instance of StartDateData
        val startDate = StartDateData(
            labelName = "Start Date",
            labelValue = "Today",
            iconId = R.drawable.calendar,
            arrowId = R.drawable.arrow
        )

        // Create an instance of ExpirationDateData
        val expirationDate = ExpirationDateData(
            labelName = "Expiration Date",
            labelValue = "Tomorrow",
            iconId = R.drawable.calendar,
            arrowId = R.drawable.arrow
        )

        val locationsDate = LocationsData(
            labelName = "Locations",
            labelValue = "Boomering_Common_Payer",
            iconId = R.drawable.location,
            arrowId = R.drawable.arrow
        )

        // Bind data to the layout variables
        binding.startDate = startDate
        binding.expirationDate = expirationDate
        binding.locations = locationsDate

       /* binding.startDate.root.setOnClickListener{

        }*/
    }

    // Method to handle the close button click
    fun onCloseClicked(view: View) {
        finish()
    }

    fun onSubmitClicked(view: View) {
        finish()
    }

}
