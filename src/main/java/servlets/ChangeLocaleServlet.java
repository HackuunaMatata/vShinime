package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by HackuunaMatata on 16.01.2017.
 */
@WebServlet(name = "ChangeLocale", urlPatterns = "/changeLocale")
public class ChangeLocaleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello2222");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Hello");
        String language = request.getParameter("locale");
        Locale locale = null;
        if (language.equals("ru_RU")) locale = new Locale("ru", "RU");
        if (language.equals("en_US")) locale = new Locale("en", "US");
        request.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", language);
        request.getSession().setAttribute("locale", locale);

        String url = request.getHeader("referer");
        System.out.println(url);
        response.sendRedirect(url);
    }
}
