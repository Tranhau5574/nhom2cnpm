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

    <title>Chọn giờ xem phim</title>
</head>

<body>
<!-- nav bar -->
<jsp:include page="header.jsp"/>
<!-- end of navbar -->

<br><br><br>
<div class="container">

    <form action="/user" method="post">
        <h2>Chọn giờ xem phim</h2>
        <br>
        <p>Chọn giờ xem phim (HH:mm)</p>
        <select id="listTimes" class="form-control form-control-lg" name="startTime">
            <c:forEach items="${listStartTimes}" var="startTime">
                <option value="${startTime}">
                        ${startTime}
                </option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" class="btn btn-outline-danger btn-block">
    </form>
</div>
<br><br><br><br><br><br><br>
<jsp:include page="footer.jsp"/>


</body>

</html>