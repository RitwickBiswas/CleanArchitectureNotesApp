package com.example.cleanarchitecturenotesapp.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchitecturenotesapp.ui.theme.BabyBlue
import com.example.cleanarchitecturenotesapp.ui.theme.LightGreen
import com.example.cleanarchitecturenotesapp.ui.theme.RedOrange
import com.example.cleanarchitecturenotesapp.ui.theme.RedPink
import com.example.cleanarchitecturenotesapp.ui.theme.Violet

@Entity
data class Notes(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColor = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
