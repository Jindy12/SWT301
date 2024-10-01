/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author phamd
 */
public class AddProductServlet extends HttpServlet {

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
            out.println("<title>Servlet AddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
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
        // Lấy thông tin sản phẩm từ request parameters
        String pname = request.getParameter("name").trim();
        String pimage = request.getParameter("image").trim();
        String ptitle = request.getParameter("title").trim();
        String pdescription = request.getParameter("description").trim();
        String pquanlityStr = request.getParameter("quanlity").trim();
        String pcategoryStr = request.getParameter("categoryid").trim();
        String ppriceStr = request.getParameter("price").trim();

        // Kiểm tra các trường thông tin có chứa khoảng trắng không
        if (pname.isEmpty() || pimage.isEmpty() || ptitle.isEmpty() || pdescription.isEmpty() || pquanlityStr.isEmpty() || pcategoryStr.isEmpty() || ppriceStr.isEmpty()) {
            // Nếu có, hiển thị thông báo lỗi
            String errorMessage = "Text is have White Space , input again!";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("manager").forward(request, response);
            return;
        }

        // Kiểm tra nếu giá và số lượng không phải là số
        double pprice;
        int pquanlity;
        try {
            pprice = Double.parseDouble(ppriceStr);
            pquanlity = Integer.parseInt(pquanlityStr);
        } catch (NumberFormatException e) {
            // Nếu không phải số, hiển thị thông báo lỗi
            String errorMessage = "Price and Quantity must be numbers!";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("manager").forward(request, response);
            return;
        }

        // Chuyển đổi các trường số thành kiểu dữ liệu số
        int pcategory = Integer.parseInt(pcategoryStr);

        // Thực hiện thêm sản phẩm vào cơ sở dữ liệu
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        int accountid = a.getAccountid();
        ProductDAO productData = new ProductDAO();
        productData.AddProduct(pname, pimage, pprice, ptitle, pdescription, pquanlity, pcategory, accountid);

        // Chuyển hướng đến trang quản lý sản phẩm sau khi thêm thành công
        response.sendRedirect("manager");
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
