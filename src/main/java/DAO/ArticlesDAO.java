package DAO;

import entities.Articles;

import java.sql.Date;
import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public interface ArticlesDAO {
    void addArticle(int userId, String title, String annotation, Date date);
    List<Articles> getArticlesByUserId(int userId);
    void updateArticleForUser(String newAnnotation, Date newDate, int userId, String title);
    void deleteArticleForUser(String title, int userId);
    void deleteAllArticlesForUser(int userId);
    Articles getArticleForUserByTitle(int userId, String title);
}
