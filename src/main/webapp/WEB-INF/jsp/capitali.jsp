<%@page contentType="text/html; charset=UTF-8" %>

<html lang="en">

    <head>
    <title>IndovinaCapitale</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/capitali.css" />


    </head>

    <body>
    <%@ include file="navbar.jsp" %>


        <div id="container">


        <div id="parte1">
        <div id="titolo">
        <h2>Quante Capitali Conosci?</h2>
        </div>

            <%@ include file="mappa.jsp" %>
            <div id="bottone">
            <button id="iniziaBottone">Inizia il gioco</button>
            </div>
        </div>



        <div id="parte2">
        <div id="subTitle">

            <h2 id="ban">Indovina la capitale di <span id="paese"></span></h2>

        </div>



        <div id="gioco">
            <div id="ig">
            <img  alt="bandiera" id="img" >
            </div>


<div id="container2">

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


</div>
        <script type="module" src=${pageContext.request.contextPath}/resources/js/capitali.js></script>
    </body>

</html>