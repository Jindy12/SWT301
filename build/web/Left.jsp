<%-- 
    Document   : Left
    Created on : Feb 24, 2024, 9:09:14 PM
    Author     : phamd
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><a class="fa fa-list" href="product"></a> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item text-white ${tag == o.categoryid ? "active" : ""}"><a href="category?categoryid=${o.categoryid}">${o.categoryname}</a></li>
                </c:forEach>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase">Sort By</div>
        <div class="card-body">
            <form action="product" method="get">
                <select name="sort" class="form-control" onchange="this.form.submit()">
                    <option value="">-- Sort By --</option>
                    <option value="asc">Price: Low to High</option>
                    <option value="desc">Price: High to Low</option>
                </select>
            </form>
        </div>
    </div>

    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Product NEW</div>
        <div class="card-body">
            <img class="img-fluid" src="${p.image}" ></a>
            <h5 class="card-title">${p.name}</h5>
            <p class="card-text">${p.title}</p>
            <p class="bloc_left_price">${p.price} $</p>
        </div>
    </div>
</div>
