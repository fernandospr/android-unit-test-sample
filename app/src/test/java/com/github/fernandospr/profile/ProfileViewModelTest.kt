package com.github.fernandospr.profile

import com.github.fernandospr.validators.LifemilesIdValidator
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class ProfileViewModelTest {
    @Test
    fun `Updating a lifemiles id should call save on repository when lifemiles validator successfully validates`() {
        val validatorMock: LifemilesIdValidator = mock()
        val repositoryMock: ProfileRepository = mock()
        whenever(validatorMock.isValid("1234")).thenReturn(true)
        val viewModel = ProfileViewModel(validatorMock, repositoryMock)

        viewModel.update("1234")

        verify(repositoryMock).save("1234")
    }

    @Test
    fun `Updating a lifemiles id should not call save on repository when lifemiles validator fails to validate`() {
        val validatorMock: LifemilesIdValidator = mock()
        val repositoryMock: ProfileRepository = mock()
        whenever(validatorMock.isValid("1234")).thenReturn(false)
        val viewModel = ProfileViewModel(validatorMock, repositoryMock)

        viewModel.update("1234")

        verify(repositoryMock, never()).save("1234")
    }
}