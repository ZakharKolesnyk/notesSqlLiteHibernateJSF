package com.gmail.kolesnyk.zakhar.noteService;

import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.notes.NoteDao;
import com.gmail.kolesnyk.zakhar.notes.NoteDaoImpl;

import java.util.List;

import static com.gmail.kolesnyk.zakhar.notes.STATE.*;

public class NoteServiceImpl implements NoteService {

    private NoteDao noteDao;

    public NoteServiceImpl() {
        noteDao = new NoteDaoImpl();
    }

    @Override
    public List<Note> performingNotes() {
        return noteDao.byState(PERFORMING);
    }

    @Override
    public List<Note> waitingNotes() {
        return noteDao.byState(WAITING);
    }

    @Override
    public List<Note> doneNotes() {
        return noteDao.byState(DONE);
    }

    @Override
    public List<Note> performingNotesSublist() {
        return noteDao.byStateSublist(PERFORMING, LENGTH_SUBLIST, 0);
    }

    @Override
    public List<Note> waitingNotesSublist() {
        return noteDao.byStateSublist(WAITING, LENGTH_SUBLIST, 0);
    }

    @Override
    public List<Note> doneNotesSublist() {
        return noteDao.byStateSublist(DONE, LENGTH_SUBLIST, 0);
    }

    @Override
    public void update(Note note) {
        noteDao.update(note);
    }


}
