package servlets.articles;

import DAO.ArticlesDAO;
import DAO.DAOFactory;
import entities.Articles;
import entities.Users;
import org.apache.log4j.Logger;

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
@WebServlet(name = "AddArticles", urlPatterns = "/addArticles")
public class AddArticlesServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(AddArticlesServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        ArticlesDAO articlesDAO = dao.getArticlesDAO();

        String title = request.getParameter("newTitle");
        String annotation = request.getParameter("annotation");
        Date date = getDateFromString(request.getParameter("date"));

        articlesDAO.addArticle(id, title, annotation, date);
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        Articles article = new Articles(id, "", "", new Date(System.currentTimeMillis()));

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
            log.error("getDateFromString: ", e);
        }
        return new Date(parsed.getTime());
    }
}
