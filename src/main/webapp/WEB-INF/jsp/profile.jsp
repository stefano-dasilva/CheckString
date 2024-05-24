<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: DASILVAS
  Date: 15/05/2024
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                  <button type="submit">Salva</button>
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
                <form action="salva" method="post" id="formDati" modelAttribute="salvaRegister">
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="nome" class="form-label">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" value="${name}" readonly>
                        </div>
                        <div class="col-md-6">
                            <label for="cognome" class="form-label">Cognome</label>
                            <input type="text" class="form-control" id="cognome" name="cognome" value="${cognome}" readonly>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username" value="${username}" readonly>
                        </div>

                        <div class="col-md-6">
                            <label for="nazione" class="form-label">Nazionalità</label>
                            <input type="text" class="form-control" id="nazione" name="nazione" value="${nazione}" readonly>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="dataNascita" class="form-label">Data Di Nascita</label>
                            <input type="text" class="form-control" id="dataNascita" name="dataNascita" value="${data_nascita}" readonly>
                        </div>
                    </div>
                    <button type="button" id="editButton" class="btn btn-warning">Modifica</button>

                    <button type="submit" id="saveButton" class="btn btn-success d-none">Salva</button>

                </form>
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
