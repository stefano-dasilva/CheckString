<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/classifica.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Syne:wght@400..800&display=swap" rel="stylesheet">

</head>
<body>

<%@ include file="navbar.jsp" %>

<div id="content_wrapper">
    <div id="filter_options_wrapper">
<form:form id="filter_options" modelAttribute="classificafilter" method="post" action="classifica">

<div id="row">
    <form:select id="select" path="nazione">
        <form:option value="">Tutte le nazioni</form:option>
        <c:forEach items="${nazioni}" var="nazione">
            <form:option value="${nazione}">${nazione}</form:option>
        </c:forEach>
    </form:select>
           <button id="cercabutton" type="submit">Cerca</button>
       </div>
        <div id="row_2">
            <div class="radio-buttons">
                <form:radiobutton id="option1" name="options"  value="Tutti" path="categoriaGioco" />
                <form:label id="tutti" for="option1"  path="categoriaGioco" >Tutti</form:label>

                <form:radiobutton id="option2" name="options"  value="giocoBandiere" path="categoriaGioco" />
                <form:label id="radio_bandiere" for="option2"  path="categoriaGioco" >Bandiere</form:label>

                <form:radiobutton id="option3" name="options"  value="giocoCapitali" path="categoriaGioco" />
                <form:label id="radio_capitali" for="option3"  path="categoriaGioco" >Capitali</form:label>

                <form:radiobutton id="option4" name="options"  value="giocoPopolazione" path="categoriaGioco" />
                <form:label id="radio_popolazioni" for="option4"  path="categoriaGioco" >Popolazione</form:label>

            </div>

          <div id="minmax_filtro">
              <div id="minmax_input">
              <form:input type="number" id="min" path="minimo" placeholder="Minimo..."/>
              <form:input type="number" id="max" path="massimo" placeholder="Massimo..."/>
              </div>
              <div id="minmax_errore">
              <form:errors path="minimo" cssClass="error_message" />
              <form:errors path="massimo" cssClass="error_message" />
              </div>
          </div>

        </div>

</form:form>
    </div>


    <div id="classifica">
        <div id="titolo_classifica">
            <span></span>
            <span>Posizione</span>
            <span>Nome</span>
            <span>Username</span>
            <span>Punteggio</span>
        </div>
        <div id="utenti_wrapper">

        <c:forEach items="${utenti}" var="utente" varStatus="loop">
            <div id="utente_wrapper" class=${gioco}>
                <span>foto</span>
                <span>${loop.index + 1}</span>
                <span>${utente.nome}  ${utente.cognome}</span>
                <span>${utente.username}</span>
                <span>${utente.punteggio}</span>


            </div>
        </c:forEach>
        </div>
    </div>



</div>

<script src=${pageContext.request.contextPath}/resources/js/classifica.js></script>

</body>
</html>
