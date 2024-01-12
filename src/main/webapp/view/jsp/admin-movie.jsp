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

<jsp:include page="admin-header.jsp"/>

<br><br><br>
<div class="container">
    <h1><b>Danh sách phim</b></h1>
    
    <br>

    <div style="display:flex; justify-content: center ;">
        <table>

            <c:forEach items="${movieList}" var="movie">
                <tr>
                    <th>${movie.name}</th>
                    <th><a href="/admin/schedule?movieId=${movie.id}" class="btn btn-outline-info btn-block"
                        style="display:flex; align-items: center;justify-content: center;text-align: center;">Thay đổi lịch chiếu</a></th>
                    <th><a href="/admin/deleteMovie?movieId=${movie.id}" class="btn btn-outline-danger btn-block"
                        style="display:flex; align-items: center;justify-content: center;text-align: center;">Xóa phim</a></th>
                </tr>
            </c:forEach>  
            
            <th >
                <br>
                <a href="/admin/addMovie" class="btn btn-outline-success btn-block"
                style="display:flex; align-items: center;justify-content: center;text-align: center;">Thêm phim</a>
            </th>
        </table>
        
    </div>
    <br><br>

</div>
<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>

</html>



