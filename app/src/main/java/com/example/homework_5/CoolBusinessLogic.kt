package com.example.homework_5

class CoolBusinessLogic {

    private val validPattern = "8\\d{10}"
    private val formatPattern = "\\d(\\d{3})(\\d{3})(\\d{2})(\\d{2})"

    fun isValidPhoneNumber(number: String): Boolean {
        return number.matches(validPattern.toRegex())
    }

    fun format(number: String): String {
        val regex = formatPattern.toRegex()
        val result = regex.matchEntire(number)
        val g = result!!.groups
        return "+7 (${g[1]!!.value}) ${g[2]!!.value}-${g[3]!!.value}-${g[4]!!.value}"
    }

}
