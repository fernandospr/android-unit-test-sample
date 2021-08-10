package com.github.fernandospr.profile

interface ProfileRepository {
	fun save(lifemilesId: String)
}