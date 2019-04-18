/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.admin_controller;

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
@WebServlet(name = "TourManagerController", urlPatterns = {"/TourManagerController"})
public class TourManagerController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String VIEW_TOUR = "ViewTourController";
    private static final String INSERT_TOUR = "insert.jsp";
    private static final String DELETE_TOUR = "DeleteTourController";
    private static final String EDIT_TOUR = "EditTourController";
    private static final String UPDATE_TOUR = "UpdateTourController";
    private static final String INSERT = "InsertTourController";
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
            if(action.equals("View Tour")) {
                url = VIEW_TOUR;
            } else if(action.equals("Insert Tour")) {
                url = INSERT_TOUR;
            } else if(action.equals("Delete")) {
                url = DELETE_TOUR;
            }else if(action.equals("Edit")) {
                url = EDIT_TOUR;
            } else if(action.equals("Update")) {
                url = UPDATE_TOUR;
            } else if(action.equals("Insert")) {
                url = INSERT;
            }else {
                request.setAttribute("ERROR", "Action not support!");
            }
        } catch (Exception e) {
            log("ERROR at TourManagerController: " + e.getMessage());
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
