<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>IndovinaPopolazione</title>
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
            <h4 id="game_description">Scegli se il paese sulla destra ha più o meno persone rispetto quello a sinistra</h4>
        <button id="inizia">Inizia ora il gioco</button>
        </div>
    </div>
    <div id ="third_game_info">
        <div id="currencies_info">
            <span id="info_box"></span>
            <div id="valute_box">
                <div id="first_row">
                    <span id="first_paese"></span>
                    <span id="first_currency"></span>
                </div>
                <div id="second_row">
                    <span id="second_paese"></span>
                    <span id="second_currency"></span>
                </div>
            </div>
        </div>
        <div id="first_chart"></div>

    </div>


</section>




<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="module" src=${pageContext.request.contextPath}/resources/js/giocopopolazioni.js></script>


</body>
</html>
