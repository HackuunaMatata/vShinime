package DAO;


import entities.Messages;

import java.util.List;

/**
 * Created by HackuunaMatata on 13.01.2017.
 */
public interface MessagesDAO {
    public void addMessage(int id_from, int id_to, String text);
    public List<Messages> getMessages(int id_from, int id_to);
    public void readMessages(int id_from, int id_to);
    public int countUnreadMessages(int id_from, int id_to);
}
