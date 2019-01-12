package com.example.qbuser.livedatatutorial.repositories

import android.app.Application
import com.example.qbuser.livedatatutorial.daos.WordDao
import com.example.qbuser.livedatatutorial.databases.DatabaseHelper
import com.example.qbuser.livedatatutorial.models.Words


class WordRepository(application: Application){

    private val worddao:WordDao
    private val listwords: List<Words>

    init {
        val databaseobj = DatabaseHelper.getInstance(application)
        worddao = databaseobj.wordDao()
        listwords = worddao.getAllWords()
    }

    fun getallword(){
        return listwords
    }

    fun inserwords(word: Words){
        worddao.addNewWord(word)

    }
}