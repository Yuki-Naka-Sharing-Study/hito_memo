package com.example.hito_memo

class UserRepository(private val userDao: UserDao) {
    fun getUsers() = userDao.getAll()

//    fun getNameOfUserFolder() = getUsers().map {
//            it -> it.sortedBy { it.nameOfUserFolder }
//    }

    fun getNameOfUserFolder(): List<UserEntity> {
        // データベースからフォルダ名を取得する処理を実装
        return listOf()
    }
}