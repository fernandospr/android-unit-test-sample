package com.github.fernandospr.validators

class LifemilesIdValidator {
    private val validRange = 10..99999999999

    fun isValid(text: String): Boolean {
        val id = text.toLongOrNull()
        return id != null && inValidRange(id) && isLastDigitValid(id)
    }

    private fun inValidRange(id: Long): Boolean {
        return id in validRange
    }

    private fun isLastDigitValid(id: Long): Boolean {
        val lastDigit = id % 10
        val idExceptLastDigit = id / 10

        return idExceptLastDigit % 7 == lastDigit
    }
}