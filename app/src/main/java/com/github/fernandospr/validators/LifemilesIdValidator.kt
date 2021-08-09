package com.github.fernandospr.validators

class LifemilesIdValidator {

    fun isValid(text: String): Boolean {
        val number = text.toLongOrNull()
        
        if (number == null) {
            return false
        }
        
        if (number < 10 || number >= 100_000_000_000) {
            return false
        }

        val a = number / 10
        val b = number % 10
        val result = a % 7 == b
        if (!result) {
            return false
        }
        
        return true
    }
    
}