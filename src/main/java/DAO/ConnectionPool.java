package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by HackuunaMatata on 11.01.2017.
 */
public class ConnectionPool {
        public BlockingQueue<Connection> connections;
        private final static int LENGTH = 5;

        public ConnectionPool(String driver, String url, String username, String password) {
            connections = new ArrayBlockingQueue<>(LENGTH);
            try {
                Class.forName(driver);
                for(int i = 0; i < LENGTH; i++) {
                    connections.add(DriverManager.getConnection(url, username, password));
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection retrieve() {
            try {
                return connections.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void putback(Connection connection) {
            try {
                connections.put(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
