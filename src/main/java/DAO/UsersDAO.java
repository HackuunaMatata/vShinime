package DAO;

import entities.Users;

import java.util.List;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public interface UsersDAO {
    int addUser(String login, String password, String email);
    List<Users> getTable();
    int getIdByLogin(String login);
    Users getUserById(int id);
    void updateUser(String newPassword, String newEmail, int id);
}
