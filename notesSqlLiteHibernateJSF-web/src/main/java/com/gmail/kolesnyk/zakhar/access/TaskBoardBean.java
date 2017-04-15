package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.navigation.ViewUtil;
import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.user.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean
public class TaskBoardBean implements Serializable {

    private ViewUtil viewUtil;
    private NoteService noteService;
    private List<Note> waitingNotes;
    private List<Note> performingNotes;
    private List<Note> doneNotes;

    public TaskBoardBean() {
        noteService = new NoteServiceImpl();
        viewUtil = new ViewUtil();
        try {
            performingNotes = noteService.performingNotesSublist();
            waitingNotes = noteService.waitingNotesSublist();
            doneNotes = noteService.doneNotesSublist();
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }

    }

    public String addUser() {
        return "add_user";
    }

    public String addNote() {
        return "add_note";
    }

    public void changeListener(ValueChangeEvent event) {
        viewUtil.moveNote(event, waitingNotes, performingNotes, doneNotes);
    }

    public String viewUser(User user) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
        return "view_user";
    }

    public String cutString(String str) {
        return viewUtil.cutString(str);
    }

    public String viewNote(Note note) {
        return viewUtil.viewNote(note);
    }

    public void fullWaitingNotesList() {
        try {
            waitingNotes = noteService.waitingNotes();
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    public void fullPerformingNotesList() {
        try {
            performingNotes = noteService.performingNotes();
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    public void fullDoneNotesList() {
        try {
            doneNotes = noteService.doneNotes();
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    public List<Note> getWaitingNotes() {
        viewUtil.sortBeforeView(waitingNotes);
        return waitingNotes;
    }

    public void setWaitingNotes(List<Note> waitingNotes) {
        this.waitingNotes = waitingNotes;
    }

    public List<Note> getPerformingNotes() {
        viewUtil.sortBeforeView(performingNotes);
        return performingNotes;
    }

    public void setPerformingNotes(List<Note> performingNotes) {
        this.performingNotes = performingNotes;
    }

    public List<Note> getDoneNotes() {
        viewUtil.sortBeforeView(doneNotes);
        return doneNotes;
    }

    public void setDoneNotes(List<Note> doneNotes) {
        this.doneNotes = doneNotes;
    }
}
