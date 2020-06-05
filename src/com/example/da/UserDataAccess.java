package com.example.da;

import com.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDataAccess {
    private PreparedStatement loginStatement;

    private PreparedStatement getLoginStatement() throws SQLException, ClassNotFoundException {
        if(loginStatement == null) {
            //2. Connect
            Connection connection = new DBConnection().getConnection();
            //3. Create Statement
            loginStatement = connection
                    .prepareStatement("SELECT id, username, password FROM user WHERE username LIKE ? AND password LIKE ?");
        }
        return loginStatement;
    }

    public List<User> getUser(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getLoginStatement();

        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        List<User> users = new LinkedList<>();
        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password")));
        }
        return users;
    }

}
