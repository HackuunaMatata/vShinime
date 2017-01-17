package DAO.MySQL;

import DAO.MessagesDAO;
import entities.Messages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HackuunaMatata on 13.01.2017.
 */
public class MySQLMessagesDAO extends MySQLDAO implements MessagesDAO {

    public void addMessage(int id_from, int id_to, String text) {
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        insert("messages (`id_from`, `id_to`, `text`, `datetime`, `read`)",
                "" + id_from + ", " + id_to + ", '" + text + "', '" + datetime + "', 0");
    }

    public List<Messages> getMessages(int id_from, int id_to) {
        List<Messages> messages = new ArrayList<>();
        ResultSet resultSet = select("messages",
                "id_from='" + id_from + "' AND id_to='" + id_to + "'");
        return getListFromResultSet(resultSet);
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
        return 0;
    }

    public int countAllUnreadMessages(int id_to) {
        ResultSet resultSet = count("messages",
                "id_to='" + id_to + "' AND NOT `read`");
        try {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public HashMap<Integer, Messages> getLastMessagesForUser(int id_user) {
        ResultSet resultSet = select("messages", "id_from='" + id_user + "' OR id_to='" + id_user + "'");
        List<Messages> allMessages = getListFromResultSet(resultSet);
        HashMap<Integer, Messages> messages = new HashMap<>();
        for (Messages allMessage : allMessages) {
            if (messages.containsKey(allMessage.getId_from())) {
                Messages inMap = messages.get(allMessage.getId_from());
                int id = allMessage.getId_from();
                if (inMap.getDatetime().compareTo(allMessage.getDatetime()) < 0) {
                    messages.remove(id);
                    messages.put(id, allMessage);
                }
            } else if (messages.containsKey(allMessage.getId_to())) {
                Messages inMap = messages.get(allMessage.getId_to());
                int id = allMessage.getId_to();
                if (inMap.getDatetime().compareTo(allMessage.getDatetime()) < 0) {
                    messages.remove(id);
                    messages.put(id, allMessage);
                }
            } else {
                if (allMessage.getId_from() == id_user) {
                    messages.put(allMessage.getId_to(), allMessage);
                } else {
                    messages.put(allMessage.getId_from(), allMessage);
                }
            }

        }
        return messages;
    }

    private List<Messages> getListFromResultSet(ResultSet resultSet) {
        List<Messages> messages = new ArrayList<>();
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
}
