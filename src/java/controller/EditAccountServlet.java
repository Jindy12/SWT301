/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditAccountServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAccountServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    // Kiểm tra và lấy tham số "accountid"
    String idParam = request.getParameter("accountid");
    if (idParam == null || idParam.trim().isEmpty()) {
        request.setAttribute("error", "Account ID is required.");
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        return;
    }

    // Kiểm tra và lấy tham số "isAdmin"
    String isAdminParam = request.getParameter("isAdmin");
    if (isAdminParam == null || isAdminParam.trim().isEmpty()) {
        request.setAttribute("error", "Admin status is required.");
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        return;
    }

    // Kiểm tra và lấy tham số "isShop"
    String isShopParam = request.getParameter("isShop");
    if (isShopParam == null || isShopParam.trim().isEmpty()) {
        request.setAttribute("error", "Shop status is required.");
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
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
        request.setAttribute("error", "Invalid numeric value.");
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        return;
    }

    String name = request.getParameter("name").trim();
    if (name.isEmpty()) {
        request.setAttribute("error", "User Name cannot be empty.");
        request.setAttribute("detail", new Account(id, name, name, isAdmin, isShop));
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
        return;
    }

    ProductDAO productData = new ProductDAO();
    productData.EditAccount(id, isShop);
    response.sendRedirect("manageraccount");
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
