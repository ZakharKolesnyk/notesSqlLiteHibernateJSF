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
    public List<Note> assignedNotes() {
        return noteDao.byState(ASSIGNED);
    }

    @Override
    public List<Note> doneNotes() {
        return noteDao.byState(DONE);
    }

    @Override
    public List<Note> performingNotesSublist() {
        return noteDao.byStateSublist(PERFORMING, SIZE_SUBLIST, 0);
    }

    @Override
    public List<Note> assignedNotesSublist() {
        return noteDao.byStateSublist(ASSIGNED, SIZE_SUBLIST, 0);
    }

    @Override
    public List<Note> doneNotesSublist() {
        return noteDao.byStateSublist(DONE, SIZE_SUBLIST, 0);
    }

    @Override
    public void update(Note note) {
        noteDao.update(note);
    }

    @Override
    public void save(Note note) {
        noteDao.save(note);
    }
}
