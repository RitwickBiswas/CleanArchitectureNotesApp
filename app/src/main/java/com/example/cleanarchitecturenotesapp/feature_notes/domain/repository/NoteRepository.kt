package com.example.cleanarchitecturenotesapp.feature_notes.domain.repository

import com.example.cleanarchitecturenotesapp.feature_notes.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes() : Flow<List<Notes>>

    suspend fun getNotebyID(id: Int): Notes?

    suspend fun insertNote(notes: Notes)

    suspend fun deleteNote(note: Notes)
}