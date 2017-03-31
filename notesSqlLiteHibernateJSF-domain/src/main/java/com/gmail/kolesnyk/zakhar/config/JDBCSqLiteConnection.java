package com.gmail.kolesnyk.zakhar.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCSqLiteConnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:${basedir}/db/notes_db.sqlite");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void disconnect() {
        try {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
