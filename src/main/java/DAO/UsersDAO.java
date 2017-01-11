package DAO;

import entities.Users;

import java.util.List;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public interface UsersDAO {
    public void addUser(String login, String password, String email);
    public List<Users> getTable();
    public int getIdByLogin(String login);
    public Users getUserById(int id);
}
