package com.hiep.servlet;

import com.hiep.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123";

    private static final String UPDATE_USERS_SQL = "update users set password = ? , address=? , mail= ? , birthday =? , sex = ? , id_university =? where acount = ?;";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("ok");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("not ok");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("not ok");
        }
        return connection;
    }


    public User loginUser(String Acount, String password){
        User user = null;
        String query = "{CALL login_user(?,?)}";
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1,Acount);
            preparedStatement.setString(2,password);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
//            ResultSet rs2 = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String acount = rs.getString("acount");
                String email = rs.getString("mail");
                String address = rs.getString("address");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");
                String id_university = rs.getString("id_university");

                user = new User(acount, email, address, birthday,sex,id_university);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        String query = "{CALL insert_user(?,?,?,?,?,?,?)}";

        // try-with-resource statement will auto close the connection.

        try (Connection connection = getConnection();

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, user.getAcount());

            callableStatement.setString(2, user.getPassword());

            callableStatement.setString(3, user.getMail());
            callableStatement.setString(4,user.getAddress());
            callableStatement.setString(5, user.getBirthday());
            callableStatement.setString(6, user.getSex());
            callableStatement.setString(7, user.getId_university());


            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);

        }
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getMail());
            statement.setString(5, user.getBirthday());
            statement.setString(6, user.getSex());
            statement.setString(7, user.getId_university());
            statement.setString(1, user.getAcount());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;

    }

    @Override
    public List<User> findUserByIdUniversity(String IdUniversity) {
        String query = "{CALL get_user_by_id_university(?)}";

        List<User> users = new ArrayList<>();
        // Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1,IdUniversity);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String acount = rs.getString("acount");
                String mail = rs.getString("mail");
                String address = rs.getString("address");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");

                users.add(new User(acount,address,mail,birthday,sex));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public User findUserByAcount(String Acount) {
        String query = "{CALL get_user_by_acount(?)}";
        User user = new User();
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1,Acount);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String acount = rs.getString("acount");
                String mail = rs.getString("mail");
                String address = rs.getString("address");
                String birthday = rs.getString("birthday");
                String sex = rs.getString("sex");

                user = new User(acount,mail,address,birthday,sex);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
