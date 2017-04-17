package com.gmail.kolesnyk.zakhar.navigation;

import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.notes.STATE;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * The {@code ViewUtil} utility class for UI needs
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
public class ViewUtil {

    /**
     * constant field what using to cut strings for JSF UI
     */
    private final static int LENGTH_NAME_ON_PAGE = 15;

    private NoteService noteService = new NoteServiceImpl();


    /**
     * method moving {@link Note} if on it changed {@link Note#state}
     * to corresponding list (waiting, performing, done) and updating it on database
     *
     * @param event  event from JSF UI
     * @param wNotes list of waiting notes
     * @param pNotes list of performing notes
     * @param dNotes list of done notes
     */
    public void moveNote(ValueChangeEvent event, List<Note> wNotes, List<Note> pNotes, List<Note> dNotes) {
        event.getComponent().getParent().getParent().getChildren().remove(event.getComponent().getParent());
        Note note = (Note) event.getComponent().getAttributes().get("note");
        STATE oldState = (STATE) event.getOldValue();
        STATE newState = (STATE) event.getNewValue();
        note.setState(newState);

        switch (oldState) {
            case DONE: {
                dNotes.remove(note);
                break;
            }
            case PERFORMING: {
                pNotes.remove(note);
                break;
            }
            case ASSIGNED: {
                wNotes.remove(note);
                break;
            }
        }
        switch (newState) {
            case DONE: {
                note.setDoneDate(new Date());
                dNotes.add(note);
                break;
            }
            case PERFORMING: {
                pNotes.add(note);
                break;
            }
            case ASSIGNED: {
                wNotes.add(note);
                break;
            }
        }
        noteService.update(note);
    }

    /**
     * method cut string by {@link #LENGTH_NAME_ON_PAGE}
     *
     * @param str string what need to cut
     * @return cut string
     */
    public String cutString(String str) {
        if (str.length() > LENGTH_NAME_ON_PAGE) {
            return str.substring(0, LENGTH_NAME_ON_PAGE);
        }
        return str;
    }

    /**
     * method sorting {@link List<Note>} by {@link Note#createDate} in DESC order
     *
     * @param list list what need to sort
     */
    public void sortBeforeView(List<Note> list) {
        list.sort((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate()));
    }

    /**
     * method initiate request to pages/view_note.jsf and addition example of {@link Note}
     * what need to view to session scope, invoking on JSF UI
     *
     * @param note note what need to view
     */
    public String viewNote(Note note) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("note", note);
        return "view_note";
    }

    /**
     * method initiate request to pages/error.jsf, using when need show error page, invoking on JSF UI
     */
    public void toErrorPage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        try {
            response.sendRedirect("error.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
