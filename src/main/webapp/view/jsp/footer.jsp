<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        .logo {
            width: 150px;
            height: 80px;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: whitesmoke;
            color: black;
        }

        .footer {
            display: flex;
            justify-content: space-between;
            text-align: left;
            padding: 10px;
            margin-top: 10px;
        }

        #footer-column {
            flex: auto;
            margin-left: 50px;
            right: 60px;
        }

        h1 {
            margin-bottom: 10px;
        }

        p {
            margin-bottom: 10px;
        }

        .brand-info {
            margin-top: 30px;
            text-align: center;
        }

        .divider {
            /* position: absolute;
            height: 1px;
            width: 100%;
            background-color: #fff;
            top: 170px;
            right: ; Đưa đường thẳng về giữa */ 
            position: absolute;
            height: 2px;
            width: 50%;
            background-color: black;
            top: 23%; /* Chuyển đường thẳng xuống giữa */
            transform: translateX(50%); /* Duy trì độ chính xác trung tâm */
        }
    </style>
</head>
<body>
    <footer>
        <span class="footer">
            <img class="logo" src="" alt="">

            <div  id="footer-column">
                <h1>Liên hệ hợp tác</h1>
                <p>Địa chỉ: abcxyz</p>
                <p>Điện thoại: 0326888jqk</p>
                <p>Email: hustcinema.contact@hustcorp.com</p>
            </div>

            <div id="footer-column">
                <h1>Chăm sóc khách hàng</h1>
                <p>Hotline: 1900 jqka</p>
                <p>Email: cskh@hustcorp.com</p>
                <p>Giờ làm việc: 20:00 - 4:00 (tất cả các ngày không bao gồm ngày lễ)</p>
            </div>

            <div id="footer-column">
                <h1>Kết nối với chúng tôi</h1>
                <img src="/nhom2cnpm/src/main/image/c-13.png" alt="">
                <img src="/nhom2cnpm/src/main/image/c-16.png" alt="">
                <img src="/nhom2cnpm/src/main/image/c-18.png" alt="">
            </div>

           
        </span>

        
        <div class="divider"></div>
        
        <div class="brand-info">
            <h1>HustCinema</h1>
            <p>&copy; 2023 Rạp chiếu phim HustCinema. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>