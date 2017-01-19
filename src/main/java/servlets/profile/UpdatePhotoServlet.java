package servlets.profile;

import DAO.DAOFactory;
import DAO.UserInfoDAO;
import entities.UserInfo;
import entities.Users;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import utils.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by HackuunaMatata on 20.01.2017.
 */
@WebServlet(name = "UpdatePhoto", urlPatterns = "/updatePhoto")
public class UpdatePhotoServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(UpdatePhotoServlet.class);
    private static final String IMAGES_PATH = "C:/Users/Vesdet/IdeaProjects/vShinime/target/vShinime/images/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int id = user.getId();

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                FileItem item = multiparts.get(0);
                if (!item.isFormField()) {
                    DAOFactory dao = DAOFactory.getInstanceDAO();
                    UserInfoDAO userInfoDAO = dao.getUserInfoDAO();
                    UserInfo userInfo = userInfoDAO.getUserInfoById(id);
                    new File(IMAGES_PATH + userInfo.getPhoto()).delete();

                    String photoName = HashPassword.getMD5Hash("" + id + "*" + System.currentTimeMillis());
                    item.write(new File(IMAGES_PATH + photoName));
                    userInfoDAO.updateUserPhoto(photoName, id);
                }
            } catch (Exception e) {
                log.error("updatePhoto: ", e);
            }
        }

        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
