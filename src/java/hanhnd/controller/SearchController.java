/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.controller;

import hanhnd.tbl_Tours.Tbl_ToursDAO;
import hanhnd.tbl_Tours.Tbl_ToursDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String HOME = "tourList.jsp";
    private static final String CATEGORY = "CategoryController";

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
            if(action.equals("Search")) {
                String tourId = request.getParameter("txtSearch");
                if(tourId != null) {
                    int id = Integer.parseInt(tourId);
                    Tbl_ToursDAO dao = new Tbl_ToursDAO();
                    List<Tbl_ToursDTO> list = dao.searchByCategory(id);
                    if(list != null) {
                        request.setAttribute("LIST_TOURS", list);
                        request.setAttribute("lastSearch", id);
                    }
                }
                url = HOME;
            } else if(action.equals("SearchByPrice")){
                String txtMin = request.getParameter("txtMin");
                String txtMax = request.getParameter("txtMax");
                try {
                    float min = Float.parseFloat(txtMin);
                    float max = Float.parseFloat(txtMax);
                    Tbl_ToursDAO dao = new Tbl_ToursDAO();
                    List<Tbl_ToursDTO> list = dao.searchByPrice(min, max);
                    if(list != null) {
                        request.setAttribute("LIST_TOURS", list);
                        request.setAttribute("valueMin", min);
                        request.setAttribute("valueMax", max);
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("ERROR_PRICE_SEARCH","Price must be digit");
                }
                url = HOME;
            }else {
                String tourId = request.getParameter("tourId");
                if(tourId != null) {
                    int id = Integer.parseInt(tourId);
                    Tbl_ToursDAO dao = new Tbl_ToursDAO();
                    List<Tbl_ToursDTO> list = dao.searchByCategory(id);
                    if(list != null) {
                        request.setAttribute("LIST_TOURS", list);
                        request.setAttribute("lastSearch", id);
                    }
                }
                url = HOME;
            }          
        } catch (Exception e) {
            log("ERROR at SearchController: " + e.getMessage());
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
