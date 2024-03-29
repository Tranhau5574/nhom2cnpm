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
<jsp:include page="header.jsp"/>
<!-- nav bar -->
<!-- end of navbar -->

<br><br><br>
<div class="container">
        <h2>Thanh toán hóa đơn</h2>
        <div  style="display:flex; justify-content: center;">
            <table >
                <tr>
                    <th>TÊN PHIM:</th>
                    <th>${sessionScope.chosenSchedule.movie.name}</th>
                </tr>
                <tr>
                    <th>GIỜ CHIẾU:</th>
                    <th>${sessionScope.chosenSchedule.startTime}</th>
                </tr>
                <tr>
                    <th>NGÀY CHIẾU:</th>
                    <th>${formattedDate}</th>
                </tr>
                <tr>
                    <th>TÊN PHÒNG:</th>
                    <th>${sessionScope.chosenSchedule.room.id}</th>
                </tr>
                <tr>
                    <th>SỐ VÉ</th>
                    <th>${numberOfSelectedSeats}</th>
                </tr>
                <tr>
                    <th>DANH SÁCH VÉ</th>
                    <th>
                        <c:forEach items="${listSeats}" var="seat">
                        <div> | ${seat} | </div>
                        </c:forEach>
                    </th>
                </tr>
                <tr>
                    <th>TIỀN VÉ ĐƠN:</th>
                    <th>${sessionScope.chosenSchedule.price}</th>
                </tr>
                <tr>
                    <th>TỔNG:</th>
                    <th>${totalAmount}</th>
                </tr>
            </table>
            <div style="margin-left:50px">
                <img src="${sessionScope.chosenSchedule.movie.imgURL}" alt="" width="350px" height="500px">
            </div>
        </div>

        <br>
        <a href="/user/bill" class="btn btn-outline-danger btn-block">Thanh Toán</a>
</div>
<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>

</html>