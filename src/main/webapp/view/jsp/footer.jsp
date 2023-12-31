<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Footer</title>
    <style>
      * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }

      .logo {
        width: 150px;
        height: 50px;

        border-radius: 15px 15px 15px 15px;
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
        color: white;
        background-color: rgb(32, 29, 29);
        box-shadow: 0 0 10px #ffffff;
      }

      #footer-column {
        flex: auto;
        margin-left: 10px;
        right: 60px;
      }

      h1 {
        margin-bottom: 10px;
      }

      p {
        margin-bottom: 10px;
      }

      .brand-info {
        margin-top: 5px;
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
        margin-bottom: 5px;
        margin-top: 10px;
        transform: translateX(50%); /* Duy trì độ chính xác trung tâm */
      }
      a {
        display: inline-block;
        background-size: cover;
        width: 50px; /* Đặt kích thước theo mong muốn */
        height: 50px; /* Đặt kích thước theo mong muốn */
        text-decoration: none; /* Loại bỏ đường gạch chân mặc định */
        overflow: hidden; /* Ẩn phần nằm ngoài kích thước đã đặt */
      }
      .imgfb {
        background-image: url("https://th.bing.com/th/id/OIP.55DCXbXlKDgEBoZhKxpzLAAAAA?rs=1&pid=ImgDetMain");
      }
      .imgzl {
        background-image: url("https://th.bing.com/th/id/OIP.msYm3MzM9_zN0UkpvVL0EgHaHa?rs=1&pid=ImgDetMain");
      }
      .imgig {
        background-image: url("https://th.bing.com/th/id/OIP.nYyosnlFiPTBa2OqhFoe_wHaHa?rs=1&pid=ImgDetMain");
      }
    </style>
  </head>
  <body>
    <footer>
      <span class="footer">
        <img class="logo" src="https://res.cloudinary.com/ddfhkjugr/image/upload/v1703333046/H1_mre9wf.png" alt="Logo HustCinema" />

        <div id="footer-column">
          <h1>Liên hệ hợp tác</h1>
          <p>Địa chỉ: abcxyz</p>
          <p>Điện thoại: 0326888jqk</p>
          <p>Email: hustcinema.contact@hustcorp.com</p>
        </div>

        <div id="footer-column">
          <h1>Chăm sóc khách hàng</h1>
          <p>Hotline: 1900 jqka</p>
          <p>Email: cskh@hustcorp.com</p>
          <p>
            Giờ làm việc: 20:00 - 4:00 (tất cả các ngày không bao gồm ngày lễ)
          </p>
        </div>

        <div id="footer-column">
          <h1>Kết nối với chúng tôi</h1>
          <div>
            <a class="imgfb" href="#"></a>
            <a class="imgzl" href="#"></a>
            <a class="imgig" href="#"></a>
          </div>
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
