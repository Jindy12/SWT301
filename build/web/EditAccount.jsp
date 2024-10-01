<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Account</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Account</b></h2>
                        </div>
                    </div>
                </div>
            </div>
            <div id="editAccountModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editaccount" method="post">
                            <div class="modal-header">						
                                <h3 class="modal-title">Edit Account</h3>
                                <h4 class="modal-title">Can edit only Is Shop!</h4>
                                <button type="button" class="close" data-dismiss="modal" onclick="window.location.href='manageraccount'">X</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label for="accountid">ID</label>
                                    <input value="${acc.accountid}" name="accountid" type="text" class="form-control" readonly readonly>
                                </div>
                                <div class="form-group">
                                    <label>User Name</label>
                                    <input value="${acc.name}" name="name" type="text" class="form-control" required readonly>
                                    <c:if test="${not empty error}">
                                        <div class="alert alert-danger">${error}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label>Is Admin</label>
                                    <input value="${acc.isAdmin}" name="isAdmin" type="text" class="form-control" required readonly>
                                    <c:if test="${not empty error}">
                                        <div class="alert alert-danger">${error}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label>Is Shop</label>
                                    <input value="${acc.isShop}" name="isShop" type="text" class="form-control" required>
                                    <c:if test="${not empty error}">
                                        <div class="alert alert-danger">${error}</div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Save Changes">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
