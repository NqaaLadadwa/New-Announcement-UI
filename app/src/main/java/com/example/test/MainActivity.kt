package com.example.test

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.test.databinding.ActivityMainBinding
import java.util.Calendar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedDate: String = ""
    private lateinit var startDate: StartDateData  // Define the variable here
    private val calendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create an instance of StartDateData
        startDate = StartDateData(
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

        // Set click listener for the arrow icon
        binding.start.arrowIcon.setOnClickListener {
            showDatePicker()
        }
        binding.exp.arrowIcon2.setOnClickListener {
            showDatePicker2()
        }
    }


    private fun showDatePicker() {
        val datePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Update the selectedDate with the selected date
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"

                // Create a new StartDateData instance with updated labelValue
                val newStartDate = StartDateData(
                    labelName = startDate.labelName,
                    labelValue = selectedDate,
                    iconId = startDate.iconId,
                    arrowId = startDate.arrowId
                )

                // Update the binding to use the new StartDateData instance
                binding.startDate = newStartDate
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

    private fun showDatePicker2() {
        val datePicker = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Update the selectedDate with the selected date
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"

                // Create a new StartDateData instance with updated labelValue
                val newExpirationDate = ExpirationDateData(
                    labelName = startDate.labelName,
                    labelValue = selectedDate,
                    iconId = startDate.iconId,
                    arrowId = startDate.arrowId
                )

                // Update the binding to use the new StartDateData instance
                binding.expirationDate = newExpirationDate
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }


    fun onCloseClicked() {
        finish()
    }

    fun onSubmitClicked() {
        finish()
    }

}
