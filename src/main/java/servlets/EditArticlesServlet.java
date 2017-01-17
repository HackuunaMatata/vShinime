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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by HackuunaMatata on 17.01.2017.
 */
@WebServlet(name = "EditArticles", urlPatterns = "/editArticles")
public class EditArticlesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        MySQLDAO dao = DAOFactory.getInstanceMySQL();
        ArticlesDAO articlesDAO = dao.getArticlesDAO();

        String title = request.getParameter("title");
        String annotation = request.getParameter("annotation");
        Date date = getDateFromString(request.getParameter("date"));

        articlesDAO.updateArticleForUser(annotation, date, id, title);
        response.sendRedirect("/profile");

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

    private static Date getDateFromString(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = null;
        try {
            parsed = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(parsed.getTime());
    }
}
