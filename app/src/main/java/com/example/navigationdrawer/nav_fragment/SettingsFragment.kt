package com.example.navigationdrawer.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationdrawer.R
import android.content.Context
import android.content.Intent
import android.widget.*
import com.example.navigationdrawer.BirdLensActivity
import com.example.navigationdrawer.MainActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val unitSelectionGroup = view.findViewById<RadioGroup>(R.id.unitSelectionGroup)
        val metricSwitch = view.findViewById<Switch>(R.id.metricSwitch)
        val maxDistanceEditText = view.findViewById<EditText>(R.id.maxDistanceEditText)
        val saveButton = view.findViewById<Button>(R.id.saveButton)


        val sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val useMetricSystem = sharedPreferences.getBoolean("useMetricSystem", true)
        val metricRadioButton = view.findViewById<RadioButton>(R.id.metricRadioButton)
        val imperialRadioButton = view.findViewById<RadioButton>(R.id.imperialRadioButton)
        metricRadioButton.isChecked = useMetricSystem
        imperialRadioButton.isChecked = !useMetricSystem

        saveButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            val selectedRadioButton = view.findViewById<RadioButton>(unitSelectionGroup.checkedRadioButtonId)
            val useMetricSystem = selectedRadioButton.id == R.id.metricRadioButton

            editor.putBoolean("useMetricSystem", useMetricSystem)
            editor.apply()



            if (useMetricSystem) {
                val distanceInKilometers = 100.0
                val distanceInMiles = kilometersToMiles(distanceInKilometers)
                Toast.makeText(requireContext(), "Distance in Miles: $distanceInMiles", Toast.LENGTH_SHORT).show()
            } else {
                val distanceInMiles = 62.1371
                val distanceInKilometers = milesToKilometers(distanceInMiles)
                Toast.makeText(requireContext(), "Distance in Kilometers: $distanceInKilometers", Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(requireContext(), "Preferences saved", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), HomeFragment::class.java)
            startActivity(intent)
        }



    }

    // Conversion functions
    private fun kilometersToMiles(kilometers: Double): Double {
        return kilometers * 0.621371
    }

    private fun milesToKilometers(miles: Double): Double {
        return miles / 0.621371
    }
}