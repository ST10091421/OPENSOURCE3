package com.example.navigationdrawer.nav_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.navigationdrawer.MainActivity
import com.example.navigationdrawer.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GamificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GamificationFragment : Fragment(R.layout.fragment_gamification) {
    // TODO: Rename and change types of parameters
    private var secretNumber: Int = 0
    private var numberOfTries: Int = 0
    private lateinit var guessEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var checkButton: Button
    private lateinit var backToMainMenuButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        guessEditText = view.findViewById<EditText>(R.id.guessEditText)
        resultTextView = view.findViewById<TextView>(R.id.resultTextView)
        checkButton = view.findViewById<Button>(R.id.checkButton)
        backToMainMenuButton = view.findViewById<Button>(R.id.backToMainMenuButton)


        secretNumber = (1..100).random()

        checkButton.setOnClickListener {
            val userGuess = guessEditText.text.toString()
            if (userGuess.isNotEmpty()){
                val guess = userGuess.toInt()
                numberOfTries++
                if (guess == secretNumber) {
                    resultTextView.text = "Congratulations! You guessed the number in $numberOfTries tries."
                    guessEditText.isEnabled = false
                    checkButton.isEnabled = false
                } else if (guess < secretNumber) {
                    resultTextView.text = "Try higher."
                } else {
                    resultTextView.text = "Try lower."
                }
            }
        }

        backToMainMenuButton.setOnClickListener {
            navigateToMainMenu()
        }
    }

    private fun navigateToMainMenu() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }
}

