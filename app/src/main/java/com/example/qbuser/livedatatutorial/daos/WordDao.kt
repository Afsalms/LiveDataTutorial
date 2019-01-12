package com.example.qbuser.livedatatutorial.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.qbuser.livedatatutorial.models.Words


@Dao
interface WordDao {

    @Insert
    fun addNewWord(word: Words)

    @Query("select * from words ORDER by id DESC")
    fun getAllWords: List<Words>
}