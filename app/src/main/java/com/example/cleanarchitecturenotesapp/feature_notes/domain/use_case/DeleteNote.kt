package com.example.cleanarchitecturenotesapp.feature_notes.domain.use_case

import com.example.cleanarchitecturenotesapp.feature_notes.domain.model.Notes
import com.example.cleanarchitecturenotesapp.feature_notes.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(notes: Notes) {
        repository.deleteNote(notes)
    }

}