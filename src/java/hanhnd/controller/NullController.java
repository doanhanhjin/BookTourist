package hanhnd.controller;

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

@WebServlet(name = "NullController", urlPatterns = {"/NullController"})
public class NullController extends HttpServlet {

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
            Cookie[] cookies = request.getCookies();//lay cookie trong request

            HttpSession sessions = request.getSession();
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String username = cookie.getName();
                    String password = cookie.getValue();

                    Tbl_AccountsDAO dao = new Tbl_AccountsDAO();
                    Tbl_AccountsDTO dto = dao.checkLogin(username, password);

                    if (dto != null) {
                        sessions.setAttribute("USER", dto);
                    }
                }
            }
        } catch (Exception e) {
            log("ERROR at NullController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("CategoryController").forward(request, response);
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
