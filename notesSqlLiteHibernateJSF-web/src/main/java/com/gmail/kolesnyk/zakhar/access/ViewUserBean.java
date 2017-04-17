package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.navigation.ViewUtil;
import com.gmail.kolesnyk.zakhar.noteService.NoteService;
import com.gmail.kolesnyk.zakhar.noteService.NoteServiceImpl;
import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.user.User;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * The {@code ViewUserBean} JSF Bean using for viewing {@link User}
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
@ViewScoped
@ManagedBean
public class ViewUserBean implements Serializable {
    private NoteService noteService;
    private UserService userService;
    private ViewUtil viewUtil;
    private User user;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String authority;
    private Set<Note> fullSet;
    private List<Note> assignedNotes;
    private List<Note> performingNotes;
    private List<Note> doneNotes;

    public ViewUserBean() {
        noteService = new NoteServiceImpl();
        userService = new UserServiceImpl();
        viewUtil = new ViewUtil();
        assignedNotes = new ArrayList<>();
        performingNotes = new ArrayList<>();
        doneNotes = new ArrayList<>();
        init((User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user"));
    }

    private void init(User user) {
        try {
            this.user = user;
            firstName = user.getFirstName();
            lastName = user.getLastName();
            email = user.getEmail();
            login = user.getLogin();
            authority = user.getAuthority().name();
            fullSet = user.getNotes();
            fullSet.stream().sorted((o1, o2) -> o2.getCreateDate().compareTo(o1.getCreateDate())).forEach(note -> {
                switch (note.getState()) {
                    case ASSIGNED: {
                        assignedNotes.add(note);
                        break;
                    }
                    case PERFORMING: {
                        performingNotes.add(note);
                        break;
                    }
                    case DONE: {
                        doneNotes.add(note);
                        break;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    /**
     * apply example entity of {@link User} in database, invoking on JSF UI
     */
    public void applyUser() {
        try {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            userService.update(user);
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

    public String cutString(String str) {
        return viewUtil.cutString(str);
    }

    public String viewNote(Note note) {
        return viewUtil.viewNote(note);
    }

    public void changeListener(ValueChangeEvent event) {
        viewUtil.moveNote(event, assignedNotes, performingNotes, doneNotes);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Note> getAssignedNotes() {
        viewUtil.sortBeforeView(assignedNotes);
        return assignedNotes;
    }

    public List<Note> getPerformingNotes() {
        viewUtil.sortBeforeView(performingNotes);
        return performingNotes;
    }

    public List<Note> getDoneNotes() {
        viewUtil.sortBeforeView(doneNotes);
        return doneNotes;
    }
}
