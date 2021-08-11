package com.github.fernandospr.profile

import com.github.fernandospr.validators.LifemilesIdValidator
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class ProfileViewModelTest {

    private lateinit var autoCloseable: AutoCloseable

    @Mock
    private lateinit var validatorMock: LifemilesIdValidator

    @Mock
    private lateinit var repositoryMock: ProfileRepository

    @Before
    fun setup() {
        autoCloseable = MockitoAnnotations.openMocks(this)
    }

    @After
    fun teardown() {
        autoCloseable.close()
    }

    @Test
    fun `Updating a lifemiles id should call save on repository when lifemiles validator successfully validates`() {
        whenever(validatorMock.isValid(LIFEMILES_ID)).thenReturn(true)
        val viewModel = ProfileViewModel(validatorMock, repositoryMock)

        viewModel.update(LIFEMILES_ID)

        verify(repositoryMock).save(LIFEMILES_ID)
    }

    @Test
    fun `Updating a lifemiles id should not call save on repository when lifemiles validator fails to validate`() {
        whenever(validatorMock.isValid(LIFEMILES_ID)).thenReturn(false)
        val viewModel = ProfileViewModel(validatorMock, repositoryMock)

        viewModel.update(LIFEMILES_ID)

        verify(repositoryMock, never()).save(LIFEMILES_ID)
    }

    private companion object {
        const val LIFEMILES_ID = "1234"
    }
}