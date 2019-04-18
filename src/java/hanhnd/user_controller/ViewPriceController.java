/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.user_controller;

import hanhnd.tbl_Tours.Tbl_ToursDAO;
import hanhnd.tbl_Tours.Tbl_ToursDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "ViewPriceController", urlPatterns = {"/ViewPriceController"})
public class ViewPriceController extends HttpServlet {

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
            String adult = request.getParameter("txtAdult");
            String child = request.getParameter("txtChild");
            System.out.println("TXT");
            HttpSession session = request.getSession();
            String id = (String) session.getAttribute("TOUR_ID");
            Tbl_ToursDAO dao = new Tbl_ToursDAO();
            Tbl_ToursDTO dto = dao.searchByID(Integer.parseInt(id));
            if(child.equals('0')) {
                request.setAttribute("PARTICIPANT", "NO Child");
            } else {
            int a = Integer.parseInt(adult);
            int c = Integer.parseInt(child);
            float priceAdule = dto.getPrice()*a;
            float priceChild = dto.getPrice()*c*80/100;
                System.out.println("PRICE-------" + priceAdule);
                System.out.println("PRICE--C-----" + priceChild);
            request.setAttribute("ViewPriceController_PriceAdult", priceAdule);
            request.setAttribute("ViewPriceController_PriceChild", priceChild); 
            }
        } catch (Exception e) {
            log("ERROR at ViewPriceController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("bookTourInfo.jsp").forward(request, response);
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
