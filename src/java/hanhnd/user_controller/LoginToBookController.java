/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.user_controller;

import hanhnd.tbl_Accounts.Tbl_AccountsDAO;
import hanhnd.tbl_Accounts.Tbl_AccountsDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginToBookController", urlPatterns = {"/LoginToBookController"})
public class LoginToBookController extends HttpServlet {

    private static final String ERROR = "loginToBook.jsp";
    private static final String BOOKTOUR_INFO = "bookTourInfo.jsp";
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
            System.out.println("LoginToBookController: " + request.getParameter("tourId"));
            HttpSession session = request.getSession();
            System.out.println("LoginToBookController: " + session.getAttribute("TOUR_ID"));
            
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            Tbl_AccountsDAO dao = new Tbl_AccountsDAO();
            Tbl_AccountsDTO dto = dao.checkLogin(username, password);
            if (dto != null) {
                Cookie cookie = new Cookie(username, password);
                cookie.setMaxAge(60 * 60 * 60);
                response.addCookie(cookie);
                session.setAttribute("USER", dto);
                url = BOOKTOUR_INFO;
            } else {
                request.setAttribute("ERROR", "Login Failed!");
            }
        }catch (Exception e) {
            log("ERROR at LoginToBookController: " + e.getMessage());
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
