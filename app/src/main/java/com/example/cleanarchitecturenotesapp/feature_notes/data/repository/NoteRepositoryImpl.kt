package com.example.cleanarchitecturenotesapp.feature_notes.data.repository

import com.example.cleanarchitecturenotesapp.feature_notes.data.data_source.NoteDao
import com.example.cleanarchitecturenotesapp.feature_notes.domain.model.Notes
import com.example.cleanarchitecturenotesapp.feature_notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao): NoteRepository {
    override fun getNotes(): Flow<List<Notes>> {
        return dao.getNotes()
    }

    override suspend fun getNotebyID(id: Int): Notes? {
        return dao.getNotebyID(id)
    }

    override suspend fun insertNote(notes: Notes) {
        dao.insertNote(notes)
    }

    override suspend fun deleteNote(note: Notes) {
        dao.deleteNote(note)
    }
}