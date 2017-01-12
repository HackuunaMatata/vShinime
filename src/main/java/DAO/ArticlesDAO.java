package DAO;

import entities.Articles;

import java.sql.Date;
import java.util.List;

/**
 * Created by HackuunaMatata on 12.01.2017.
 */
public interface ArticlesDAO {
    public void addArticle(int userId, String title, String annotation, Date date);
    public List<Articles> getArticlesByUserId(int userId);
    public void updateArticleForUser(String newAnnotation, Date newDate, int userId, String title);
    public void deleteArticleForUser(String title, int userId);
    public void deleteAllArticlesForUser(int userId);
}
