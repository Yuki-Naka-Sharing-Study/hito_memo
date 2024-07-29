package com.example.hito_memo

import kotlinx.coroutines.flow.map

class UserRepository(private val userDao: UserDao) {

    fun getUsers() = userDao.getAll()

    fun getNameOfUserFolder() = userDao.getAll().map {
            it -> it.sortedBy { it.nameOfUserFolder }
    }

    fun getNameOfUser() = userDao.getAll().map {
            it -> it.sortedBy { it.nameOfUser }
    }

    fun getFuriganaOfUser() = userDao.getAll().map {
            it -> it.sortedBy { it.furiganaOfUser }
    }

    fun getNicknameOfUser() = userDao.getAll().map {
            it -> it.sortedBy { it.nicknameOfUser }
    }

}