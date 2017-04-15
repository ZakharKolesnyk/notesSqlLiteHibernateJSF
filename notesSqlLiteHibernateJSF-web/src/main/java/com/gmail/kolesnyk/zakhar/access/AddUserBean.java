package com.gmail.kolesnyk.zakhar.access;

import com.gmail.kolesnyk.zakhar.navigation.ViewUtil;
import com.gmail.kolesnyk.zakhar.user.AUTHORITY;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean
public class AddUserBean implements Serializable {
    private UserService userService;
    private ViewUtil viewUtil;

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String confirm;
    private AUTHORITY authority;

    public AddUserBean() {
        userService = new UserServiceImpl();
        viewUtil = new ViewUtil();
    }

    public void add() {
        try {
            userService.registrationUser(firstName, lastName, login, email, password, confirm, authority);
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            viewUtil.toErrorPage();
        }
    }

    public String backToTaskBoard() {
        return "task_board";
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

    public AUTHORITY getAuthority() {
        return authority;
    }

    public void setAuthority(AUTHORITY authority) {
        this.authority = authority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    private void clear() {
        firstName = "";
        lastName = "";
        login = "";
        email = "";
        password = "";
        confirm = "";
        authority = AUTHORITY.EMPLOYEE;
    }
}
