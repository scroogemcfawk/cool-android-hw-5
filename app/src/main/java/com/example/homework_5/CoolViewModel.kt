package com.example.homework_5

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class CoolViewModel : ViewModel() {

    private val outputExample = "+7 (xxx) xxx-xx-xx"
    private val outputError = "Invalid input (must be 11 digits)"

    private val businessLogic = CoolBusinessLogic()

    var state by mutableStateOf(CoolState.WAITING)
        private set

    var inputState by mutableStateOf("")

    var outputState by mutableStateOf(outputExample)

    private fun resetState() {
        state = CoolState.WAITING
    }
    fun updateInput(str: String) {
        resetState()
        inputState = str
    }

    fun updateOutput() {
        if (businessLogic.isValidPhoneNumber(inputState)) {
            state = CoolState.SUCCESS
            outputState = businessLogic.format(inputState)
        } else {
            state = CoolState.ERROR
            outputState = outputError
        }
    }

    fun getOutputColor(): Color {
        return when(state) {
            CoolState.WAITING -> Color.Black
            CoolState.ERROR -> Color.Red
            CoolState.SUCCESS -> Color.Green
        }
    }

}

enum class CoolState {
    WAITING,
    ERROR,
    SUCCESS
}
