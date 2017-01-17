package DAO.MySQL;

import DAO.ArticlesDAO;
import entities.Articles;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public class MySQLArticlesDAO extends MySQLDAO implements ArticlesDAO {

    public void addArticle(int userId, String title, String annotation, Date date) {
        insert("articles (`user_id`, `title`, `annotation`, `date`)", userId + ", '" + title + "', '" + annotation + "', '" + date + "'");
    }

    public List<Articles> getArticlesByUserId(int userId) {
        List<Articles> articles = new ArrayList<>();
        ResultSet resultSet;
        if (userId != -1) resultSet = select("articles", "user_id='" + userId + "'");
        else resultSet = select("articles", "1");
        try {
            while (resultSet.next()) {
                Articles article = new Articles(resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("annotation"),
                        resultSet.getDate("date"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Articles getArticleForUserByTitle(int userId, String title) {
        ResultSet resultSet;
        resultSet = select("articles", "user_id='" + userId + "' AND title='" + title + "'");
        try {
            resultSet.next();
            Articles article = new Articles(resultSet.getInt("user_id"),
                    resultSet.getString("title"),
                    resultSet.getString("annotation"),
                    resultSet.getDate("date"));
            return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateArticleForUser(String newAnnotation, Date newDate, int userId, String title) {
        String set;
        String setAnnotation = newAnnotation == null ? "annotation=''" : "annotation='" + newAnnotation + "'";
        set = setAnnotation + ", date='" + newDate + "'";
        //String set = "annotation='" + newAnnotation + "', date='" + newDate + "'";
        update("articles", set, "user_id='" + userId + "' AND title='" + title + "'");
    }

    public void deleteArticleForUser(String title, int userId) {
        delete("articles", "user_id='" + userId + "' AND title='" + title + "'");
    }

    public void deleteAllArticlesForUser(int userId) {
        delete("articles", "user_id='" + userId + "'");
    }
}
