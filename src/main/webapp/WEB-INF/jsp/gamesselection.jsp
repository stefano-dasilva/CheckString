<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Selezione Giochi</title>
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
<%@ include file="navbar.jsp" %>

<div id="hero_games">

    <div id="games_section">
        <div id="first_game">
            <h2>Indovina le capitali</h2>
            <div class="p_wrapper">
            <p>Conosci la capitale della Norvegia? E quella dell'Iran? <br>
                NO?????<br>
                Rimedia subito con questo gioco.
                Avrai l'occasione di rimediare alla tua ignoranza e imparare sempre nuove capitali.<br>
                Stupisci famigliari, la tua ragazza, i tuoi amici con questa gioco sorprendente.
            </p>
            </div>
            <a id="first_footer" href="show_giocoCapitali">
                <span>GIOCA</span>
                <i class='bx bx-right-arrow-alt'></i>
            </a>
        </div>
        <div id="second_game">
            <h2>Indovina le bandiere</h2>
            <div class="p_wrapper">


            <p> Pensi di conoscere tutte le bandiere del mondo? Mettiti alla prova! Ti mostreremo una bandiera e il tuo compito è indovinare a quale Stato appartiene. Divertiti e scopri quanto sei bravo a riconoscere le bandiere internazionali! Buona fortuna!
            </p>
            </div>
            <a id="second_footer" href="show_giocobandiere">
                <span>GIOCA</span>
                <i class='bx bx-right-arrow-alt'></i>
            </a>
        </div>
        <div id="third_game">
            <h2>Indovina la popolazione</h2>
            <div class="p_wrapper">
            <p>Quanti abitanti ha l'Italia? <br>
                Quanti ne ha il Pakistan?
                In questo gioco dovrai indovinare quale dei due paesi ha il maggior numero di abitanti.<br>
                Ogni volta ti verrà mostrato il meteo delle capitali dei due paesi.<br>
                Corri subito a provarlo.
            </p>

            </div>
            <a id="third_footer" href="show_giocopopolazione">
                <span>GIOCA</span>
                <i class='bx bx-right-arrow-alt'></i>
            </a>
        </div>
    </div>

</div>





<script src=${pageContext.request.contextPath}/resources/js/gamesselection.js></script>

</BODY>
</HTML>