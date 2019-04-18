/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanhnd.user_controller;

import hanhnd.tbl_Accounts.Tbl_AccountsDAO;
import hanhnd.tbl_Accounts.Tbl_AccountsDTO;
import hanhnd.tbl_Tours.Tbl_ToursDAO;
import hanhnd.tbl_Tours.Tbl_ToursDTO;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "BookTourController", urlPatterns = {"/BookTourController"})
public class BookTourController extends HttpServlet {

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
        String url = "login.jsp";
        try {
            String id = request.getParameter("tourId");
            String price = request.getParameter("tourPrice");
            Cookie[] cookies = request.getCookies();//lay cookie trong request

            HttpSession sessions = request.getSession();
            sessions.setAttribute("TOUR_ID", id);
            sessions.setAttribute("TOUR_PRICE", price);
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String username = cookie.getName();
                    String password = cookie.getValue();

                    Tbl_AccountsDAO dao = new Tbl_AccountsDAO();
                    Tbl_AccountsDTO dto = dao.checkLogin(username, password);

                    if (dto != null) {
                        Tbl_ToursDAO daoT = new Tbl_ToursDAO();
                        Tbl_ToursDTO dtoT = daoT.searchByID(Integer.parseInt(id));
                        if (dtoT != null) {
                            int list[] = new int [dtoT.getMaxParticipantNumber() - dtoT.getParticipantNumber()];
                            for (int i = 0; i< list.length; i++) {
                                list[i] = i + 1;
                            }
                            sessions.setAttribute("DTO_TOUR", dtoT);
                            sessions.setAttribute("LIST_NUMBER", list);
                            url = "bookTourInfo.jsp";
                            sessions.setAttribute("USER", dto);
                        }
                    }
                }
            }
            /*HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");

            if (cart == null) {
                cart = new CartObj();
            }

            String tourId = (String) session.getAttribute("TOUR_ID");
            int id = Integer.parseInt(tourId);

            Tbl_ToursDAO dao = new Tbl_ToursDAO();
            if (dao.updateParticipantNumber(id)) {
                cart.addItemToCart(id);
                session.setAttribute("CART", cart);
                request.setAttribute("SUCCESS", "Book Tour success!!");
            }*/
        } catch (Exception e) {
            log("ERROR at BookTourController: " + e.getMessage());
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
