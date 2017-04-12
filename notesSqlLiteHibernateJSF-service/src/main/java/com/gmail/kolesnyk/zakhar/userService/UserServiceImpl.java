package com.gmail.kolesnyk.zakhar.userService;

import com.gmail.kolesnyk.zakhar.user.User;
import com.gmail.kolesnyk.zakhar.user.UserDao;
import com.gmail.kolesnyk.zakhar.user.UserDaoImpl;
import com.gmail.kolesnyk.zakhar.validation.encoder.Encoder;
import com.gmail.kolesnyk.zakhar.validation.encoder.EncoderMD5;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private Encoder encoder;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
        this.encoder = new EncoderMD5();
    }

    @Override
    public User getUserByLoginOrEmailAndPassword(String loginOrEmail, String password) throws IllegalAccessException {
        User user;
        if (loginOrEmail.contains("@")) {
            user = userDao.byEmail(loginOrEmail);
        } else {
            user = userDao.byLogin(loginOrEmail);
        }
        if (user != null && user.getPass().equals(encoder.encodePassword(password))) {
            return user;
        }
        return null;
    }

    @Override
    public void registrationUser(String firstName, String lastName, Timestamp birthDate, String login, String pass, String confirmPass, String email, String phone) throws IllegalAccessException {
        if (!pass.trim().equals(confirmPass.trim())) {
            throw new IllegalArgumentException("passwords not match");
        }
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPass(encoder.encodePassword(pass.trim()));
        user.setEmail(email);
        userDao.save(user);
    }

    @Override
    public User getUserById(int idUser) {
        return userDao.byId(idUser);
    }
}
