package com.github.fernandospr.validators

import org.junit.Assert
import org.junit.Test

class LifemilesIdValidatorTest {
    @Test
    fun `Empty id should not validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("")

        Assert.assertFalse(result)
    }

    @Test
    fun `id with char should not validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("c")

        Assert.assertFalse(result)
    }

    @Test
    fun `id number with one digit should not validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("1")

        Assert.assertFalse(result)
    }

    @Test
    fun `id number with twelve digits should not validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("123456789012")

        Assert.assertFalse(result)
    }

    @Test
    fun `First valid id number should validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("11")

        Assert.assertTrue(result)
    }

    @Test
    fun `Last valid id number should validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("99999999993")

        Assert.assertTrue(result)
    }

    @Test
    fun `id number inside valid range and valid last digit should validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("12342")

        Assert.assertTrue(result)
    }

    @Test
    fun `id number inside valid range and invalid last digit should not validate`() {
        val validator = LifemilesIdValidator()

        val result = validator.isValid("12343")

        Assert.assertFalse(result)
    }

}