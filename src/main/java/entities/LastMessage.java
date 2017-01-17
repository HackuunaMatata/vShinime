package entities;

import java.sql.Timestamp;

/**
 * Created by HackuunaMatata on 17.01.2017.
 */
public class LastMessage {
    private String from;
    private String colleague;
    private int colleagueId;
    private String message;
    private Timestamp date;
    private int countUnreaded;

    public LastMessage(String from, String colleague, int colleagueId, String message, Timestamp date, int countUnreaded) {
        this.from = from;
        this.colleague = colleague;
        this.colleagueId = colleagueId;
        this.message = message;
        this.date = date;
        this.countUnreaded = countUnreaded;
    }

    public int getColleagueId() {
        return colleagueId;
    }

    public void setColleagueId(int colleagueId) {
        this.colleagueId = colleagueId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getColleague() {
        return colleague;
    }

    public void setColleague(String colleague) {
        this.colleague = colleague;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getCountUnreaded() {
        return countUnreaded;
    }

    public void setCountUnreaded(int countUnreaded) {
        this.countUnreaded = countUnreaded;
    }

    @Override
    public String toString() {
        return "LastMessage{" +
                "from='" + from + '\'' +
                ", colleague='" + colleague + '\'' +
                ", colleagueId=" + colleagueId +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", countUnreaded=" + countUnreaded +
                '}';
    }
}
