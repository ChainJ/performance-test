package controller;

import dao.UserDAO;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by JiangCheng on 2017/8/10.
 */
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String offset = request.getParameter("offset"), limit = request.getParameter("limit");
        int off = Integer.valueOf(offset), lim = Integer.valueOf(limit);
        PrintWriter writer = response.getWriter();
        writer.println("doGet()");
        writer.println(userDAO.findOne(Integer.valueOf(id)));
        writer.println(userDAO.findList(off, lim));
        writer.flush();
        writer.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTime start = DateTime.now();
        String count = request.getParameter("count");
        int total;
        try {
            total = Integer.valueOf(count);
        } catch (NumberFormatException e) {
            total = 0;
        }
        for (int i = 0; i < total; i++) {
            userDAO.add(User.generateUser());
        }
        DateTime end = DateTime.now();
        PrintWriter writer = response.getWriter();
        writer.println("doPost()");
        writer.println("it takes " + (end.getMillis() - start.getMillis()) + "ms to create " + total + " users!");
        writer.flush();
        writer.close();
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DateTime start = DateTime.now();
        String offset = request.getParameter("offset"), limit = request.getParameter("limit");
        int off = Integer.valueOf(offset), lim = Integer.valueOf(limit);

        List<User> users = userDAO.findList(off, lim);
        for (User user : users) {
            user.setName(RandomStringUtils.randomAlphabetic(10));
            user.setAge(Integer.valueOf(RandomStringUtils.randomNumeric(2)));
        }
        userDAO.update(users);

        DateTime end = DateTime.now();
        PrintWriter writer = response.getWriter();
        writer.println("doPut()");
        writer.println("it takes " + (end.getMillis() - start.getMillis()) + "ms to update " + users.size() + " users!");
        writer.flush();
        writer.close();
    }

}
