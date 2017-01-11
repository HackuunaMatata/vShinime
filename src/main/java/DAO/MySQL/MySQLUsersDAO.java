package DAO.MySQL;

import DAO.UsersDAO;
import entities.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class MySQLUsersDAO extends MySQLDAO implements UsersDAO {

    public void addUser(String login, String password, String email) {
        insert("users (`login`, `password`, `email`)", "'" + login + "', '" + password + "', '" + email + "'");
    }

    public List<Users> getTable() {
        List<Users> users = new ArrayList<>();
        ResultSet resultSet = select("users", "1");
        try {
            while (resultSet.next()) {
                Users user = new Users(resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdByLogin(String login) {
        ResultSet resultSet = select("users", "login='" + login + "'");
        try {
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Users getUserById(int id) {
        ResultSet resultSet = select("users", "id='" + id + "'");
        try {
            resultSet.next();
            Users user = new Users(resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(String newPassword, String newEmail, int id) {
        String set;
        String setPassword = newPassword == null ? "" : "password='" + newPassword + "'";
        String setEmail = newEmail == null ? "" : "email='" + newEmail + "'";
        if (!setPassword.equals("") && !setEmail.equals("")) set = setPassword + ", " + setEmail;
        else set = setPassword + setEmail;
        update("users", set, "id='" + id + "'");
    }

}
