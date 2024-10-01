<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Order List</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                padding: 20px;
            }
            h2 {
                color: #333;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                background-color: #fff;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            th, td {
                padding: 12px 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
                color: #333;
            }
            tr:hover {
                background-color: #f9f9f9;
            }
            .custom-btn {
                /* Tùy chỉnh các thuộc tính CSS tại đây */
                /* Ví dụ: */
                border-radius: 10px;
                padding: 8px 16px;
                font-size: 16px;
                font-weight: bold;
            }

        </style>
    </head>
    <body>
        <a href="product" class="btn btn-secondary custom-btn">Back</a>
        <h2>Order List</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Money</th>
                    <!-- Thêm các cột khác nếu cần -->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${orderList}" var="order">
                    <tr>
                <form action="action">
                    <td>
                            ${order.cartid}
                    </td>
                </form>
                <td>${order.date}</td>
                <td>${order.totalmoney}</td>
                <!-- Thêm các cột khác tương ứng với thông tin của đơn hàng -->
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
