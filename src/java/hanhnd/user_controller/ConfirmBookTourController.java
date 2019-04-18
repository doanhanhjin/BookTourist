package hanhnd.user_controller;

import hanhnd.tbl_Orders.Tbl_OrdersDAO;
import hanhnd.tbl_Orders.Tbl_OrdersDTO;
import hanhnd.tbl_Tours.Tbl_ToursDAO;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConfirmBookTourController", urlPatterns = {"/ConfirmBookTourController"})
public class ConfirmBookTourController extends HttpServlet {

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
        System.out.println("CONFIRM");
        try {
            HttpSession session = request.getSession();
            String adult = request.getParameter("txtAdult");
            String child = request.getParameter("txtChild");
            String id = (String) session.getAttribute("TOUR_ID");
            String total = request.getParameter("Total");
            String username = request.getParameter("username");
            try {
                int i = Integer.parseInt(id);
                int a = Integer.parseInt(adult);
                int c = Integer.parseInt(child);
                System.out.println("i-a-c" + i + "--" + a + "--" + c);
                if (a < 0 || c < 0) {
                    request.setAttribute("ERROR_NUMBER", "Participant Number must be greater 0.");
                } else {
                    Tbl_ToursDAO tourDAO = new Tbl_ToursDAO();
                    Tbl_OrdersDAO orderDAO = new Tbl_OrdersDAO();
                    System.out.println(java.time.LocalDate.now());
                    LocalDate checkoutDate = java.time.LocalDate.now();
                    String date = String.valueOf(checkoutDate);
                    System.out.println("Total: " + total);
                    tourDAO.updateParticipantNumber(i, a + c);
                    System.out.println("TourId: " + i);
                    Tbl_OrdersDTO dto = new Tbl_OrdersDTO(Float.valueOf(total) * (a + c), username, "available", date, i, a+c);
                    orderDAO.insertOrder(dto); 
                    request.setAttribute("SUCCESS", "Book Tour successful!!");
                    session.setAttribute("ORDER_DTO", dto);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("ERROR_NUMBER", "Participant Number must be digit.");
            }
        } catch (Exception e) {
            log("ERROR at ConfirmBookTourController: " + e.getMessage());
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
