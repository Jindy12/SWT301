<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <link href="css/detail.css" rel="stylesheet" type="text/css"/>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="product">Shoes Shop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:choose>
                            <c:when test="${sessionScope.account != null}">
                                <c:if test="${sessionScope.account.isAdmin == 1}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="manageraccount">Manage Account</a>&nbsp;&nbsp;
                                    </li>
                                </c:if>
                                <c:if test="${sessionScope.account.isShop == 1}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="managercategory">Manage Category</a>&nbsp;&nbsp;
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="manager">Manage Product</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </li>
                                </c:if>
                                <li class="nav-item">
                                    <a class="nav-link" href="Profile.jsp?accountid=${sessionScope.account.accountid}">Hello ${sessionScope.account.name}</a>&nbsp;&nbsp;
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="logout">Logout</a>&nbsp;&nbsp;
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="nav-item">
                                    <a class="nav-link" href="Login.jsp">Login</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                    <form action="search" method="get" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                        <i class="fa fa-shopping-cart">Cart</i> 
                        <span class="badge badge-light">(${sessionScope.sizecart})</span>
                    </a>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <div class="slider">
                    <div class="list">
                        <div class="item">
                            <img src="https://img.lovepik.com/photo/48014/5770.jpg_wh860.jpg" alt="alt"/>
                        </div>
                        <div class="item">
                            <img src="https://cdn.authentic-shoes.com/wp-content/uploads/2023/05/76120343983dea4f5fc7c1e859446bc4_91fb9feeceb9414191e487aaaf8ade5e_2048x2048.jpeg" alt="">
                        </div>
                        <div class="item">
                            <img src="https://mediaelly.sgp1.digitaloceanspaces.com/uploads/2021/04/16154048/tong-quan-thuong-hieu-giay-nike.11.jpg" alt="">
                        </div>
                        <div class="item">
                            <img src="https://drake.vn/image/catalog/H%C3%ACnh%20content/th%C6%B0%C6%A1ng-hi%C3%AA%CC%A3u-gia%CC%80y-Converse/thuong-hieu-giay-converse-2.jpg" alt="">
                        </div>
                        <div class="item">
                            <img src="https://thuvienmuasam.com/uploads/default/original/2X/2/2331fe530cf0e89b62f344d245f499169b6ea9eb.jpeg" alt="">
                        </div>
                        <div class="item">
                            <img src="https://cafefcdn.com/203337114487263232/2023/10/3/ava-copy-2-1696297041650-1696297042635156048729.png" alt="">
                        </div>
                    </div>
                    <div class="buttons">
                        <button id="prev"><</button>
                        <button id="next">></button>
                    </div>
                    <ul class="dots">
                        <li class="active"></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
                <script src="js/app.js"></script>
            </div>
        </section>
    </body>
</html>
