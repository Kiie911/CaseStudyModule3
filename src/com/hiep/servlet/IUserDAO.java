package com.hiep.servlet;

import com.hiep.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public User loginUser(String Acount, String password);
    public void insertUser(User user);
    List<User> findUserByIdUniversity(String IdUniversity);
    User findUserByAcount(String Acount);
    public boolean updateUser(User user) throws SQLException;
}
