<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">


</HEAD>
<BODY>

<div id="layerWrap">


    <form:form id="form" method="POST"
               action="login"  modelAttribute="userlogin" >

        <h2>Login</h2>

        <div id="inputgroup">

            <div id="sec01">
                <form:label for="username"  path="username" >Inserisci il tuo username</form:label>
                <div id="usernameWrap">
                    <i class='bx bxs-user'></i>
                    <form:input type="text" id="username"  path="username" placeholder="Username" cssErrorClass="error_input" onchange="checkUsername()" />
                </div>
                <span>${errorUsername}</span>
                <form:errors path="username" cssClass="error_message" />
            </div>


            <div id="sec02">
                <form:label for="password"  path="password" >Inserisci Password </form:label>
                <div>
                    <i class='bx bx-lock-alt'></i>
                    <form:input type="password" id="password"  path="password" placeholder="Password" cssErrorClass="error_input"  />
                </div>
                <span>${errorPass}</span>
                <form:errors path="password" cssClass="error_message" />
            </div>


        </div>

        <div id="form_footer">
            <button type="submit">LOGIN</button>

            <p >Non hai una password? <a href="/CheckString/form_register">Registrati !</a></p>
        </div>

    </form:form>
</div>


<script src=${pageContext.request.contextPath}/resources/js/login.js></script>
</BODY>
</HTML>