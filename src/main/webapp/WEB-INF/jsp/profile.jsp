<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: DASILVAS
  Date: 15/05/2024
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<head>
    <title>Profilo</title>

    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.1 -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">






</head>

<body>

<%@ include file="navbar.jsp" %>


<div id="ben">
    <h3 class="display-5">Benvenuto Nel Tuo Profilo</h3>
</div>


<div id="bho">
    <div class="up">
        <div id="photo">
            <input type="text" id="nomefoto" name="nome" value=${name} readonly>
        </div>



        <div id="imgCont">
            <div id="lol">
            <img id="img1" src="data:image/jpeg;base64,${immagine}" class="img-fluid rounded"  />
            </div>
            <div id="bin">
                <form action="rimuoviImg" method="get">
                <button style="font-size:24px" id="del"><i class="fa fa-trash-o" style="font-size:24px"></i></button>
                </form>
            </div>
        </div>


        <div id="bottone" class="caricaFoto mt-3">
            <form action="upload" method="post" enctype="multipart/form-data">
                <div id="lab">
                 <label  for="file" id="fotolabel">Carica</label>
                    <input  type="file" name="img" id="file">
                  <button id="salva" type="submit">Salva</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="info">
    <div id="containerInfo">
        <div id="title">
            <h3 class="display-5">I Tuoi Dati</h3>
        </div>

        <div id="box">

            <div class="first3 mt-3">

                <form:form action="salva" method="post" id="formDati" modelAttribute="salvaRegister">

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <form:label for="nome" path="nome"   class="form-label">Nome</form:label>
                            <form:input type="text" class="form-control" id="nome" path="nome" value="${name}" readonly="true" cssErrorClass="error_input"/>
                            <small></small>
                            <form:errors path="nome" cssClass="error_message" />
                        </div>


                        <div class="col-md-6">
                            <form:label for="cognome" path="cognome" class="form-label">Cognome</form:label>
                            <form:input type="text" class="form-control" id="cognome" path="cognome"  name="cognome" value="${cognome}" readonly="true" cssErrorClass="error_input"/>
                            <small></small>
                            <form:errors path="cognome" cssClass="error_message" />
                        </div>

                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <form:label for="username" path="username" class="form-label">Username</form:label>
                            <form:input type="text" class="form-control" id="username" path="username" name="username" value="${username}" readonly="true" cssErrorClass="error_input"/>
                            <small></small>
                            <form:errors path="username" cssClass="error_message" />
                        </div>

                        <div class="col-md-6">
                            <form:label for="nazione" class="form-label" path="nazione">Nazionalità</form:label>
                            <form:input type="text" class="form-control" id="nazione" path="nazione"  name="nazione" value="${nazione}" readonly="true" cssErrorClass="error_input"/>
                            <small></small>
                            <form:errors path="username" cssClass="error_message" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <form:label for="dataNascita" class="form-label" path="dataNascita"   >Data Di Nascita</form:label>
                            <form:input type="text" class="form-control" id="dataNascita" path="dataNascita"  name="dataNascita" value="${data_nascita}" readonly="true" cssErrorClass="error_input"/>
                            <small></small>
                            <form:errors path="username" cssClass="error_message" />
                        </div>
                    </div>
                    <button type="button" id="editButton" class="btn btn-warning">Modifica</button>

                    <button type="submit" id="saveButton" class="btn btn-success d-none">Salva</button>

                </form:form>
            </div>
        </div>
    </div>
</div>




<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"
></script>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"
></script>

<script src=${pageContext.request.contextPath}/resources/js/profile.js></script>
</body>
</html>
