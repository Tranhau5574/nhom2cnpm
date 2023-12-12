<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
     <title>Trang đăng nhập</title> 
     <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins',sans-serif;
        }
         
        body {
            background: rgb(60, 210, 230);
            overflow: hidden;
        }
        ::selection{
            background: rgba(60, 210, 230, 0.3);
        }
        .container{
            max-width: 440px;
            padding: 0 20px;
            margin: 170px auto;
        }
        .wrapper{
            width: 100%;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0px 4px 10px 1px rgba(0,0,0,0.1);
        }
        .wrapper .title{
            height: 90px;
            background: rgb(30, 160, 180);
            border-radius: 5px 5px 0 0;
            color: #fff;
            font-size: 30px;
            font-weight: 600;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrapper .message{
            color: #ff0000;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrapper form{
            padding: 30px 25px 25px 25px;
        }
        .wrapper form .row{
            height: 45px;
            margin-bottom: 15px;
            position: relative;
        }
        .wrapper form .row input{
            height: 100%;
            width: 100%;
            outline: none;
            padding-left: 60px;
            border-radius: 5px;
            border: 1px solid lightgrey;
            font-size: 16px;
            transition: all 0.3s ease;
        }
        form .row input:focus{
            border-color: rgb(30, 160, 180);
            box-shadow: inset 0px 0px 2px 2px rgba(30, 160, 180,0.25);
        }
        form .row input::placeholder{
            color: #999;
        }
        .wrapper form .row i{
            position: absolute;
            width: 47px;
            height: 100%;
            color: #fff;
            font-size: 18px;
            background: rgb(30, 160, 180);
            border: 1px solid #168ea0;
            border-radius: 5px 0 0 5px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrapper form .pass{
            margin: -8px 0 20px 0;
        }
        .wrapper form .pass a{
            color: rgb(37, 170, 194);
            font-size: 17px;
            text-decoration: none;
        }
        .wrapper form .pass a:hover{
            text-decoration: underline;
        }
        .wrapper form .button input{
            color: #fff;
            font-size: 20px;
            font-weight: 500;
            padding-left: 0px;
            background: rgb(30, 160, 180);
            border: 1px solid #167da0;
            cursor: pointer;
        }
        form .button input:hover{
            background: rgb(30, 160, 180);
        }
        .wrapper form .signup-link{
            text-align: center;
            margin-top: 20px;
            font-size: 17px;
        }
        .wrapper form .signup-link a{
            color: rgb(30, 160, 180);
            text-decoration: none;
        }
        form .signup-link a:hover{
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <form action="/login" method="post">
        Tên đăng nhập: <input type="text" name="username" required><br>
        Mật khẩu: <input type="password" name="password" required><br>
        <input type="submit" value="Đăng nhập">
    </form>
</body>
</html>