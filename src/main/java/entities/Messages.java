package entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by HackuunaMatata on 13.01.2017.
 */
public class Messages {
    private int id_from;
    private int id_to;
    private String text;
    private Timestamp datetime;
    private boolean read;

    public Messages(int id_from, int id_to, String text, Timestamp datetime, boolean read) {
        this.id_from = id_from;
        this.id_to = id_to;
        this.text = text;
        this.datetime = datetime;
        this.read = read;
    }

    public int getId_from() {
        return id_from;
    }

    public void setId_from(int id_from) {
        this.id_from = id_from;
    }

    public int getId_to() {
        return id_to;
    }

    public void setId_to(int id_to) {
        this.id_to = id_to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id_from=" + id_from +
                ", id_to=" + id_to +
                ", text='" + text + '\'' +
                ", datetime=" + datetime +
                ", read=" + read +
                '}';
    }
}
