package com.example.hito_memo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class UserViewModel(
    private val repo: UserRepository
): ViewModel() {
    val users: LiveData<List<UserEntity>>
            = repo.getUsers().asLiveData()
    val nameOfUserFolder: LiveData<List<UserEntity>>
            = repo.getNameOfUserFolder().asLiveData()
}
