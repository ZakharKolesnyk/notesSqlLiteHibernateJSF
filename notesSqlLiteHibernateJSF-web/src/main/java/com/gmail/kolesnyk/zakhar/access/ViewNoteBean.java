package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;

@ViewScoped
@ManagedBean
public class ViewNoteBean implements Serializable {

//    @ManagedProperty(value="#{taskBoardBean}")
//    TaskBoardBean taskBoardBean;
    private NoteService noteService;
    private UserService userService;
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
        init((Note) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("note"));
    }

    private void init(Note note) {
        this.note = note;
        this.name = note.getName();
        this.description = note.getDescription();
        this.state = note.getState().name();
        this.createDate = note.getCreateDate().toString();
        if (note.getDoneDate() != null) {
            this.doneDate = note.getDoneDate().toString();
        }
        this.login = note.getUser().getLogin();
    }

    public void applyNote() {
//        Map<String, Object> atributes = event.getComponent().getAttributes();
//        atributes.keySet().forEach(System.out::println);
//        atributes.values().forEach(System.out::println);
//        System.out.println(note);
//        System.out.println(name);
        note.setCreateDate(new Date());
        note.setName(name);
        note.setDescription(description);
        note.setUser(userService.getByLogin(login));
        createDate = note.getCreateDate().toString();
        noteService.update(note);
//        taskBoardBean.reSortNotes();
    }

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

    public String getDoneDate() {
        return doneDate;
    }

    public String getLogin() {
        return login;
    }
}
