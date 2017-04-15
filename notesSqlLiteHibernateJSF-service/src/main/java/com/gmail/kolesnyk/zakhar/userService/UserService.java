package com.gmail.kolesnyk.zakhar.userService;

import com.gmail.kolesnyk.zakhar.user.AUTHORITY;
import com.gmail.kolesnyk.zakhar.user.User;

/**
 * The {@code UserService} contains service methods with entity class {@link User}
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
public interface UserService {

    /**
     * method allow to get {@link User} by it {@link User#email} or {@link User#login}, and {@link User#pass}
     *
     * @param loginOrEmail login or email of user
     * @param password     password of user
     * @throws IllegalAccessException exception throws if user have not equal login or email or password
     */
    User getUserByLoginOrEmailAndPassword(String loginOrEmail, String password) throws IllegalAccessException;

    /**
     * method allow to create and save new {@link User} after with comparing "password" and "confirm password"
     *
     * @param firstName   first name of user
     * @param lastName    last name of user
     * @param login       login of user
     * @param email       email of user
     * @param pass        password of user
     * @param confirmPass confirm password of user
     * @param authority   authority of user
     * @throws IllegalAccessException exception throws if user have not equal login or email or password
     */
    void registrationUser(String firstName, String lastName, String login, String email, String pass, String confirmPass, AUTHORITY authority) throws IllegalAccessException;

    /**
     * method allow to get {@link User} by it ID in database
     *
     * @param idUser ID of user in database
     * @return entity of {@link User}
     */
    User getUserById(int idUser);


    /**
     * method allow to get {@link User} by it login in database
     *
     * @param login login of user in database
     * @return entity of {@link User}
     */
    User getByLogin(String login);

    /**
     * method allow to update {@link User} in database by example of entity
     *
     * @param user example what need to update in database
     */
    void update(User user);
}
