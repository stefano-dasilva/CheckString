<%@page contentType="text/html; charset=UTF-8" %>

<html lang="en">

    <head>
    <title>IndovinaCapitale</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/capitali.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Syne:wght@400..800&display=swap" rel="stylesheet">


    </head>

    <body>
    <%@ include file="navbar.jsp" %>


    <div id="container">

        <div id="parte1">
        <div id="titolo">
        <h1>Quante Capitali Conosci?</h1>
        </div>
           <div id="mappa">
            <%@ include file="mappa.jsp" %>
           </div>
            <div id="bottone">
            <button id="iniziaBottone">Inizia a giocare</button>
            </div>
        </div>

        <div id="parte2">
        <div id="subTitle">
            <h2 id="ban">Indovina la capitale di <span id="paese"></span></h2>
        </div>



        <div id="gioco">
            <div id="ig">
                <span>Punti: <span id="punti"></span> </span>

                <img  alt="bandiera" id="img" >
            </div>


<div id="container2">


<div id="contMess">
    <div id="rispostaCorretta">
        <span>Risposta Corretta !!!</span>
    </div>
</div>
    <div id="contMess1">
        <div id="rispostaSbagliata">
            <span id="sbal1">La Risposta Corretta è <span id="right"></span> </span>

        </div>
    </div>


            <div id="opzioni">
                <div id="col1">
                    <span id="first"></span>
                <span id="second"></span>
                </div>
                <div id="col2">
                <span id="third"></span>
               <span id="fourth"></span>
                </div>
            </div>
</div>


        </div>

</div>
        <div id="cont4">

            <div id="mostraPunteggio">
                <div id="record"><span id="record1">Nuovo Record<span id="recordSpan"></span></span></div>
                <span>Il Tuo Punteggio è <span id="punteggioFinale"></span></span>
            </div>
            <div id="ricomincia">
                <a id="link" href="http://localhost:8083/CheckString/show_giocoCapitali"><button>Ricomincia</button></a>
            </div>
        </div>
        </div>


        <script type="module" src=${pageContext.request.contextPath}/resources/js/capitali.js></script>
    </body>

</html>