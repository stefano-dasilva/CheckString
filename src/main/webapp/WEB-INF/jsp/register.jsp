<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>


<HTML>
<HEAD>
    <title>Registrazione</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</HEAD>
<BODY>


<div id="layerWrap">


    <form:form id="form" method="POST"
               action="register"  modelAttribute="userregister" >



        <h2>Registrati</h2>

        <div id="inputgroup">

            <div class="form-control">
                <form:label for="nome"  path="nome" >Inserisci il tuo nome</form:label>
                <div>
                    <i class='bx bxs-user'></i>
                    <form:input type="text" id="nome"  path="nome" placeholder="Nome" cssErrorClass="error_input" />
                </div>
                <small></small>
                <form:errors path="nome" cssClass="error_message" />

            </div>


            <div class="form-control">
                <form:label for="cognome"  path="cognome" >Inserisci il tuo cognome</form:label>
                <div>
                    <i class='bx bxs-user'></i>
                    <form:input type="text" id="cognome" name="cognome"   path="cognome" placeholder="Cognome" cssErrorClass="error_input" />
                </div>
                <small></small>
                <form:errors path="cognome" cssClass="error_message" />

            </div>

            <div class="form-control">
                <form:label for="username"  path="username" >Inserisci il tuo Username</form:label>
                <div>
                    <i class='bx bxs-user'></i>
                    <form:input type="text" id="username" name="username"   path="username" placeholder="Username" cssErrorClass="error_input" />
                </div>
                <small></small>
                <form:errors path="username" cssClass="error_message" />

            </div>


            <div class="form-control">
                <form:label for="nazione" path="nazione" >Inserisci la tua nazionalità</form:label>

                <div>
                    <i class='bx bx-world'></i>
                    <form:input type="text" id="nazione" name="nazione"   path="nazione" placeholder="Nazionalità" cssErrorClass="error_input" />
                </div>
                <small></small>
                <form:errors path="nazione" cssClass="error_message" />
            </div>


            <div>
                <form:label for="nascita" path="dataNascita" >Data di Nascita</form:label>
                <div>

                    <i class='bx bxs-calendar'></i>
                    <form:input type="text" placeholder="gg/mm/yyyy" onfocus="this.type='date'" name="nascita"   path="dataNascita"  cssErrorClass="error_input" />
                </div>
                <form:errors path="dataNascita" cssClass="error_message" />
            </div>


            <div class="form-control">
                <form:label for="pass" path="password" >Inserisci Password</form:label>
                <div>
                    <i class='bx bx-lock-alt'></i>
                    <form:input type="password" id="pass" name="password" placeHolder="Password"   path="password"  cssErrorClass="error_input" onchange="controllapassword()"/>
                </div>
                <small></small>
                <form:errors path="password" cssClass="error_message" />
            </div>

            <div class="form-control">
                <form:label for="pass2" path="password2" >Reinserisci Password</form:label>
                <div id="ripetipassword">
                    <i class='bx bx-lock-alt'></i>
                    <form:input type="password" id="pass2" name="password" placeHolder="Password" path="password2"   cssErrorClass="error_input" onchange="controllapassword()"/>
                </div>
                <small></small>

            </div>
        </div>


        <button type="submit">SUBMIT</button>
    </form:form>
</div>


<script src=${pageContext.request.contextPath}/resources/js/register.js></script>
</BODY>
</HTML>
//