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
import model.Category;

/**
 *
 * @author admin
 */
public class AddCategoryServlet extends HttpServlet {

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
            out.println("<title>Servlet AddcategoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddcategoryServlet at " + request.getContextPath() + "</h1>");
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
        String cname = request.getParameter("categoryname");
        String categoryidString = request.getParameter("categoryid");

        // Kiểm tra xem categoryid hoặc categoryname có trống hoặc chỉ chứa khoảng trắng không
        if (categoryidString == null || categoryidString.trim().isEmpty() || cname == null || cname.trim().isEmpty()) {
            // Nếu categoryid hoặc categoryname trống hoặc chỉ chứa khoảng trắng, gửi thông báo lỗi về trang JSP
            request.setAttribute("error", "Category ID or Name cannot be empty.");
            request.getRequestDispatcher("managercategory").forward(request, response);
            return; // Kết thúc xử lý servlet để không thực hiện các thao tác tiếp theo
        }

        // Kiểm tra xem categoryid có phải là số nguyên không
        int cid;
        try {
            cid = Integer.parseInt(categoryidString);
        } catch (NumberFormatException e) {
            // Nếu không phải là số nguyên, gửi thông báo lỗi về trang JSP
            request.setAttribute("error", "Category ID must be an integer.");
            request.getRequestDispatcher("managercategory").forward(request, response);
            return; // Kết thúc xử lý servlet để không thực hiện các thao tác tiếp theo
        }

        // Kiểm tra xem category có tồn tại không
        ProductDAO productData = new ProductDAO();
        Category categoryExists = productData.getCategoryByID(cid);

        if (categoryExists != null) {
            // Nếu category đã tồn tại, gửi thông báo lỗi về trang JSP
            request.setAttribute("error", "Category with this ID already exists.");
            request.getRequestDispatcher("managercategory").forward(request, response);
        } else {
//            HttpSession session = request.getSession();
//            Account a = (Account) session.getAttribute("account");
//            int accountid = a.getAccountid();

            // Nếu category không tồn tại, thêm mới category
            productData.AddCategory(cid, cname);
            response.sendRedirect("managercategory");
        }
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
