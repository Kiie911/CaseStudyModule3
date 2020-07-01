package com.hiep.controller;

import com.hiep.model.User;
import com.hiep.servlet.IUserDAO;
import com.hiep.servlet.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected IUserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "checkLogin":
                checkUser(request,response);
                break;
            case "edit":
                updateUser(request, response);
                break;
//                case "search":
//                    searchUser(request,response);
        }

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String university = request.getParameter("university");
        String acount = request.getParameter("acount");

        User book = new User(password,address,mail,birthday,sex,university,acount);
        try {
            userDAO.updateUser(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Edit.jsp");
        dispatcher.forward(request, response);
    }

    public void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acount = request.getParameter("account");
        String password = request.getParameter("password");

        User user =userDAO.loginUser(acount,password);



        RequestDispatcher dispatcher;

        if (user == null){
            request.setAttribute("message","Không có tài khoản này");
            dispatcher = request.getRequestDispatcher("user/SignIn.jsp");
        }else {
            request.setAttribute("acount",user.getAcount());
            dispatcher = request.getRequestDispatcher("user/Home.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acount = request.getParameter("acount");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String university = request.getParameter("university");

        User newUser = new User(acount,password,address,mail,birthday,sex,university);

        userDAO.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/SignUp.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "checkLogin":
                login(request,response);
                break;
            case "create":
                showNewForm(request, response);
                break;
            case "showListBKA":
                listUserBKA(request, response);
                break;
            case "showListKT":
                listUserKT(request, response);
                break;
            case "showListXD":
                listUserXD(request, response);
                break;
            case "edit":
                showEditUser(request,response);
                break;
            default:
                Home(request, response);
                break;
        }

    }

    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acount = request.getParameter("acount");
        User existingUser = userDAO.findUserByAcount(acount);
//        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void listUserBKA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String IdUniversity = request.getParameter("listUniversity");
        String IdUniversity = "BKA";
        List<User> listUser = userDAO.findUserByIdUniversity(IdUniversity);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }

    private void listUserKT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String IdUniversity = request.getParameter("listUniversity");
        String IdUniversity = "KT";
        List<User> listUser = userDAO.findUserByIdUniversity(IdUniversity);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }

    private void listUserXD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String IdUniversity = request.getParameter("listUniversity");
        String IdUniversity = "XD";
        List<User> listUser = userDAO.findUserByIdUniversity(IdUniversity);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/SignUp.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Home.jsp");
        dispatcher.forward(request, response);
    }

    private void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("Home",);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/SignIn.jsp");
        dispatcher.forward(request, response);
    }

}
