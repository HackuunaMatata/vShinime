package DAO.MySQL;

import DAO.*;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class MySQLDAO extends DAOFactory {
    private static final Logger log = Logger.getLogger(MySQLDAO.class);

    private static ConnectionPool connectionPool = null;

    public MySQLDAO() {
        if (connectionPool == null) {
            FileInputStream fis;
            Properties property = new Properties();

            try {
                fis = new FileInputStream("C:\\Users\\Vesdet\\IdeaProjects\\vShinime\\src\\main\\resources\\config.properties");
                property.load(fis);

                String DRIVER = property.getProperty("mysql.DRIVER");
                String URL = property.getProperty("mysql.URL");
                String USERNAME = property.getProperty("mysql.USERNAME");
                String PASSWORD = property.getProperty("mysql.PASSWORD");
                connectionPool = new ConnectionPool(DRIVER, URL, USERNAME, PASSWORD);
            } catch (IOException e) {
                log.error("Error: file of properties is absent!");
            }
        }
    }

    protected void insert(String table, String value) {
        String sql = "INSERT INTO " + table + " VALUE(" + value + ")";
        log.info(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            log.info("query success!");
        } catch (SQLException e) {
            log.error("insert: ", e);
        } finally {
            connectionPool.putback(connection);
        }
    }

    /**
     * Get result set from DB with chosen conditions.
     *
     * @param table the name of the table in DB
     * @param condition string of parameters after <code>WHERE</code>
     * @return a <code>ResultSet</code> object that contains the data produced
     *         by the given query or <code>null</code>
     */
    protected ResultSet select(String table, String condition) {
        String sql = "SELECT * FROM " + table + " WHERE " + condition;
        log.info(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            log.info("query success!");
            return resultSet;
        } catch (SQLException e) {
            log.error("select: ", e);
        } finally {
            connectionPool.putback(connection);
        }
        return null;
    }

    protected ResultSet count(String table, String condition) {
        String sql = "SELECT COUNT(*) FROM " + table + " WHERE " + condition;
        log.info(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            log.info("query success!");
            return resultSet;
        } catch (SQLException e) {
            log.error("count: ", e);
        } finally {
            connectionPool.putback(connection);
        }
        return null;
    }

    protected void update(String table, String set, String condition) {
        String sql = "UPDATE " + table + " SET " + set + " WHERE " + condition;
        log.info(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            log.info("query success!");
        } catch (SQLException e) {
            log.error("update: ", e);
        } finally {
            connectionPool.putback(connection);
        }
    }

    protected void delete(String table, String condition) {
        String sql = "DELETE FROM " + table + " WHERE " + condition;
        log.info(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            log.info("query success!");
        } catch (SQLException e) {
            log.error("delete: ", e);
        } finally {
            connectionPool.putback(connection);
        }
    }

    @Override
    public UsersDAO getUsersDAO() {
        return new MySQLUsersDAO();
    }

    @Override
    public UserInfoDAO getUserInfoDAO() {
        return new MySQLUserInfoDAO();
    }

    @Override
    public PositionsDAO getPositionsDAO() {
        return new MySQLPositionsDAO();
    }

    @Override
    public ArticlesDAO getArticlesDAO() {
        return new MySQLArticlesDAO();
    }

    @Override
    public MessagesDAO getMessagesDAO() {
        return new MySQLMessagesDAO();
    }
}
