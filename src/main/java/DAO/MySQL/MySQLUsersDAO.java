package DAO.MySQL;

import DAO.UsersDAO;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class MySQLUsersDAO extends MySQLDAO implements UsersDAO {

    public void addUser(String login, String password, String email) {
        insert("users (`login`, `password`, `email`)", "'" + login + "', '" + password + "', '" + email + "'");
    }

}
