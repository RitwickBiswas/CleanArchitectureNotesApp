package com.example.cleanarchitecturenotesapp.feature_notes.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturenotesapp.feature_notes.domain.model.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM Notes")
    fun getNotes() : Flow<List<Notes>>

    @Query("SELECT * FROM Notes where id = :id")
    suspend fun getNotebyID(id: Int): Notes?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}