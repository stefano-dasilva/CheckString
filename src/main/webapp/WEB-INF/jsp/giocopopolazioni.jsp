<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/giocopopolazioni.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Syne:wght@400..800&display=swap" rel="stylesheet">


</HEAD>
<BODY>
<%@ include file="navbar.jsp" %>

<section id="third_game_wrap">
    <div id="third_game_card">
        <div id="third_game_content">
        <h3 id="title">Indovina il paese più popolato !</h3>
        <button id="inizia">Inizia ora il gioco</button>
        </div>
    </div>
    <div id ="third_game_info">
        <div id="first_chart"></div>

    </div>


</section>




<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="module" src=${pageContext.request.contextPath}/resources/js/giocopopolazioni.js></script>


</body>
</html>
