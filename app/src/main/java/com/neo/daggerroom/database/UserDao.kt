package com.neo.daggerroom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Query("select * from user_entity order by id desc")
    fun getAllRecordsFromDb(): List<UserEntity>?

    @Insert
    fun insertRecord(userEntity: UserEntity)
}