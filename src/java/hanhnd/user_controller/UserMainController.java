/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.user_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "UserMainController", urlPatterns = {"/UserMainController"})
public class UserMainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String BOOKTOUR = "BookTourController";
    private static final String CONFIRM_BOOKTOUR = "ConfirmBookTourController";
    private static final String LOGIN_TOBOOK = "LoginToBookController";
    private static final String VIEW_PRICE = "ViewPriceController";
    private static final String VIEW_MY_TOURS = "ViewMyToursController";
    private static final String CANCEL_TOUR = "CancelTourController";
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
            String action = request.getParameter("action");
            if (action.equals("Book Tour")) {
                url = BOOKTOUR;
            } else if (action.equals("Login")) {
                url = LOGIN_TOBOOK;
            } else if (action.equals("Book")) {
                url = CONFIRM_BOOKTOUR;
            } else if(action.equals("View Price")) {
                url = VIEW_PRICE;
            } else if(action.equals("View My Tours")) {
                url = VIEW_MY_TOURS;
            } else if(action.equals("Cancel")){
                url = CANCEL_TOUR;
            }else {
                request.setAttribute("ERROR", "Action not support!");
            }
        } catch (Exception e) {
            log("ERROR at UserMainController: " + e.getMessage());
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
