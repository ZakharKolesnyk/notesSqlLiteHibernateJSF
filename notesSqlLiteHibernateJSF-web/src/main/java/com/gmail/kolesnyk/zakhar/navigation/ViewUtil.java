package com.gmail.kolesnyk.zakhar.navigation;

import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.notes.STATE;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.List;

/**
 * Created by User on 15.04.2017.
 */
public class ViewUtil {
    private final static int LENGTH_NAME_ON_PAGE = 20;

    private NoteService noteService = new NoteServiceImpl();

    public void moveNote(ValueChangeEvent event, List<Note> wNotes, List<Note> pNotes, List<Note> dNotes) {
        event.getComponent().getParent().getParent().getChildren().remove(event.getComponent().getParent());
        Note note = (Note) event.getComponent().getAttributes().get("note");
        STATE oldState = (STATE) event.getOldValue();
        STATE newState = (STATE) event.getNewValue();
        note.setState(newState);
        noteService.update(note);
        switch (oldState) {
            case DONE: {
                dNotes.remove(note);
                break;
            }
            case PERFORMING: {
                pNotes.remove(note);
                break;
            }
            case WAITING: {
                wNotes.remove(note);
                break;
            }
        }
        switch (newState) {
            case DONE: {
                dNotes.add(note);
//                sortBeforeView(doneNotes);
//                doneNotes.sort(Comparator.comparing(Note::getCreateDate));
//                doneNotes.
                break;
            }
            case PERFORMING: {
                pNotes.add(note);
//                sortBeforeView(performingNotes);
//                performingNotes.sort((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate()));
                break;
            }
            case WAITING: {
                wNotes.add(note);
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


    public void sortBeforeView(List<Note> list) {
        list.sort((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate()));
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
}
