package com.gmail.kolesnyk.zakhar.auth;

import com.gmail.kolesnyk.zakhar.navigation.ViewUtil;
import com.gmail.kolesnyk.zakhar.user.User;
import com.gmail.kolesnyk.zakhar.userService.UserService;
import com.gmail.kolesnyk.zakhar.userService.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

/**
 * The {@code AuthBean} JSF Bean using for authentication operations of users
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
@SessionScoped
@ManagedBean
public class AuthBean implements Serializable {
    private User user;
    private UserService userService = new UserServiceImpl();
    private ViewUtil viewUtil = new ViewUtil();

    private String username;
    private String password;

    /**
     * method initiate request to pages/task_board.jsf if user login and password
     * is coincides with data in database(login), invoking on JSF UI
     */
    public String login() {
        try {
            user = userService.getUserByLoginOrEmailAndPassword(username, password);
            if (user == null) {
                return null;
            }
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("user", user);
            return "pages/task_board";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * method initiate request to pages/index.jsf and invalidate session(logout), invoking on JSF UI
     */
    public void logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addCookie(new Cookie("JSESSIONID", null));
        facesContext.getExternalContext().invalidateSession();
        try {
            response.sendRedirect("index.jsf");
        } catch (IOException e) {
            viewUtil.toErrorPage();
            e.printStackTrace();
        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
