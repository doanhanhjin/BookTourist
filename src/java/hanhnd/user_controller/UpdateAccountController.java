package hanhnd.user_controller;

import hanhnd.tbl_Accounts.Tbl_AccountsDAO;
import hanhnd.tbl_Accounts.Tbl_AccountsDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateAccountController", urlPatterns = {"/UpdateAccountController"})
public class UpdateAccountController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String PROFILE = "profile.jsp";

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
        System.out.println("zo chua");
        try {
            String action = request.getParameter("btnAction");
            System.out.println("sdfghjk");
            if (action.equals("Update")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String fullname = request.getParameter("txtFullname");
                String address = request.getParameter("txtAddress");
                String email = request.getParameter("txtEmail");
                String gender = request.getParameter("txtGender");
                String phone = request.getParameter("txtPhoneNumber");
                System.out.println("met ghe");
                Tbl_AccountsDTO dto = new Tbl_AccountsDTO(username, password, fullname, "user", address, email, phone, Boolean.valueOf(gender), true);
                System.out.println("bug oi");
                Tbl_AccountsDAO dao = new Tbl_AccountsDAO();
                if (dao.updateAccount(dto)) {
                    url = PROFILE;
                    System.out.println("TUI NE");
                    request.getSession().setAttribute("USER", dto);
                    request.setAttribute("SUCCESS_UPDATE_ACCOUNT", "Update Profile Successfull!!");
                } else {
                    url = PROFILE;
                    System.out.println("Jin NE");
                    request.setAttribute("FAIL_UPDATE_ACCOUNT", "Update Profile Failed!!");
                }
            } else {
                request.setAttribute("ERROR", "Action not support!");// chưa sử dụng
            }
        } catch (Exception e) {
            log("ERROR at AccountController: " + e.getMessage());
            System.out.println(""+ e.getMessage());
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
