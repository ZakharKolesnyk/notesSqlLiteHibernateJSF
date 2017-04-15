package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.navigation.ViewUtil;
import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Date;

import static com.gmail.kolesnyk.zakhar.notes.STATE.WAITING;

/**
 * The {@code AddNoteBean} JSF Bean using for creating and saving to database new {@link Note}
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
@ViewScoped
@ManagedBean
public class AddNoteBean implements Serializable {
    private NoteService noteService;
    private UserService userService;
    private ViewUtil viewUtil;

    private String name;
    private String description;
    private String employee;

    public AddNoteBean() {
        noteService = new NoteServiceImpl();
        userService = new UserServiceImpl();
        viewUtil = new ViewUtil();
    }

    /**
     * method create and save new {@link Note}, invoking on JSF UI
     */
    public void add() {
        try {
            Note note = new Note();
            note.setName(name);
            note.setDescription(description);
            note.setState(WAITING);
            note.setCreateDate(new Date());
            note.setUser(userService.getByLogin(employee));
            noteService.save(note);
            clear();
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

    private void clear() {
        name = "";
        description = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
