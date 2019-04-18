/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.admin_controller;

import hanhnd.tbl_Accounts.Tbl_AccountsDAO;
import hanhnd.tbl_Accounts.Tbl_AccountsDTO;
import hanhnd.tbl_Categories.Tbl_CategoriesDAO;
import hanhnd.tbl_Categories.Tbl_CategoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminSearchController", urlPatterns = {"/AdminSearchController"})
public class AdminSearchController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ACCOUNT_MANAGER = "accountManager.jsp";
    private static final String TOUR_MANAGER = "tourManager.jsp";
    private static final String CATAGORY_MANAGER = "categoryManager.jsp";
    private static final String ORDER_MANAGER = "orderManager.jsp";

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
            
            if(action.equals("View Account")){
            Tbl_AccountsDAO accountDAO = new Tbl_AccountsDAO();
            List<Tbl_AccountsDTO> listAccount = accountDAO.getListAccount();
            request.setAttribute("LIST_ACCOUNT", listAccount);
            url = ACCOUNT_MANAGER;
            } else if(action.equals("View Category")) {
                Tbl_CategoriesDAO categoryDAO =  new Tbl_CategoriesDAO();
                List<Tbl_CategoryDTO> listCategory = categoryDAO.getListCategory();
                request.setAttribute("LIST_CATEGORY", listCategory);
                url = CATAGORY_MANAGER;
            } else if(action.equals("Search Tour")) {
                
            }
        } catch (Exception e) {
            log("ERROR at AdminSearchController: " + e.getMessage());
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
