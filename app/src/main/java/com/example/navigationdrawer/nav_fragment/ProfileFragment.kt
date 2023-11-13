package com.example.navigationdrawer.nav_fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.R

class ProfileFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var btnUpdateProfile: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        editTextName = view.findViewById(R.id.editTextName)
        editTextSurname = view.findViewById(R.id.editTextSurname)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPhoneNumber = view.findViewById(R.id.editTextPhoneNumber)
        btnUpdateProfile = view.findViewById(R.id.btnUpdateProfile)

        btnUpdateProfile.setOnClickListener {
            updateProfile()
        }

        return view
    }

    private fun updateProfile() {
        val name = editTextName.text.toString()
        val surname = editTextSurname.text.toString()
        val email = editTextEmail.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()

        // Perform your update logic here, e.g., update the user's data in a database
        // You can use a ViewModel or a repository to handle data operations

        // For simplicity, let's just log the updated information
        Log.d("ProfileFragment", "Name: $name, Surname: $surname, Email: $email, Phone Number: $phoneNumber")

        // Show a toast message indicating that the profile is updated
        showToast("Profile Updated")
    }

    private fun showToast(message: String) {
        activity?.runOnUiThread {
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}


