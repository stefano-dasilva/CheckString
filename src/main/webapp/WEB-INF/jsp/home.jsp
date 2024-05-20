<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Syne:wght@400..800&display=swap" rel="stylesheet">


</HEAD>
<BODY>
<nav>
    <div  id="wrapper">
        <div>
            <span>CLASSIFICA</span>
            <span>GIOCA</span>
        </div>
        <div>
            <span><a href="/CheckString/show_profile">PROFILO</a></span>
            <span><a href="/CheckString/logout">LOGOUT</a></span>
        </div>
    </div>
</nav>

<div id="home">
    <div id="container">
        <div id="gamecard">
            <h2>Benvenuto !</h2>
            <div id="gamedesc">

            <p>  Lorem ipsum, dolor sit amet consectetur adipisicing elit. Explicabo repudiandae nemo nostrum voluptate dignissimos eos blanditiis minus molestias ut vitae tempora saepe doloremque, alias numquam aut voluptatum reiciendis incidunt adipisci vel porro sapiente? Autem dolor tempore pariatur, eaque, illo provident perspiciatis officia blanditiis, sint voluptates a nesciunt laboriosam commodi animi.
            </p>
            </div>
            <div id="footer_section">
                <span>INIZIA A GIOCARE</span>
                <i class='bx bx-right-arrow-alt'></i>

            </div>

        </div>
        <div id="imageWrapper">
            <img src='${pageContext.request.contextPath}/resources/10671.jpg'>

        </div>
    </div>

</div>



<script src=${pageContext.request.contextPath}/resources/js/home.js></script>

</BODY>
</HTML>