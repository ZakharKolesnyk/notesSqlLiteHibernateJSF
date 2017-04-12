package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.notes.STATE;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@ManagedBean
public class TaskBoardBean implements Serializable {
    private final static int LENGTH_NAME_ON_PAGE = 25;
    private final STATE[] states = STATE.values();

    private NoteService noteService;
    private List<Note> waitingNotes;
    private List<Note> performingNotes;
    private List<Note> doneNotes;


    private Note detailedNote;


    public TaskBoardBean() {
        noteService = new NoteServiceImpl();
        performingNotes = noteService.performingNotesSublist();
        waitingNotes = noteService.waitingNotesSublist();
        doneNotes = noteService.doneNotesSublist();
    }

    public void apply() {
//        waitingNotes.stream().filter(note -> note.getState() != STATE.WAITING)
//                .forEach(a -> noteService.update(a));
//        performingNotes.stream().filter(note -> note.getState() != STATE.PERFORMING)
//                .forEach(a -> noteService.update(a));
//        doneNotes.stream().filter(note -> note.getState() != STATE.DONE)
//                .forEach(a -> noteService.update(a));
    }

    public String cutString(String str) {
        if (str.length() > LENGTH_NAME_ON_PAGE) {
            return str.substring(0, LENGTH_NAME_ON_PAGE);
        }
        return str;
    }

    public STATE[] getStates() {
        return states;
    }

    public void fullWaitingNotesList() {
        waitingNotes = noteService.waitingNotes();
    }

    public void fullPerformingNotesList() {
        performingNotes = noteService.performingNotes();
    }

    public void fullDoneNotesList() {
        doneNotes = noteService.doneNotes();
    }

    public List<Note> getWaitingNotes() {
        return waitingNotes;
    }

    public void setWaitingNotes(List<Note> waitingNotes) {
        this.waitingNotes = waitingNotes;
    }

    public List<Note> getPerformingNotes() {
        return performingNotes;
    }

    public void setPerformingNotes(List<Note> performingNotes) {
        this.performingNotes = performingNotes;
    }

    public List<Note> getDoneNotes() {
        return doneNotes;
    }

    public void setDoneNotes(List<Note> doneNotes) {
        this.doneNotes = doneNotes;
    }

    public void viewDetailsNote(Note note) {
        this.detailedNote = note;
    }

    public Note getDetailedNote() {
        return detailedNote;
    }

    public void setDetailedNote(Note detailedNote) {
        this.detailedNote = detailedNote;
    }
}
