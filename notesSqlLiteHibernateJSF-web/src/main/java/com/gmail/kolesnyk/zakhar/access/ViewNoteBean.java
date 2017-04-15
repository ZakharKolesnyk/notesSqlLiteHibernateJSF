package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.navigation.ViewUtil;
import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;

/**
 * The {@code ViewNoteBean} JSF Bean using for viewing {@link Note}
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
@ViewScoped
@ManagedBean
public class ViewNoteBean implements Serializable {

    private NoteService noteService;
    private UserService userService;
    private ViewUtil viewUtil;

    private Note note;
    private String name;
    private String description;
    private String state;
    private String createDate;
    private String doneDate;
    private String login;

    public ViewNoteBean() {
        noteService = new NoteServiceImpl();
        userService = new UserServiceImpl();
        viewUtil = new ViewUtil();
        init((Note) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("note"));
    }

    private void init(Note note) {
        try {
            this.note = note;
            this.name = note.getName();
            this.description = note.getDescription();
            this.state = note.getState().name();
            this.createDate = note.getCreateDate().toString();
            if (note.getDoneDate() != null) {
                this.doneDate = note.getDoneDate().toString();
            }
            this.login = note.getUser().getLogin();
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    /**
     * apply example entity of {@link Note} in database, invoking on JSF UI
     */
    public void applyNote() {
        try {
            note.setCreateDate(new Date());
            note.setName(name);
            note.setDescription(description);
            note.setUser(userService.getByLogin(login));
            createDate = note.getCreateDate().toString();
            noteService.update(note);
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    /**
     * method initiate request to pages/task_board.jsf invoking on JSF UI
     */
    public String backToTaskBoard() {
        return "task_board";
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getLogin() {
        return login;
    }
}
