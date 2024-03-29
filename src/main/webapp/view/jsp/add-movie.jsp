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
<jsp:include page="admin-header.jsp"/>
<!-- end of navbar -->

<br><br><br>
<div class="container">

    <form action="/admin/addMovie" method="post">
        <h1><b>Thêm phim mới</b></h1>
        <br>
        <p>Tên phim</p>
        <input type="text" class="btn-block" name="name" required>
        <br><br>
        <p>Độ dài phim (phút)</p>
        <input type="number" class="btn-block" name="length" required>
        <br><br>
        <p>Đạo diễn</p>
        <input type="text" class="btn-block" name="director" required>
        <br><br>
        <p>Danh sách diễn viên chính</p>
        <input type="text" class="btn-block" name="actors" required>
        <br><br>
        <p>Thể loại</p>
        <input type="text" class="btn-block" name="categories" required>
        <br><br>
        <p>Link anh nhỏ</p>
        <input type="text" class="btn-block" name="imgURL" required>
        <br><br>
        <p>Link poster</p>
        <input type="text" class="btn-block" name="posterURL" required>
        <br><br>
        <p>Link embed trailer</p>
        <input type="text" class="btn-block" name="trailerURL" required>
        <br><br>
        <p>Ngày ra mắt</p>
        <input type="date" class="btn-block" name="release-date" required>
        <br><br>
        <p>Mô tả phim</p>
        <input type="text" class="btn-block" name="short-description" required>
        <br><br>

        <input type="submit" class="btn btn-outline-danger btn-block">
    </form>

</div>
<br><br><br><br><br><br><br>

<jsp:include page="footer.jsp"/>

</body>

</html>