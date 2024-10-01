/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author phamd
 */
public class ProductDAO extends DBContext {

    //lấy tất cả các sản phẩm từ data
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //lấy các loại product từ cid 
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //lấy sản phẩm mới nhất thêm vào
    public Product getLast() {
        String sql = "select top 1* from product order by productid desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Product> top1Products = new ArrayList<>();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //lấy các sản phẩm bởi cid từ bảng product  
    public List<Product> getAllProductByCategory(int categoryid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where categoryid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //lấy tất cả thông tin sản phẩm bởi id
    public Product getProductByID(int id) {
        String sql = "select * from product where productid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //Tìm kiếm sản phâmr bởi tên
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where [name] like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //
    public List<Product> searchByCategoryID(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where categoryid like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //đăng kí
    public Account Login(String name, String pass) {
        String sql = "SELECT * FROM Account WHERE [name] = ? AND pass =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //check xem account có tồn tại không  
    public Account CheckAccountExits(String name) {
        String sql = "SELECT * FROM Account WHERE [name] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                //String username = rs.getString(2);
                String password = rs.getString(2);
                int isAdmin = rs.getInt(3);
                int isShop = rs.getInt(4);
                return new Account(id, name, password, isAdmin, isShop);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //hàm cho người dùng đăng kí
    public void singup(String name, String pass) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([name]\n"
                + "           ,[pass]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isShop])\n"
                + "     VALUES (?,?,0,0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //lấy sản phẩm bởi accountid người bán 
    public List<Product> getAllProductByAccountID(int accountid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where accountid = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //xóa sản phẩm
    public void DeleteProduct(int productid) {
        String sql = "DELETE FROM Product WHERE productid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //thêm sản phẩm 
    public void AddProduct(String name, String image, double price, String title, String description, int quanlity, int categoryid, int accountid) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([name]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[title]\n"
                + "           ,[description]\n"
                + "           ,[quanlity]\n"
                + "           ,[categoryid]\n"
                + "           ,[accountid])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setDouble(3, price);
            st.setString(4, title);
            st.setString(5, description);
            st.setInt(6, quanlity);
            st.setInt(7, categoryid);
            st.setInt(8, accountid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //chỉnh sửa sản phẩm 
    public void EditProduct(String name, String image, double price, String title, String description, int quanlity, int categoryid, int productid) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[quanlity] = ?\n"
                + "      ,[categoryid] = ?\n"
                + " WHERE productid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setDouble(3, price);
            st.setString(4, title);
            st.setString(5, description);
            st.setInt(6, quanlity);
            st.setInt(7, categoryid);
            st.setInt(8, productid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //
    public Account getAccount(String name, String pass) {
        String sql = "select * from Account where name= ? and pass = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Account getAccountbyID(int accountID) {
        String sql = "select * from Account where accountid= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //getListByPage 
    public List<Product> getListByPage(List<Product> products, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(products.get(i));
        }
        return arr;
    }

    //lấy Category by id
    public Category getCategoryByID(int categoryid) {
        String sql = "select * from Category where categoryid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void EditAccount(int id, int isShop) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [isShop] = ?\n"
                + " WHERE Accountid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, isShop); // Đặt giá trị cho tham số đầu tiên (isShop)
            st.setInt(2, id);     // Đặt giá trị cho tham số thứ hai (Accountid)
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //edit category
    public void EditCategory(int id, String name) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [categoryname] = ?\n"
                + " WHERE categoryid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // thêm category
    public void AddCategory(int id, String name) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([categoryid]\n"
                + "           ,[categoryname])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //check category exits
    public Category checkCategoryExist(int id) {
        String sql = "SELECT * FROM Category WHERE categoryid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int cid = rs.getInt(1);
                String cname = rs.getString(2);
                return new Category(cid, cname);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
//delete category

    public void DeleteCategory(int categoryid) {
        String sql = "DELETE FROM Category WHERE categoryid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getTotalProduct() {
        String sql = "select count(*) from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        int n = dao.getTotalProduct();
        System.out.println(n);
    }

}
