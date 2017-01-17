package servlets;

import DAO.ArticlesDAO;
import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import entities.Articles;
import entities.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by HackuunaMatata on 17.01.2017.
 */
@WebServlet(name = "EditArticles", urlPatterns = "/editArticles")
public class EditArticlesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();
        String title = request.getParameter("title");

        MySQLDAO dao = DAOFactory.getInstanceMySQL();
        ArticlesDAO articlesDAO = dao.getArticlesDAO();
        Articles article = articlesDAO.getArticleForUserByTitle(id, title);

        System.out.println(article);
        request.setAttribute("article", article);
        request.getRequestDispatcher("jsp/editArticles.jsp").forward(request, response);
    }
}
