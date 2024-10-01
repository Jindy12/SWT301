
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author phamd
 */
public class BuyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Empty processRequest - no implementation yet
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart1");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        String num_raw = request.getParameter("number");
        String id_raw = request.getParameter("id");
        int num;
        int pid; // Declared pid on a separate line

        try {
            num = Integer.parseInt(num_raw);
            pid = Integer.parseInt(id_raw);
            ProductDAO pdao = new ProductDAO();
            Product pro = pdao.getProductByID(pid);
            double price = pro.getPrice();
            Item item = new Item(pro, num, price);
            cart.addItemstToCart(item);
        } catch (NumberFormatException e) {
            // Handle error for invalid number format
            String errorMessage = "Invalid number format!";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }

        List<Item> listItems = cart.getItems(); // Renamed ListItems to listItems
        session.setAttribute("cart1", cart);
        session.setAttribute("sizecart", listItems.size());
        response.sendRedirect("product");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
