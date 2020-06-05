package com.example.model;

import com.example.da.UserDataAccess;
import com.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public class LoginBean {
    private int id;
    private String name, username, password;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    private List<User> getUser() throws SQLException, ClassNotFoundException {
//        return new UserDataAccess().getUser(username, password);
//    }

    public boolean checkLogin() {
        UserDataAccess usersDataAccess = new UserDataAccess();
        try {
            List<User> users = usersDataAccess.getUser(username, password);
            return !users.isEmpty();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
