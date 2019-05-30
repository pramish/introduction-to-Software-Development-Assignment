/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oms.controller.usermanagement;

import MODEL.DAO.DatabaseManager;
import MODEL.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pramishluitel
 */
@WebServlet(name = "readUser", urlPatterns = {"/readUser"})
public class readUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/UserManagement/listUser.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        DatabaseManager manager = (DatabaseManager) session.getAttribute("manager");
        try {
            if (manager.findUser(name, phoneNumber) != null) {
                User user1 = manager.getUsers(name, phoneNumber);
                session.setAttribute("user1", user1);
                response.sendRedirect("listUser.jsp?success=User Found");
            } else {
                response.sendRedirect("/readUser?failure=User not found");
                request.getSession().removeAttribute("user1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(readUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
