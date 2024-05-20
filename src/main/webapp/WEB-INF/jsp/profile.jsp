<%--
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



</head>

<body>




<div class="first">
    <div class="chicco mt-3 d-flex justify-content-between align-items-center">

            <h5 class="display-5">Benvenuto nel tuo profilo</h5>
            <div class="logout">
                <form action="logout" method="get">
                    <button type="submit" class="btn btn-outline-dark">Logout</button>
                </form>
            </div>
        </div>
    </div>





    <div class="sezioneFoto">
        <div class="container mt-5">
            <div class="card">
                <div class="card-body">
                    <h6 class="display-6">Foto Profilo</h6>
                </div>
            </div>
            <br>

            <div class="interno text-center">
                <img src="profilo.jpg" class="img-fluid rounded" alt="profilo">
                <div class="caricaFoto mt-3">
                    <button type="button" class="btn btn-outline-primary">Carica Foto</button>
                </div>
            </div>
        </div>
    </div>
    <br><br>

    <div class="info">
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <h6 class="display-6">Dati</h6>
                </div>
            </div>
            <div class="first3 mt-3">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="nome" class="form-label">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" value=${name} readonly>
                    </div>

                    <div class="col-md-6">
                        <label for="cognome" class="form-label">Cognome</label>
                        <input type="text" class="form-control" id="cognome" name="cognome" value="${cognome}" readonly>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" value=${username} readonly>
                    </div>

                    <div class="col-md-6">
                        <label for="nazionalità" class="form-label">Nazionalità</label>
                        <input type="text" class="form-control" id="nazionalità" name="nazionalità" value=${nazione} readonly >
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="nascita" class="form-label">Data Di Nascita</label>
                        <input type="text" class="form-control" id="nascita" name="nascita" value=${data_nascita} readonly>
                    </div>
                </div>
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
</body>
</html>
