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

    <title>Them phim moi</title>
</head>

<body>
<!-- nav bar -->

<!-- end of navbar -->

<br><br><br>
<div class="container">

    <form action="/admin/addMovie" method="post">
        <h2>Them phim moi</h2>
        <br>
        <p>Ten phim</p>
        <input type="text" class="btn-block" name="name">
        <br><br>
        <p>Do dai phim</p>
        <input type="number" class="btn-block" name="length">
        <br><br>
        <p>Dao dien</p>
        <input type="text" class="btn-block" name="director">
        <br><br>
        <p>Danh sach dien vien chinh</p>
        <input type="text" class="btn-block" name="actors">
        <br><br>
        <p>The loai</p>
        <input type="text" class="btn-block" name="categories">
        <br><br>
        <p>Link anh nho</p>
        <input type="text" class="btn-block" name="imgURL">
        <br><br>
        <p>Link poster</p>
        <input type="text" class="btn-block" name="posterURL">
        <br><br>
        <p>Link embed trailer</p>
        <input type="text" class="btn-block" name="trailerURL">
        <br><br>
        <p>Ngay ra mat</p>
        <input type="date" class="btn-block" name="release-date">
        <br><br>
        <p>Mo ta phim</p>
        <input type="text" class="btn-block" name="short-description">
        <br><br>

        <input type="submit" class="btn btn-outline-danger btn-block">
    </form>

</div>
<br><br><br><br><br><br><br>

<jsp:include page="footer.jsp"/>

</body>

</html>