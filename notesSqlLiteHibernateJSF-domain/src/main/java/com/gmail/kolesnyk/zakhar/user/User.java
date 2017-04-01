package com.gmail.kolesnyk.zakhar.user;


import com.gmail.kolesnyk.zakhar.notes.Note;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity()
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Note> notes;

    @Column(name = "authority")
    private AUTHORITY authority;

    public User() {
    }

    public User(String firstName, String lastName, String email, String login, String pass, Set<Note> notes, AUTHORITY authority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.pass = pass;
        this.notes = notes;
        this.authority = authority;
    }

    public AUTHORITY getAuthority() {
        return authority;
    }

    public void setAuthority(AUTHORITY role) {
        this.authority = role;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", notes=" + notes +
                ", role=" + authority +
                '}';
    }
}
