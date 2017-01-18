package DAO;

import DAO.MySQL.MySQLDAO;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public abstract class DAOFactory {
    private static final Logger log = Logger.getLogger(DAOFactory.class);

    public static DAOFactory getInstanceDAO() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("C:\\Users\\Vesdet\\IdeaProjects\\vShinime\\src\\main\\resources\\config.properties");
            property.load(fis);
            String database = property.getProperty("database");

            switch (database) {
                case "mysql":
                    return new MySQLDAO();
                default:
                    break;
            }
        } catch (IOException e) {
            log.error("Error: file of properties is absent!");
        }
        return null;
    }

    public abstract UsersDAO getUsersDAO();
    public abstract UserInfoDAO getUserInfoDAO();
    public abstract PositionsDAO getPositionsDAO();
    public abstract ArticlesDAO getArticlesDAO();
    public abstract MessagesDAO getMessagesDAO();
}
