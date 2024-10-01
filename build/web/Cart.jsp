<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Account"%>
<%@page import="model.Cart"%>
<%@page import="dal.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Account activeAccount = (Account) session.getAttribute("account");
if (activeAccount == null) {
    response.sendRedirect("Login.jsp");
    return; // Dừng việc thực thi tiếp mã JSP nếu chưa đăng nhập
}
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            /* Style for the table cells */
            table td {
                padding: 10px; /* Adjust padding as needed */
            }

            /* Style for the delete button */
            .delete-button {
                background-color: #dc3545; /* Red color */
                color: white;
                border: none;
                padding: 8px 16px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                border-radius: 4px;
                cursor: pointer;
            }

            .delete-button:hover {
                background-color: #c82333; /* Darker shade of red on hover */
            }
            /* Style for the checkout button */
            input[type="submit"] {
                background-color: #007bff; /* Blue color */
                color: #fff; /* White text color */
                border: none; /* No border */
                padding: 10px 20px; /* Padding */
                font-size: 16px; /* Font size */
                cursor: pointer; /* Cursor style */
                border-radius: 4px; /* Rounded corners */
                transition: background-color 0.3s; /* Smooth transition */
            }

            input[type="submit"]:hover {
                background-color: #0056b3; /* Darker shade of blue on hover */
            }
        </style>
    </head>
    <body>

        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">
                    <div class="pb-5">
                        <div class="container">
                            <a href="product" class="btn btn-secondary">Back</a>
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <!-- Table header -->
                                            <thead>
                                                <tr>
                                                    <th>No</th>
                                                    <th>Product</th>
                                                    <th>Price</th>
                                                    <th>Quantity</th>
                                                    <th>Total</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <!-- Table body -->
                                            <tbody>
                                                <!-- Iterate over items in the cart -->
                                            <c:set var="o" value="${sessionScope.cart1}" />
                                            <c:forEach items="${o.getItems()}" var="item" varStatus="status">
                                                <tr>
                                                    <td>${status.index + 1}</td>
                                                    <td>
                                                        <div>
                                                            <img src="${item.getProduct().getImage()}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0">
                                                                    <a href="#" class="text-dark d-inline-block">${item.getProduct().getName()}</a>
                                                                </h5>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>${item.getPrice()}</td>
                                                    <td>
                                                        <button class="btnSub"><a href="proces?number=-1&id=${item.getProduct().getId()}">-</a></button>
                                                        <input type="text" readonly value="${item.getQuanlity()}">
                                                        <button class="btnSub"><a href="proces?number=1&id=${item.getProduct().getId()}">+</a></button>
                                                    </td>
                                                    <td>${item.getQuanlity() * item.getPrice()}</td>
                                                    <td>
                                                        <form action="proces" method="post">
                                                            <input type="hidden" name="id" value="${item.getProduct().getId()}" />
                                                            <input type="submit" value="Delete" class="delete-button" />
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${o.getTotalPrice()}</strong></li>
                                    </ul>
                                    <hr/>
                                    <form action="checkout" method="post">
                                        <input type="submit" value="Thanh Toán" ${empty o.items ? 'disabled' : ''}>
                                        <h3 style="color: green">${mess}</h3>
                                    </form>

                                    <form action="checkorder" method="post">
                                        <input type="submit" value="Đơn hàng">
                                    </form>
                                </div>
                            </div>      
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
