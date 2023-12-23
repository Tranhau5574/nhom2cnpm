 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HUSTCINEMA</title>
    <style>
        nav {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #333;
            color: #fff;
            padding: 5px; /* Giảm padding để giảm chiều cao của nav */
            display: flex;
            justify-content: space-between;
            align-items: center;
            z-index: 1000;
        }


        .logo-container {
            display: flex;
            align-items: center;
            
        }
        .logo-container .logo {
            border-radius: 15px 15px 15px 15px;
      

        }
        .las la-film {
            width: 40px;
            height: 40px;
            margin-right: 10px;
        }

        .site-name {
            font-size: 2.5em;
            font-weight: bold;
        }

        .menu {
            display: flex;
            width: 300px;
            justify-content: space-between;
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .menu li {
            margin-right: 15px;
            display: flex;
            align-items: center;
        }

        .menu a {
            width: 100px;
            display: flex;
            justify-content: center;
            text-decoration: none;
            color: #fff;
            font-weight: bold;
        }

        .buttons {
            display: flex;
            align-items: center;
        }

        .login-btn,
        .register-btn,
        .logout-btn {
            text-decoration: none;
            color: #fff;
            border: none;
            padding: 0; /* Adjust padding as needed */
            width: 150px; /* Set a fixed width or use flex-grow to distribute space evenly */
            margin-left: 15px;
            cursor: pointer;
            border-radius: 5px;
            display: block;
            text-align: center;
        }

        .login-btn{
            background-color: #2652d4;
        }
        .register-btn{
            background-color: #2cbcc9;
        }
        .logout-btn{
            background-color: rgb(202, 26, 26);
        }


        /* Add padding to the content to avoid it being hidden under the fixed navbar */
        .content {
            padding-top: 60px;
        }
    </style>
</head>
<body>
    <nav>
        <div class="logo-container">
            <img src="/image/H.png" alt="..." class="logo">
            <div class="site-name">HUSTCINEMA</div>
        </div>
        <div>
            <c:choose>
                <c:when test="${sessionScope.currentUser eq null}">
    
                </c:when>
                <c:otherwise>
                    <ul class="menu">
                        <li><a href="/" >Trang chủ</a></li>
                        <li><a href="/user/tickets/history">Lịch sử mua</a></li>
                        <li><a href="#" >Cá nhân</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
            
        </div>
        
        <div class="buttons">
            <c:choose>
                <c:when test="${sessionScope.currentUser eq null}">
                    <ul style="list-style: none; padding: 0; margin: 0;">
                        <li style="padding: 0 0 5px 0;"><a href="/login" class="login-btn" style="height:30px;">Đăng nhập</a></li>
                        <li><a href="/register" class="register-btn" style="height:30px;">Đăng ký</a></li>
                    </ul>
                </c:when>
            <c:otherwise>
                <ul style="list-style: none; padding: 0; margin: 0;">
                    <li><p style="color: gold;text-align: center;justify-content: center;">Hello ${sessionScope.currentUser.username}</p></li>
                    <br>
                    <li><a href="/logout" class="logout-btn" style="height:30px;">Đăng xuất</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
            
        </div>
    </nav>

    <div class="content">

    </div>
</body>
</html>

