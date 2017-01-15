package filters;

import DAO.UsersDAO;
import entities.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by HackuunaMatata on 15.01.2017.
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/styles/") || requestURI.startsWith("/changeLocale")) {
            chain.doFilter(request, response);
            return;
        }

        // Кладем пользователя в сессию или берем существующего
        Users user = (Users) session.getAttribute("user");
        System.out.println(user);
        if (user == null) {
            user = new Users(-1, null, null, null);
            session.setAttribute("user", user);
        }


        if (user.getLogin() != null) {
            if (requestURI.equals("/") || requestURI.equals("/registration") || requestURI.equals("/login"))
                response.sendRedirect("/profile");
            else chain.doFilter(request, response);
        } else {
            if (requestURI.equals("/registration") || requestURI.equals("/login")) chain.doFilter(request, response);
            else {
                request.setAttribute("loginError", "");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
