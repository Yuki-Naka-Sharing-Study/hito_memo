package com.example.hito_memo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "name_of_user_folder")
    var nameOfUserFolder: String = "",

    @ColumnInfo(name = "name_of_user")
    var nameOfUser: String = "",

    @ColumnInfo(name = "furigana_of_user")
    var furiganaOfUser: String = "",

    @ColumnInfo(name = "nickname_of_user")
    var nicknameOfUser: String = "",

    @ColumnInfo(name = "sex_of_user")
    var sexOfUser: String = "",

    @ColumnInfo(name = "birthday_of_user")
    var birthdayOfUser: String = "",

    @ColumnInfo(name = "origin_of_user")
    var originOfUser: String = "",

    @ColumnInfo(name = "address_of_user")
    var addressOfUser: String = "",

    @ColumnInfo(name = "occupation_of_user")
    var occupationOfUser: String = "",

    @ColumnInfo(name = "relationship_of_user")
    var relationshipOfUser: String = "",

    @ColumnInfo(name = "folder_of_user")
    var folderOfUser: String = "",

    @ColumnInfo(name = "telephone_number_of_user")
    var telephoneNumberOfUser: String = "",

    @ColumnInfo(name = "email_of_user")
    var emailOfUser: String = "",

    @ColumnInfo(name = "x_of_user")
    var xOfUser: String = "",

    @ColumnInfo(name = "instagram_of_user")
    var instagramOfUser: String = "",

    @ColumnInfo(name = "custom_one_of_user")
    var customOneOfUser: String = "",

    @ColumnInfo(name = "custom_two_of_user")
    var customTwoOfUser: String = "",

    @ColumnInfo(name = "custom_three_of_user")
    var customThreeOfUser: String = "",

    @ColumnInfo(name = "memo_of_user")
    var memoOfUser: String = "",
)