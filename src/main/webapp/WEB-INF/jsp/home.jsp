<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Home</title>
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
<%@ include file="navbar.jsp" %>

<div id="home">
    <div id="container">
        <div id="gamecard">
            <h2>Benvenuto !</h2>
            <div id="gamedesc">

            <p>  Benvenuto in World Prix.<br> Qui potrai metterti alla prova testando le tue conoscenze riguardo ai paesi del mondo.<br>
                Un modo divertente per imparare le bandiere e le capitali dei paesi e scoprendo curiosità interessanti.<br>
                Lanciati in questa stimolante sfida e scopri il mondo. <br> Sfida i tuoi amici e scopri chi è il piu forte !!!</p>
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