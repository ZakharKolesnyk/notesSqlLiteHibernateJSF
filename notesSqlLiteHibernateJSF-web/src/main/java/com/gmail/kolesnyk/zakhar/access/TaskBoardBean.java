package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.notes.STATE;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean
public class TaskBoardBean implements Serializable {
    private final static int LENGTH_NAME_ON_PAGE = 25;
    private final STATE[] states = STATE.values();

//    @ManagedProperty(value="#{viewNoteBean}")
//    private ViewNoteBean viewNoteBean;
    private NoteService noteService;
    private List<Note> waitingNotes;
    private List<Note> performingNotes;
    private List<Note> doneNotes;
//    private Note viewNote;

    public TaskBoardBean() {
        noteService = new NoteServiceImpl();
        performingNotes = noteService.performingNotesSublist();
        waitingNotes = noteService.waitingNotesSublist();
        doneNotes = noteService.doneNotesSublist();
    }

    public void changeListener(ValueChangeEvent event) {
        event.getComponent().getParent().getParent().getChildren().remove(event.getComponent().getParent());
        Note note = (Note) event.getComponent().getAttributes().get("note");
        STATE oldState = (STATE) event.getOldValue();
        STATE newState = (STATE) event.getNewValue();
        note.setState(newState);
        noteService.update(note);
        switch (oldState) {
            case DONE: {
                doneNotes.remove(note);
                break;
            }
            case PERFORMING: {
                performingNotes.remove(note);
                break;
            }
            case WAITING: {
                waitingNotes.remove(note);
                break;
            }
        }
        switch (newState) {
            case DONE: {
                doneNotes.add(note);
//                sortBeforeView(doneNotes);
//                doneNotes.sort(Comparator.comparing(Note::getCreateDate));
//                doneNotes.
                break;
            }
            case PERFORMING: {
                performingNotes.add(note);
//                sortBeforeView(performingNotes);
//                performingNotes.sort((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate()));
                break;
            }
            case WAITING: {
                waitingNotes.add(note);
//                sortBeforeView(waitingNotes);
//                waitingNotes.sort((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate()));
                break;
            }
        }
    }

    public String cutString(String str) {
        if (str.length() > LENGTH_NAME_ON_PAGE) {
            return str.substring(0, LENGTH_NAME_ON_PAGE);
        }
        return str;
    }

    public String viewNote(Note note) {
//        Note note = (Note) event.getComponent().getAttributes().get("note");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("note", note);
//        System.out.println("VIEW FORWARD");
//        viewNoteBean.setNote(note);
        return "view_note";
//        String uri = "view_note.jsf";
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
        sortBeforeView(waitingNotes);
        return waitingNotes;
    }

    public void setWaitingNotes(List<Note> waitingNotes) {
        this.waitingNotes = waitingNotes;
    }

    public List<Note> getPerformingNotes() {
        sortBeforeView(performingNotes);
        return performingNotes;
    }

    public void setPerformingNotes(List<Note> performingNotes) {
        this.performingNotes = performingNotes;
    }

    public List<Note> getDoneNotes() {
        sortBeforeView(doneNotes);
        return doneNotes;
    }

    public void setDoneNotes(List<Note> doneNotes) {
        this.doneNotes = doneNotes;
    }

    private void sortBeforeView(List<Note> list){
        list.sort((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate()));
    }

//    public void reSortNotes(){
//        sortBeforeView(waitingNotes);
//        sortBeforeView(performingNotes);
//        sortBeforeView(doneNotes);
//    }

//    public Note getViewNote() {
//        return viewNote;
//    }
//
//    public void setViewNote(Note viewNote) {
//        this.viewNote = viewNote;
//    }
    //    public void setViewNoteBean(ViewNoteBean viewNoteBean) {
//        this.viewNoteBean = viewNoteBean;
//    }
}
