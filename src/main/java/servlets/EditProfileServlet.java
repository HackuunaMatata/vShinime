package servlets;

import DAO.DAOFactory;
import DAO.MySQL.MySQLDAO;
import DAO.PositionsDAO;
import DAO.UserInfoDAO;
import DAO.UsersDAO;
import entities.Positions;
import entities.UserInfo;
import entities.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by HackuunaMatata on 16.01.2017.
 */
@WebServlet(name = "EditProfile", urlPatterns = "/editProfile")
@MultipartConfig
public class EditProfileServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(EditProfileServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();
        UsersDAO usersDAO = dao.getUsersDAO();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(request.getParameter("bday"));
        Date bday = getDateFromString(request.getParameter("bday"));
        System.out.println(bday);
        String magazine = request.getParameter("magazine");
        int position = Integer.parseInt(request.getParameter("position"));

        String photo = userInfoDAO.getUserInfoById(id).getPhoto();
        Part filePart = request.getPart("photo");
        if (filePart.getSize() != 0) {
            photo = String.valueOf(id) + ".png";
            writeFile(filePart, id);
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (password.equals("")) password = user.getPassword();

        userInfoDAO.updateUserInfo(name, surname, bday, position, magazine, photo, id);
        usersDAO.updateUser(password, email, id);

        session.setAttribute("user", new Users(id, user.getLogin(), password, email));

        response.sendRedirect("/profile");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        DAOFactory dao = DAOFactory.getInstanceDAO();
        PositionsDAO positionsDAO = dao.getPositionsDAO();
        UserInfoDAO userInfoDAO = dao.getUserInfoDAO();

        UserInfo userInfo = userInfoDAO.getUserInfoById(id);
        List<Positions> positions = positionsDAO.getTable();


        request.setAttribute("userInfo", userInfo);
        request.setAttribute("positions", positions);
        request.getRequestDispatcher("jsp/editProfile.jsp").forward(request, response);
    }

    private static Date getDateFromString(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = null;
        try {
            parsed = format.parse(date);
        } catch (ParseException e) {
            log.error("getDateFromString: ", e);        }
        return new Date(parsed.getTime());
    }

    private static void writeFile(Part input, int userId) {
        try {
            Path path = Paths.get("C:\\Users\\Vesdet\\IdeaProjects\\vShinime\\src\\main\\webapp\\images\\data\\" + userId + ".png");
            Files.createDirectories(path.getParent());
            try {
                Files.createFile(path);
            } catch (FileAlreadyExistsException e) {
                System.err.println("already exists");
            }
            OutputStream os = new FileOutputStream("C:\\Users\\Vesdet\\IdeaProjects\\vShinime\\src\\main\\webapp\\images\\data\\" + userId + ".png");

            InputStream is = input.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            is.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
