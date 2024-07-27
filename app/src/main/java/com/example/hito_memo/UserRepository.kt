package com.example.hito_memo

import kotlinx.coroutines.flow.map

class UserRepository(private val userDao: UserDao) {
    fun getUsers() = userDao.getAll()

    fun getNameOfUserFolder() = getUsers().map {
            it -> it.sortedBy { it.nameOfUserFolder }
    }
}