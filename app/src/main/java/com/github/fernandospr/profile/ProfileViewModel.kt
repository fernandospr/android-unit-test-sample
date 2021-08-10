package com.github.fernandospr.profile

import com.github.fernandospr.validators.LifemilesIdValidator

class ProfileViewModel(
    private val validator: LifemilesIdValidator,
    private val repository: ProfileRepository
) {
    fun update(lifemilesId: String) {
        if (validator.isValid(lifemilesId)) {
            repository.save(lifemilesId)
        }
    }
}