package com.gmail.kolesnyk.zakhar;


import com.gmail.kolesnyk.zakhar.notes.Note;
import com.gmail.kolesnyk.zakhar.notes.NoteDao;
import com.gmail.kolesnyk.zakhar.notes.NoteDaoImpl;
import com.gmail.kolesnyk.zakhar.user.AUTHORITY;
import com.gmail.kolesnyk.zakhar.user.User;
import com.gmail.kolesnyk.zakhar.user.UserDao;
import com.gmail.kolesnyk.zakhar.user.UserDaoImpl;

import java.util.Set;

public class DEBUG {
    public static void main(String[] args) {
        int count=0;
//        System.out.println(new Date());
        UserDao userDao = new UserDaoImpl();

        User user = userDao.byId(1);
        System.out.println("\n\n----------------------------------"+count++);
        System.out.println(user);

        user.setLastName("LAST_NAME");
        userDao.update(user);
        User user2 = userDao.byId(1);
        System.out.println("\n\n----------------------------------"+count++);
        System.out.println(user2);

        User user3 = new User("111", "111", "1111", "LOGIN1", "111",null, AUTHORITY.USER);
        userDao.save(user3);
        User user4 = userDao.byLogin("LOGIN1");
        System.out.println("\n\n----------------------------------"+count++);
        System.out.println(user4);

        userDao.remove(user4);
        System.out.println("\n\n----------------------------------"+count++);
        userDao.list().forEach(a-> a.getNotes().forEach(System.out::println));

        System.out.println("\n\n----------------------------------"+count++);
        user.getNotes().forEach(System.out::println);

        NoteDao noteDao=new NoteDaoImpl();
        noteDao.list().forEach(System.out::println);
        System.out.println(user.getAuthority());
        System.out.println(user2.getAuthority());
        System.out.println(user3.getAuthority());
        System.out.println(user4.getAuthority());



//        Session session=HibernateUtil.getSessionFactory().openSession();
//        session.createCriteria(User.class).list().forEach(a->((User)a).getNotes().forEach(System.out::println));
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
