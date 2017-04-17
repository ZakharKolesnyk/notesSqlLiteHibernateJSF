package com.gmail.kolesnyk.zakhar.notes;


import com.gmail.kolesnyk.zakhar.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The {@code Note} JPA entity what mapped on table "notes"
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.notes.NoteDao
 * @since JDK1.8
 */
@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_note")
    private int idNote;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "done_date")
    private Date doneDate;

    @Column(name = "create_date")
    private Date createDate;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    @Column(name = "state")
    private STATE state;

    public Note() {
    }

    public Note(String name, String description, Date doneDate, Date createDate, User user, STATE state) {
        this.name = name;
        this.description = description;
        this.doneDate = doneDate;
        this.createDate = createDate;
        this.user = user;
        this.state = state;
    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int id_note) {
        this.idNote = id_note;
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

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id_note=" + idNote +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doneDate='" + doneDate + '\'' +
                ", createDate='" + createDate + '\'' +
                ", user=" + user.getIdUser() +
                ", state=" + state +
                '}';
    }
}
