package DAO.MySQL;

import DAO.MessagesDAO;
import entities.Messages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HackuunaMatata on 13.01.2017.
 */
public class MySQLMessagesDAO  extends MySQLDAO implements MessagesDAO {

    public void addMessage(int id_from, int id_to, String text) {
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        insert("messages (`id_from`, `id_to`, `text`, `datetime`, `read`)",
                "" + id_from + ", " + id_to + ", '" + text + "', '" + datetime + "', 0");
    }

    public List<Messages> getMessages(int id_from, int id_to) {
        List<Messages> messages = new ArrayList<>();
        ResultSet resultSet = select("messages",
                "id_from='" + id_from + "' AND id_to='" + id_to + "'");
        try {
            while (resultSet.next()) {
                Messages message = new Messages(resultSet.getInt("id_from"),
                        resultSet.getInt("id_to"),
                        resultSet.getString("text"),
                        resultSet.getTimestamp("datetime"),
                        resultSet.getBoolean("read"));
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void readMessages(int id_from, int id_to) {
        update("messages", "`read`=1", "id_from='" + id_from + "' AND id_to='" + id_to + "'");
    }

    public int countUnreadMessages(int id_from, int id_to) {
        ResultSet resultSet = count("messages",
                "id_from='" + id_from + "' AND id_to='" + id_to + "' AND NOT `read`");
        try {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
