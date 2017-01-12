package DAO;

import DAO.MySQL.MySQLDAO;
import entities.Positions;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public abstract class DAOFactory {
    public static MySQLDAO getInstanceMySQL() {
        return new MySQLDAO();
    }

    public abstract UsersDAO getUsersDAO();
    public abstract UserInfoDAO getUserInfoDAO();
    public abstract PositionsDAO getPositionsDAO();
    public abstract ArticlesDAO getArticlesDAO();
}
