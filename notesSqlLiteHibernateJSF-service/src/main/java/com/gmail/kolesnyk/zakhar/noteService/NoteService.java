package com.gmail.kolesnyk.zakhar.noteService;

import com.gmail.kolesnyk.zakhar.notes.Note;

import java.util.List;

public interface NoteService {


    List<Note> performingNotes();

    List<Note> waitingNotes();

    List<Note> doneNotes();

    List<Note> performingNotesSublist();

    List<Note> waitingNotesSublist();

    List<Note> doneNotesSublist();

    void update(Note note);
}
