package com.gmail.kolesnyk.zakhar.notes;


import com.gmail.kolesnyk.zakhar.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_note")
    private int id_note;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private boolean done;

    @Column(name = "done_date")
    private String doneDate;

    @Column(name = "create_date")
    private String createDate;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public Note() {
    }

    public Note(String name, String description, boolean done, String doneDate, String createDate) {
        this.name = name;
        this.description = description;
        this.done = done;
        this.doneDate = doneDate;
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id_note=" + id_note +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", doneDate='" + doneDate + '\'' +
                ", createDate='" + createDate + '\'' +
                ", user=" + user.getIdUser() +
                '}';
    }
}
