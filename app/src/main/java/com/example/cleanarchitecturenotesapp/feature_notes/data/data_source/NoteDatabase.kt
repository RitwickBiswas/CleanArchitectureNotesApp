package com.example.cleanarchitecturenotesapp.feature_notes.data.data_source


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturenotesapp.feature_notes.domain.model.Notes

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }

}