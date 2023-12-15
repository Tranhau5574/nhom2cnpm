<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />

    <style>
        .container{
            display: inline-flex;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            /* background-color: red; */
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        #login {
            background-color: blue;
            border-color: black;
        }

        #register {
            background-color: green;
            border-color: black;
        }

        #logout {
            background-color: red;
            border-color: black;
        }
        .nav-item{
            display: inline-block;
        }
    </style>
</head>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/">
        <img src="/src/main/resources/static/image/HUST Cinema (2).png" alt="Logo" width="30" height="30" >
        HUSTCINEMA
        </a>
    </div>

    <span class="nav-item">
        <div class="nav-item">
            <a class="nav-link" href="/">Trang chủ</a>
        </div>
        <c:choose>
            <c:when test="${sessionScope.currentUser eq null}">

            </c:when>
            <c:otherwise>
                <div class="nav-item">
                    <a class="nav-link" href="/user/tickets/history">Lịch sử mua vé</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="#">Cá nhân</a>
                </div>
            </c:otherwise>
        </c:choose>
    </span>
    
    <div class="form-inline my-2 my-lg-0">
        <c:choose>
            <c:when test="${sessionScope.currentUser eq null}">
                <div class="nav-item">
                    <a href="/login" class="btn" id="login">Đăng nhập</a>
                </div>
                <div class="nav-item">
                    <a href="/register" class="btn" id="register">Đăng ký</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="nav-item">
                    <a style="color: gold">${sessionScope.currentUser.username}</a>
                </div>
                <div class="nav-item">
                    <a href="/logout" class="btn" id="logout">Đăng xuất</a>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
    
</nav>
<body>
    
</body>

</html>
