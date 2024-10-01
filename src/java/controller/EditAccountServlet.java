
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author tuana
 */
@WebServlet(name = "EditAccountServlet", urlPatterns = {"/editaccount"})
public class EditAccountServlet extends HttpServlet {

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
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables for duplicated literals
        String errorAttr = "error";
        String editAccountPage = "EditAccount.jsp";

        // Kiểm tra và lấy tham số "accountid"
        String idParam = request.getParameter("accountid");
        if (idParam == null || idParam.trim().isEmpty()) {
            request.setAttribute(errorAttr, "Account ID is required.");
            request.getRequestDispatcher(editAccountPage).forward(request, response);
            return;
        }

        // Kiểm tra và lấy tham số "isAdmin"
        String isAdminParam = request.getParameter("isAdmin");
        if (isAdminParam == null || isAdminParam.trim().isEmpty()) {
            request.setAttribute(errorAttr, "Admin status is required.");
            request.getRequestDispatcher(editAccountPage).forward(request, response);
            return;
        }

        // Kiểm tra và lấy tham số "isShop"
        String isShopParam = request.getParameter("isShop");
        if (isShopParam == null || isShopParam.trim().isEmpty()) {
            request.setAttribute(errorAttr, "Shop status is required.");
            request.getRequestDispatcher(editAccountPage).forward(request, response);
            return;
        }

        int id;
        int isAdmin;
        int isShop;
        try {
            id = Integer.parseInt(idParam);
            isAdmin = Integer.parseInt(isAdminParam);
            isShop = Integer.parseInt(isShopParam);
        } catch (NumberFormatException e) {
            request.setAttribute(errorAttr, "Invalid numeric value.");
            request.getRequestDispatcher(editAccountPage).forward(request, response);
            return;
        }

        String name = request.getParameter("name").trim();
        if (name.isEmpty()) {
            request.setAttribute(errorAttr, "User Name cannot be empty.");
            request.setAttribute("detail", new Account(id, name, name, isAdmin, isShop));
            request.getRequestDispatcher(editAccountPage).forward(request, response);
            return;
        }

        ProductDAO productData = new ProductDAO();
        productData.EditAccount(id, isShop);
        response.sendRedirect("manageraccount");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
