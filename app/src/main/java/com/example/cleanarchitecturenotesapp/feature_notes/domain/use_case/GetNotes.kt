package com.example.cleanarchitecturenotesapp.feature_notes.domain.use_case

import com.example.cleanarchitecturenotesapp.feature_notes.domain.model.Notes
import com.example.cleanarchitecturenotesapp.feature_notes.domain.repository.NoteRepository
import com.example.cleanarchitecturenotesapp.feature_notes.domain.util.NoteOrder
import com.example.cleanarchitecturenotesapp.feature_notes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Descending)
    ): Flow<List<Notes>> {
        return repository.getNotes().map { note ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> note.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> note.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> note.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> note.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> note.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> note.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}