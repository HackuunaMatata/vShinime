package DAO.MySQL;

import DAO.ConnectionPool;
import DAO.DAOFactory;
import DAO.UserInfoDAO;
import DAO.UsersDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class MySQLDAO extends DAOFactory {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/vShinime";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private ConnectionPool connectionPool;

    public MySQLDAO() {
        connectionPool = new ConnectionPool(DRIVER, URL, USERNAME, PASSWORD);
    }

    //TODO protected
    public void insert(String table, String value) {
        String sql = "INSERT INTO " + table + " VALUE(" + value + ")";
        System.out.println(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            System.out.println("OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
    }

    public ResultSet select(String table, String condition) {
        String sql = "SELECT * FROM " + table + " WHERE " + condition;
        System.out.println(sql);
        Connection connection = connectionPool.retrieve();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            System.out.println("OK");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return null;
    }

    @Override
    public UsersDAO getUsersDAO() {
        return new MySQLUsersDAO();
    }

    @Override
    public UserInfoDAO getUserInfoDAO() {
        return new MySQLUserInfoDAO();
    }
}
