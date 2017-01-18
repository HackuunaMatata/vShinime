package DAO.MySQL;

import DAO.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class MySQLDAO extends DAOFactory {
    private static final Logger log = Logger.getLogger(MySQLDAO.class);

    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/vShinime";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private static ConnectionPool connectionPool = null;

    public MySQLDAO() {
        if (connectionPool == null)
            connectionPool = new ConnectionPool(DRIVER, URL, USERNAME, PASSWORD);
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
