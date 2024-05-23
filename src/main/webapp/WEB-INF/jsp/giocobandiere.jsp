<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/giocobandiere.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Syne:wght@400..800&display=swap" rel="stylesheet">


</HEAD>
<BODY>
<%@ include file="navbar.jsp" %>

<section id="second_game_wrap">
    <div id="second_game_card">
        <h3 id="title">Indovina il numero maggiore di bandiere!</h3>
        <button id="inizia">Inizia ora il gioco</button>
    </div>
    <div id ="second_game_info">
        <%@ include file="mappa.jsp" %>
    </div>


</section>





<script type="module" src=${pageContext.request.contextPath}/resources/js/giocobandiere.js></script>

</BODY>
</HTML>