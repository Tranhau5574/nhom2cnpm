<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP Page with JavaScript</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript">
      // Your JavaScript code goes here
      function greet() {
        var name = prompt("Enter your name:");
        alert("Hello, " + name + "!");
      }
    </script>
    <header>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Navbar</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Dropdown
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider" /></li>
                  <li>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" aria-disabled="true">Disabled</a>
              </li>
            </ul>
            <form class="d-flex" role="search">
              <input
                class="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </div>
      </nav>
    </header>
    <style>
      button.search-btn,
      input {
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
      .search-bar input:valid {
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
        transform: translate(0.5em, 0.5em) scale(0.5);
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
        transform: translate(0.25em, 0.25em) rotate(45deg) scale(0.25, 0.125);
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
        transform: translate(0.2em, 0) rotate(45deg);
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
        body,
        input {
          color: #f1f1f1;
        }
        body {
          background: #171717;
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
          background: #f1f1f1;
        }
      }
    </style>
  </head>
  <body>
    <h1>Welcome to my JSP Page</h1>

    <p>This is a paragraph.</p>

    <!-- Call the JavaScript function -->
    <button onclick="greet()">Hello Button</button>

    <div class="search-box d-flex justify-content-between">
      <h2>Chọn Phim</h2>
      <form action="/" class="search-bar" method="post">
        <input type="search" name="movie-name" pattern=".*\S.*" required />
        <button class="search-btn" type="submit">
          <span>Tìm</span>
        </button>
      </form>
    </div>
    <div>${movie.name} vcl</div>
    <img src="${movie.imgURL}" alt="Movie Image" />
    <iframe
      width="560"
      height="315"
      src="${movie.trailerURL}"
      frameborder="0"
      allowfullscreen
    ></iframe>
  </body>
</html>
