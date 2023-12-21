<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn vai trò</title>
    <style>
        .container{
            display: flex;
            justify-content: center;
        }
        /* <!-- style ghế ngồi -->*/
        /* Ẩn checkbox */
        input[type="checkbox"] {
            display: block;
            margin: auto;
            padding: 10px 100px;
            width: 70px; 
            height: 70px;
        }

        /* CSS để định dạng nút submit */
        .submit-btn {
            display: block;
            margin: auto;
            background-color: red;
            color: white;
            padding: 10px 100px; /* Điều chỉnh theo nhu cầu */
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Hover effect */
        .submit-btn:hover {
            background-color: darkred;
        }

    </style>
</head>
<body>
    <!-- nav bar -->

    <br><br><br>
    <!-- end of navbar -->

    <h1>Bạn có nhiều hơn 1 vai trò, vào đâu bạn ei ?</h1>

    <div class="container">
        <form action="/admin" method="post">
            <input type="radio" id="option1" name="roleSelected" value="option1">
            <label for="option1" style="font-size: 20;">Vào trang admin</label>
            <br><br>
            <input type="radio" id="option2" name="roleSelected" value="option2">
            <label for="option2" style="font-size: 20;">Vào trang user</label>
            
            <br><br><br><br>
            <input type="submit" class="submit-btn" value="Tiếp tục">
        </form>
    <!--footer-->
    <jsp:include page="footer.jsp"/>

</body>
</html>