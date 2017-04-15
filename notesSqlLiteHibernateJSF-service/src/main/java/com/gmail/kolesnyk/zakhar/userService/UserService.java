package com.gmail.kolesnyk.zakhar.userService;

import com.gmail.kolesnyk.zakhar.user.User;

import java.sql.Timestamp;

public interface UserService {
    User getUserByLoginOrEmailAndPassword(String loginOrEmail, String password) throws IllegalAccessException;

    void registrationUser(String firstName, String lastName, Timestamp birthDate, String login, String pass, String confirmPass, String email, String phone) throws IllegalAccessException;

    User getUserById(int idUser);

    User getByLogin(String login);

    void update(User user);
}
