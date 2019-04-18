/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.user_controller;

import hanhnd.tbl_Accounts.Tbl_AccountsDTO;
import hanhnd.tbl_Orders.Tbl_OrdersDAO;
import hanhnd.tbl_Orders.Tbl_OrdersDTO;
import hanhnd.tbl_Tours.Tbl_ToursDAO;
import hanhnd.tbl_Tours.Tbl_ToursDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ViewMyToursController", urlPatterns = {"/ViewMyToursController"})
public class ViewMyToursController extends HttpServlet {

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
            List<Tbl_ToursDTO> list = null;
            HttpSession session = request.getSession();
            Tbl_AccountsDTO dto = (Tbl_AccountsDTO) session.getAttribute("USER");
            String username = dto.getUsername();
            Tbl_OrdersDAO orderDAO = new Tbl_OrdersDAO();
            List<Tbl_OrdersDTO> listOrder = orderDAO.getOrderByUsername(username);
            System.out.println("Có list rồi");
            if (listOrder != null) {
                request.setAttribute("MY_LIST_ORDERS", listOrder);
                //chạy 1 lần vòng for thì cho ra 1 tourDTO.
                System.out.println("chưa vô vòng for");
                list = new ArrayList<>();
                for (int i = 0; i < listOrder.size(); i++) {
                    Tbl_OrdersDTO orderDTO = listOrder.get(i);
                    int TourId = orderDAO.getTourId(orderDTO.getId());
                    Tbl_ToursDAO tourDAO = new Tbl_ToursDAO();
                    Tbl_ToursDTO tourDTO = tourDAO.searchByID(TourId);
                    list.add(tourDTO);
                    System.out.println("Chưa có Attribute");
                    session.setAttribute("MY_ORDERS", orderDTO);
                    System.out.println("Có Attribute rồi");
                }
                request.setAttribute("MY_TOURS", list);
                System.out.println("Có list rồi");

            } else {
                request.setAttribute("NO_ORDER", "Your order is empty. You can book new TOURs.");
            }
        } catch (Exception e) {
            log("ERROR at ViewMyToursController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("profile.jsp").forward(request, response);
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
