package com.gmail.kolesnyk.zakhar.noteService;

import com.gmail.kolesnyk.zakhar.notes.Note;

import java.util.List;

public interface NoteService {
    int LENGTH_SUBLIST = 2;

    List<Note> performingNotes();

    List<Note> waitingNotes();

    List<Note> doneNotes();

    List<Note> performingNotesSublist();

    List<Note> waitingNotesSublist();

    List<Note> doneNotesSublist();

    void update(Note note);
    void save(Note note);
}
