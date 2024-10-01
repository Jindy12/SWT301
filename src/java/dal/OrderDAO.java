/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Cart;
import model.Item;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author tuana
 */
public class OrderDAO extends DBContext {

    public void addOrder(Account a, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //add bảng Cart
            String sql = "INSERT INTO [dbo].[Cart]\n"
                    + "           ([accountid]\n"
                    + "           ,[date]\n"
                    + "           ,[totalmoney])\n"
                    + "     VALUES (?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getAccountid());
            st.setString(2, date);
            st.setDouble(3, cart.getTotalPrice());
            st.executeUpdate();
            //lấy id của cart vua add 
            String sql1 = "select top 1 cartid  from Cart order by cartid desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //add vào bảng cartline ?
            if (rs.next()) {
                int oid = rs.getInt("cartid");
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO [dbo].[Cartline]\n"
                            + "           ([cartid]\n"
                            + "           ,[productid]\n"
                            + "           ,[price]\n"
                            + "           ,[quanlity])\n"
                            + "     VALUES(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getId());
                    st2.setDouble(3, i.getPrice());
                    st2.setInt(4, i.getQuanlity());
                    st2.executeUpdate();
                }
            }
            //cập nhật lại số lượng sản phẩm 
            String sql3 = "UPDATE [dbo].[Product]\n"
                    + "   SET [quanlity] = quanlity - ?\n"
                    + " WHERE productid = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuanlity());
                st3.setInt(2, i.getProduct().getId());
                st3.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }

    public List<Order> getOrderByAccountID(int accountid) {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM Cart where accountid =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order c = new Order(rs.getInt("cartid"),
                        rs.getInt("accountid"),
                        rs.getString("date"),
                        rs.getDouble("totalmoney"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public OrderDetail getOrderDetailsByOrderID(int id){
        String sql = "SELECT * FROM CartDetail";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
