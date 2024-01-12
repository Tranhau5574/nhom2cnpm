<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xem lịch chiếu và phòng theo ngày</title>
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
    <br><br><br>
    <div class="container">
        <h2>Các lịch chiếu của phim: <br> ${movie.name}</h2>
        <h2>Trong ngày: <br> ${date}</h2>
        
        <br>
    
        <div style="display: flex;">
            <table>   
                <c:forEach items="${listSchedules}" var="schedule">       
                    <tr>
                        <th>
                            <div style="margin-right: 100;">Thời gian chiếu: ${schedule.startTime}</div>
                            <br>
                            <div style="margin-right: 100;">Số phòng       : ${schedule.room.id}</div>                            
                        </th>
                        <td>
                            <a href="/admin/schedule/time/delete?movieId=${movie.id}&date=${date}&scheduleId=${schedule.id}" 
                            class="btn btn-outline-danger btn-block">Xóa lịch</a>
                        </td>
                    </tr>
                    <br>
                    <tr><br><br></tr>
                    <br>
                    <br>
                </c:forEach>  
            </table>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="container">

        <form action="/admin/schedule/time" method="post">
            <h2>Thêm lịch:</h2>
            <div class="message" style="color: #ff0000;">${error}</div>
            <br>
            <input type="hidden" name="movieId" value="${movie.id}">
            <input type="hidden" name="date" value="${date}">

            <h3>Thêm giờ:</h3>
            <input type="time" class="btn-block" name="time" required>

            <h3>Thêm giá:</h3>
            <input type="number" class="btn-block" name="price" required>

            <h3>Chọn phòng:</h3>
            <select id="listRoom" class="form-control form-control-lg" name="roomId">
                <c:forEach items="${listRoom}" var="room">
                    <option value="${room.id}">
                            ${room.id}
                    </option>
                </c:forEach>
            </select>
            
            <br>
            <input type="submit" class="btn btn-outline-danger btn-block">
        </form>

    </div>
<jsp:include page="footer.jsp"/>
</body>

</html>