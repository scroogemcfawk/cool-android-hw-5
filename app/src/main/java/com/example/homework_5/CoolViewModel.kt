package com.example.homework_5

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class CoolViewModel : ViewModel() {

    private val defaultInput = "8 800 555 35 35"
    private val businessLogic = CoolBusinessLogic()

    var state by mutableStateOf(defaultInput)
        private set

    fun isValid(): Boolean {
        return businessLogic.isValidPhoneNumber(getFilteredInput())
    }

    fun getFilteredInput(): String {
        var temp = state
        for (s in listOf(" ", "(", ")", "-", ".")) {
            temp = temp.replace(s, "")
        }
        return temp
    }

    fun changeInput(input: String) {
        state = input
    }

    fun getInput(): String {
        return state
    }

    fun getOutput(): String {
        if (!isValid()) {
            return "Invalid number (must contain 11 digit)"
        }
        return businessLogic.format(getFilteredInput())
    }

    fun getOutputColor(): Color {
        return if (isValid()) Color.Black else Color.Red
    }
}
