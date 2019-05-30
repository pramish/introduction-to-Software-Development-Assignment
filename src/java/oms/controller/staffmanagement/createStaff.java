/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oms.controller.staffmanagement;

import MODEL.DAO.DatabaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
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
@WebServlet(name = "createStaff", urlPatterns = {"/createStaff"})
public class createStaff extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createStaff</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createStaff at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/StaffAccessManagement/createStaff.jsp");

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DatabaseManager manager = (DatabaseManager) session.getAttribute("manager");
        String name = (String) request.getParameter("name");
        String email = (String) request.getParameter("email");
        String address = (String) request.getParameter("address");
        String position = (String) request.getParameter("position");
        int key = (new Random()).nextInt(999999);
        String staffID = "" + key;
        try {
            if (manager.checkStaffEmail(email)) {
                response.sendRedirect("staffMenu.jsp?failure1=Staff is already registered.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(createStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!(manager.checkStaffEmail(email))) {
                try {
                    manager.addStaff(staffID, email, name, position, address);
                } catch (SQLException ex) {
                    Logger.getLogger(createStaff.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("staffMenu.jsp?success1=Staff Added.");

            }
        } catch (SQLException ex) {
            Logger.getLogger(createStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
