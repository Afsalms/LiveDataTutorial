package com.example.qbuser.livedatatutorial.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.qbuser.livedatatutorial.models.Words
import com.example.qbuser.livedatatutorial.repositories.WordRepository

class wordviewmodel(application: Application): AndroidViewModel(application) {

    private val wordrepo: WordRepository
    private val wordlist: List<Words>

    init {
        wordrepo = WordRepository(application)
        wordlist = wordrepo.getallword()
    }

    fun insertword(word:Words){
        wordrepo.inserwords(word)

    }

    fun getallword(): List<Words>{
        return wordlist
    }


}