package servlets;

import DAO.ArticlesDAO;
import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HackuunaMatata on 16.01.2017.
 */
@WebServlet(name = "DeleteArticle", urlPatterns = "/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");

        MySQLDAO dao = DAOFactory.getInstanceMySQL();
        ArticlesDAO article = dao.getArticlesDAO();

        article.deleteArticleForUser(title, id);

        response.sendRedirect("/profile");
    }
}
