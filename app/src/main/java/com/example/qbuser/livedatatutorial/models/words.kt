package com.example.qbuser.livedatatutorial.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Words {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name: String? = null

}