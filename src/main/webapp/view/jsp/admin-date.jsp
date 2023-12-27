<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh Toán</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style type="text/css">
        th {
            padding: 0px 20px 5px 0px;
        }
    </style>
</head>

<body>
<!-- nav bar -->
<!-- end of navbar -->

<br><br><br>
<div class="container">
    <h2>Cac ngay chieu cua phim:<br> ${movie.name}</h2>
    
    <br>

    <div style="display: flex;">
        
        <c:forEach items="${dateList}" var="date">
            <table>    
                <tr>
                    <th>
                        <div style="margin-right: 100;">${date}</div>                           
                    </th>
                    <td>
                        <a href="/admin/schedule/deleteDate?movieId=${movie.id}&date=${date}" 
                        class="btn btn-outline-danger btn-block">Xoa tat ca lich trong ngay</a>
                    </td>
                    <td>
                        <a href="/admin/schedule/time?movieId=${movie.id}&date=${date}" 
                        class="btn btn-outline-danger btn-block">Xem lich chieu trong ngay</a>
                    </td>
                </tr>
            </table>
        </c:forEach>  
        
    </div>
</div>

<br><br>
<br>
<br>
<div class="container">

    <form action="/admin/schedule/addDate" method="post">
        <h2>Them ngay moi (yyyy-MM-dd):</h2>
        <div class="message">${error}</div>
        <br>
        <input type="hidden" name="movieId" value="${movie.id}">

        <input type="date" class="btn-block" name="date" required>
        
        <br>
        <input type="submit" class="btn btn-outline-danger btn-block">
    </form>

</div>

<br>
<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>

</html>