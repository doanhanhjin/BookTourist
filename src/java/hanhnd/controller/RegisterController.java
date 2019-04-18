/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.controller;

import hanhnd.tbl_Accounts.Tbl_AccountsDAO;
import hanhnd.tbl_Accounts.Tbl_AccountsDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "register.jsp";
    private static final String LOGIN_PAGE = "login.jsp";

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
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirmPassword = request.getParameter("txtConfirmPassword");
            String fullname = request.getParameter("txtFullname");
            String address = request.getParameter("txtAddress");
            String email = request.getParameter("txtEmail");
            String gender = request.getParameter("rbtnGender");
            if (gender.equals("Male")) {
                gender = "True";
            }
            if (!confirmPassword.equals(password)) {
                url = "register.jsp";
                request.setAttribute("ERROR", "Confirm Password not the same Password!");
            } else {
                String phoneNumber = request.getParameter("txtPhoneNumber");
                if (!phoneNumber.matches("\\d{11}")) {
                    url = "register.jsp";
                    request.setAttribute("ERROR", "Phone number invalid. Ex: 1234567890");
                } else {
                    String role = "user";
                    boolean status = true;
                    try {
                        Tbl_AccountsDAO dao = new Tbl_AccountsDAO();
                        Tbl_AccountsDTO dto = new Tbl_AccountsDTO(username, password, fullname, role, address, email, phoneNumber, Boolean.valueOf(gender), status);
                        if (dao.insertAccount(dto)) {
                            url = LOGIN_PAGE;
                            request.setAttribute("SUCCESS", "Register success!! Login to continues.");
                        } else {
                            url = "register.jsp";
                            request.setAttribute("ERROR", "Register failed!");
                        }
                    } catch (SQLException e) {
                        if (e.getMessage().contains("duplicate")) {
                            url = "register.jsp";
                            request.setAttribute("ERROR", "Register failed! Duplicate Username.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR at RegisterController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
