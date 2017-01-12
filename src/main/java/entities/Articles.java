package entities;

import java.sql.Date;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public class Articles {
    private int userId;
    private String title;
    private String annotation;
    private Date date;

    public Articles(int userId, String title, String annotation, Date date) {
        this.userId = userId;
        this.title = title;
        this.annotation = annotation;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", annotation='" + annotation + '\'' +
                ", date=" + date +
                '}';
    }
}
