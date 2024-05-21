<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/gamesselection.css" />
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

<div id="hero_games">

    <div id="games_section">
        <div id="first_game"></div>
        <div id="second_game"></div>
        <div id="third_game"></div>
    </div>

</div>





<script src=${pageContext.request.contextPath}/resources/js/gamesselection.js></script>

</BODY>
</HTML>