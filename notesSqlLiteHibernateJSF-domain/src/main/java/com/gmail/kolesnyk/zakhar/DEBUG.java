package com.gmail.kolesnyk.zakhar;


import com.gmail.kolesnyk.zakhar.config.HibernateUtil;
import com.gmail.kolesnyk.zakhar.config.JDBCSqLiteConnection;
import com.gmail.kolesnyk.zakhar.user.User;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DEBUG {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.createCriteria(User.class).list().forEach(System.out::println);
//        Set<User> userSet = new HashSet<>();
//        Connection conn = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            conn = new JDBCSqLiteConnection().getConnection();
//            preparedStatement = conn.prepareStatement("SELECT * FROM 'user';");
//            preparedStatement.execute();
//            resultSet = preparedStatement.getResultSet();
//            while (resultSet.next()) {
//                userSet.add(new User(0, resultSet.getString("first_name"), resultSet.getString("last_name")
//                        , resultSet.getString("email"), resultSet.getString("login"), resultSet.getString("pass")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//                preparedStatement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        userSet.forEach(System.out::println);
    }
}
