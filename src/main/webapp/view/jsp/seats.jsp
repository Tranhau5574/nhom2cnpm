<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chọn chỗ ngồi</title>
    <style>
        .error-message {
            color: red;
            text-align: center;
            padding: 20px;
        }

        .container{
            display: flex;
            justify-content: center;
        }
        .screen {
            width: 70%;
            margin-left: auto;
            margin-right: auto;
            display: block;
        }
        /* <!-- style ghế ngồi -->*/
        /* Ẩn checkbox */
        input[type="checkbox"] {
            display: none;
        }

        /* Thiết lập hình ảnh tùy chỉnh cho label */
        input[type="checkbox"] + label {
            display: inline-block;
            width: 70px; /* Điều chỉnh kích thước hình ảnh */
            height: 70px; /* Điều chỉnh kích thước hình ảnh */
            background-size: cover;
            cursor: pointer;
            margin: 10px;
        }
        input[type="checkbox"] + label {
            background-image: url('/image/seat-unselect-normal.png'); 
        }

        /* Hình ảnh tùy chỉnh cho checkbox được chọn */
        input[type="checkbox"]:checked + label {
            background-image: url('/image/seat-process-normal.png'); 
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
    <jsp:include page="header.jsp"/>
    <!-- nav bar -->

    <br><br><br>
    <!-- end of navbar -->

    <h1>Chọn chỗ ngồi</h1>
    <div class="error-message">${sessionScope.bookedError}</div>
    <div>
        <img class="screen" src="/image/ic-screen.png" alt="Man 12 hinh" width="70px">
    </div>

    <div class="container">
        <form action="/user/bill" method="post">
            <table style="width:100%">

            <!-- tạo stt cho hàng -->
                <tr>
                    <th></th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                    <th>6</th>
                    <th>7</th>
                    <th>8</th>                  
                </tr>
            
                <!-- tạo hàng A -->
                <tr>
                    <th>A</th>
                    <c:forEach items="${listA}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq true}">
                                <th>
                                    <input type="checkbox" id="checkboxA-${seat.id}-${seat.id}-unselect" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled >
                                    <label for="checkboxA-${seat.id}-${seat.id}-unselect"></label>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th>
                                    <input type="checkbox" id="checkboxA-${seat.id}-select" class="largerCheckbox" name="seats" value="${seat.id}" >
                                    <label for="checkboxA-${seat.id}-select"></label>
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

            <!-- tạo hàng B  -->
                <tr>
                    <th>B</th>
                    <c:forEach items="${listB}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq true}">
                                <th>
                                    <input type="checkbox" id="checkboxB-${seat.id}-unselect" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled >
                                    <label for="checkboxB-${seat.id}-unselect"></label>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th>
                                    <input type="checkbox" id="checkboxB-${seat.id}-select" class="largerCheckbox" name="seats" value="${seat.id}" >
                                    <label for="checkboxB-${seat.id}-select"></label>
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

                <!-- tạo hàng C  -->
                <tr>
                    <th>C</th>
                    <c:forEach items="${listC}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq true}">
                                <th>
                                    <input type="checkbox" id="checkboxC-${seat.id}-unselect" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled >
                                    <label for="checkboxC-${seat.id}-unselect"></label>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th>
                                    <input type="checkbox" id="checkboxC-${seat.id}-select" class="largerCheckbox" name="seats" value="${seat.id}" >
                                    <label for="checkboxC-${seat.id}-select"></label>
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

                <!-- tạo hàng D  -->
                <tr>
                    <th>D</th>
                    <c:forEach items="${listD}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq true}">
                                <th>
                                    <input type="checkbox" id="checkboxD-${seat.id}-unselect" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled >
                                    <label for="checkboxD-${seat.id}-unselect"></label>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th>
                                    <input type="checkbox" id="checkboxD-${seat.id}-select" class="largerCheckbox" name="seats" value="${seat.id}" >
                                    <label for="checkboxD-${seat.id}-select"></label>
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>

                <!-- tạo hàng E  -->
                <tr>
                    <th>E</th>
                    <c:forEach items="${listE}" var="seat">
                        <c:choose>
                            <c:when test="${seat.isOccupied eq true}">
                                <th>
                                    <input type="checkbox" id="checkboxE-${seat.id}-unselect" class="largerCheckbox" name="seats" value="${seat.id}" checked disabled >
                                    <label for="checkboxE-${seat.id}-unselect"></label>
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th>
                                    <input type="checkbox" id="checkboxE-${seat.id}-select" class="largerCheckbox" name="seats" value="${seat.id}" >
                                    <label for="checkboxE-${seat.id}-select"></label>
                                </th>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </table>

            <input type="submit" class="submit-btn" value="Tiếp tục">
        </form>
    </div>


    <!--footer-->
    <br><br>
    <jsp:include page="footer.jsp"/>

</body>
</html>