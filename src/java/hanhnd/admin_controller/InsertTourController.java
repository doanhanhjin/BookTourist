/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.admin_controller;

import hanhnd.tbl_Tours.Tbl_ToursDAO;
import hanhnd.tbl_Tours.Tbl_ToursDTO;
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
@WebServlet(name = "InsertTourController", urlPatterns = {"/InsertTourController"})
public class InsertTourController extends HttpServlet {

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
        try {
            String name = request.getParameter("txtName");
            String description = request.getParameter("txtDescription");
            String price = request.getParameter("txtPrice");
            String startDate = request.getParameter("txtStartDate");
            String endDate = request.getParameter("txtEndDate");
            String participant = request.getParameter("txtParticipantNumber");
            String maxParticipant = request.getParameter("txtMaxParticipantNumber");
            String categoryId = request.getParameter("txtCategoryId");
            String status = request.getParameter("txtStatus");
            String image = request.getParameter("txtImage");
            System.out.println("LAY XONG PARAM");
            try {
                float p = Float.parseFloat(price);
                int par = Integer.parseInt(participant);
                int maxPar = Integer.parseInt(maxParticipant);
                int cate = Integer.parseInt(categoryId);
                System.out.println("TRUOC HAM DAO");
                Tbl_ToursDTO dto = new Tbl_ToursDTO(name, p, description, startDate, endDate, cate, maxPar, cate, status, image);
                Tbl_ToursDAO dao = new Tbl_ToursDAO();
                dao.insertTour(dto);
                request.setAttribute("INSERT_TOUR_SUCCESS", "Insert TOUR success!!");
            } catch (NumberFormatException e) {
                request.setAttribute("ERROR_NUMBER", "Error input number!");
            }
        } catch (Exception e) {
                log("ERROR at InsertTourController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("insert.jsp").forward(request, response);
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
