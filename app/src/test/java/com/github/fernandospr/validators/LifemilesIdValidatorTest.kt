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
}