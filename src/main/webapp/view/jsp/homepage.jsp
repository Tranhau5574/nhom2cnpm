<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <title>Home page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <style>
      /* carousel */
      /* Make the image fully responsive */
      .carousel-inner img {
          width: 100%;
          height: 100%;
      }

      .img-movie {
          height: 400px;
      }

      .movie-item {
          margin-bottom: 50px;
      }

      button.search-btn, input {
          font: 1em Hind, sans-serif;
          line-height: 1.5em;
      }
      input {
          color: #171717;
      }
      .search-bar {
          display: flex;
      }

      .search-bar input,
      .search-btn,
      .search-btn:before,
      .search-btn:after {
          transition: all 0.25s ease-out;
      }
      .search-bar input,
      .search-btn {
          width: 3em;
          height: 3em;
      }
      .search-bar input:invalid:not(:focus),
      .search-btn {
          cursor: pointer;
      }
      .search-bar,
      .search-bar input:focus,
      .search-bar input:valid  {
          width: 100%;
      }
      .search-bar input:focus,
      .search-bar input:not(:focus) + .search-btn:focus {
          outline: transparent;
      }
      .search-bar {
          padding-bottom: 1.5em;
          justify-content: center;
          max-width: 30em;
      }
      .search-bar input {
          background: transparent;
          border-radius: 1.5em;
          box-shadow: 0 0 0 0.4em #171717 inset;
          padding: 0.75em;
          transform: translate(0.5em,0.5em) scale(0.5);
          transform-origin: 100% 0;
          -webkit-appearance: none;
          -moz-appearance: none;
          appearance: none;
      }
      .search-bar input::-webkit-search-decoration {
          -webkit-appearance: none;
      }
      .search-bar input:focus,
      .search-bar input:valid {
          background: #fff;
          border-radius: 0.375em 0 0 0.375em;
          box-shadow: 0 0 0 0.1em #d9d9d9 inset;
          transform: scale(1);
      }
      .search-btn {
          background: #171717;
          border-radius: 0 0.75em 0.75em 0 / 0 1.5em 1.5em 0;
          padding: 0.75em;
          position: relative;
          transform: translate(0.25em,0.25em) rotate(45deg) scale(0.25,0.125);
          transform-origin: 0 50%;
      }
      .search-btn:before,
      .search-btn:after {
          content: "";
          display: block;
          opacity: 0;
          position: absolute;
      }
      .search-btn:before {
          border-radius: 50%;
          box-shadow: 0 0 0 0.2em #f1f1f1 inset;
          top: 0.75em;
          left: 0.75em;
          width: 1.2em;
          height: 1.2em;
      }
      .search-btn:after {
          background: #f1f1f1;
          border-radius: 0 0.25em 0.25em 0;
          top: 51%;
          left: 51%;
          width: 0.75em;
          height: 0.25em;
          transform: translate(0.2em,0) rotate(45deg);
          transform-origin: 0 50%;
      }
      .search-btn span {
          display: inline-block;
          overflow: hidden;
          width: 1px;
          height: 1px;
      }

      /* Active state */
      .search-bar input:focus + .search-btn,
      .search-bar input:valid + .search-btn {
          background: #008cff;
          border-radius: 0 0.375em 0.375em 0;
          transform: scale(1);
      }
      .search-bar input:focus + .search-btn:before,
      .search-bar input:focus + .search-btn:after,
      .search-bar input:valid + .search-btn:before,
      .search-bar input:valid + .search-btn:after {
          opacity: 1;
      }
      .search-bar input:focus + .search-btn:hover,
      .search-bar input:valid + .search-btn:hover,
      .search-bar input:valid:not(:focus) + .search-btn:focus {
          background: #0c48db;
      }
      .search-bar input:focus + .search-btn:active,
      .search-bar input:valid + .search-btn:active {
          transform: translateY(1px);
      }

      @media screen and (prefers-color-scheme: dark) {
          body, input {
              color: #424141;
          }
          body {
              background: #2e2e2e;
          }
          .search-bar input {
              box-shadow: 0 0 0 0.4em #f1f1f1 inset;
          }
          .search-bar input:focus,
          .search-bar input:valid {
              background: #3d3d3d;
              box-shadow: 0 0 0 0.1em #3d3d3d inset;
          }
          .search-btn {
              background: #565555;
          }
      }
  </style>
  </head>
  <body>
    <jsp:include page="header.jsp"/>
    <br>
    <br>
    <!-- carousel -->
    <br>
    <br>
    <br>
    <h1>Phim Mới Chiếu</h1>
    <div id="demo" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
            <li data-target="#demo" data-slide-to="3"></li>
            <li data-target="#demo" data-slide-to="4"></li>
            <li data-target="#demo" data-slide-to="5"></li>


        </ul>

        <!-- The slideshow -->
        <div class="carousel-inner">
            <c:forEach items="${movies}" var="movie" varStatus="count">
                <c:choose>
                    <c:when test="${count.index eq 0}">
                        <div class="carousel-item active">
                            <img src="${movie.largeImageURL}" 
                                 alt="..." width="1000" height="400">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="carousel-item">
                            <img src="${movie.largeImageURL}"
                                 alt="..." width="1000" height="400">
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
        <!--  -->
    </div>
    <!-- end of carousel -->

    <!-- chọn phim  -->
    <br>
    <h1 style="text-align: center; font-size: 40px;">Chọn phim</h1>
    <br>
    <div class = 'search-box d-flex justify-content-between'>
        <h2>Tìm kiếm Phim</h2>
        <form action="/" class="search-bar" method="post">
            <input type="search" name="movie-name" pattern=".*\S.*" required>
            <button class="search-btn" type="submit">
                <span>Tìm</span>
            </button>
        </form>
    </div>
    <br>
    <!--  -->

    <!-- danh sách phim  -->
    <div class="d-flex justify-content-between flex-wrap">
        <c:forEach items="${movies}" var="movie">
            <div class="card movie-item" style="width:300px">
                <img class="card-img-top img-movie"
                     src="${movie.smallImageURl}"
                     alt="Card image" style="width:100%">
                <div class="card-body">
                    <h4 class="card-title">${movie.name}</h4>
                    <a href="/movie-details?movieId=${movie.id}" class="btn btn-outline-warning"
                       style="margin-right:70px">Chi tiết</a>

                        <!-- Nếu chưa đăng nhập mà đã click vào nút mua vé thì trả về trang có nút có class btn-buy-ticket-not-signed-in để
                        toggle cái form đăng nhập -->
                    <c:choose>
                        <c:when test="${sessionScope.jwtResponse eq null}">
                            <button class="btn btn-outline-danger btn-buy-ticket-not-signed-in">Mua vé</button>
                        </c:when>
                        <c:otherwise>
                            <a href="/branches?movieId=${movie.id}" class="btn btn-outline-danger">Mua vé</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </div>
    <!--  -->

    <br>
    <br>
    <jsp:include page="footer.jsp"/>
  </body> 
</html>
