package com.brunodles.concretetestes

import org.junit.Test

import org.junit.Assert.*

class PasswordValidatorTest {

    private val passwordValidator = PasswordValidator()

    @Test
    fun givenValidPassword_whenValidate_shouldReturnTrue() {
        val password = "aB.45678"

        val result : Boolean = passwordValidator.validate(password)

        assertTrue(result)
    }

    @Test
    fun givenPasswordWithLengthLowerThan8_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.validate("1234567")

        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutUppercaseCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.validate("12345678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutLowerCaseCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.validate("A2345678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutNumber_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.validate("Aqwertyuio")

        assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutEspecialCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.validate("aB345678")

        assertFalse(result)
    }

}
