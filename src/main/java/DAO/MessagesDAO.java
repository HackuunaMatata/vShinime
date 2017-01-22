package DAO;


import entities.Messages;

import java.util.HashMap;
import java.util.List;

/**
 * Created by HackuunaMatata on 13.01.2017.
 */
public interface MessagesDAO {
    void addMessage(int id_from, int id_to, String text);
    List<Messages> getMessages(int id_from, int id_to);
    void readMessages(int id_from, int id_to);
    int countUnreadMessages(int id_from, int id_to);
    int countAllUnreadMessages(int id_to);
    HashMap<Integer, Messages> getLastMessagesForUser(int id_user);
    List<Messages> getLastNMessages(int id_user, int id_guest, int n);
}
