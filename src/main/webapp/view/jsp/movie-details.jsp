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
            padding: 0px 20px 0px 0px;
        }
    </style>
</head>

<body>
    <jsp:include page="header.jsp"/>
<!-- nav bar -->

<!-- end of navbar -->

<br><br><br>
<div class="container">
    <h1>Chi Tiết Phim</h1>
    <br>
    <div style="display:flex">
        <div style="margin-right:50px">
            <img src="${movie.imgURL}" alt="anh phim" width="300px" height="400px">
            <a href="/user/chooseDate?movieId=${movie.id}" class="btn btn-danger btn-block" style="margin-top: 5px;">Mua Vé</a>
        </div>
        <table>     
            <tr>
                <th> TÊN PHIM: </th>
                <th>${movie.name}</th>
            </tr>
            <tr>
                <th> ĐẠO DIỄN: </th>
                <th>${movie.director}</th>
            </tr>
            <tr>
                <th> DIỄN VIÊN: </th>
                <th>${movie.actors}</th>
            </tr>
            <tr>
                <th> NGÀY KHỞI CHIẾU: </th>
                <th>${movie.releaseDate}</th>
            </tr>
            <tr>
                <th> THỂ LOẠI: </th>
                <th>${movie.categories}</th>
            </tr>
            <tr>
                <th> THỜI LƯỢNG: </th>
                <th>${movie.length} phút</th>
            </tr>
        </table>


    </div>
    <br>
    <br>
    <div style="display:flex;">
        <div style="margin-right: 50px">
            <h1>Trailer:</h1>
            <iframe width="560" height="315" src="${movie.trailerURL}"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; gyroscope; picture-in-picture"
                    allowfullscreen>
            </iframe>
        </div>
    </div>
    <br>

    <br>
    <br>
</div>
<br>
<br>    
<!--footer-->
<jsp:include page="footer.jsp"/>
</body>

</html>