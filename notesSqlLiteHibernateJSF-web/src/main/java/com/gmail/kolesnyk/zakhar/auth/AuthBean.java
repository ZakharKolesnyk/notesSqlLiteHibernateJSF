package com.gmail.kolesnyk.zakhar.auth;

import com.gmail.kolesnyk.zakhar.user.User;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@SessionScoped
@ManagedBean
public class AuthBean implements Serializable {
    private User user;
    private UserService userService = new UserServiceImpl();

    private String username = "";
    private String password = "";

    public String login() {
        try {
            user = userService.getUserByLoginOrEmailAndPassword(username, password);
            if (user == null) {
                return null;
            }
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//            session.setAttribute("user", user);
            return "task_board";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }
}
