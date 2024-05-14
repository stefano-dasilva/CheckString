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


    <form id="form" action="submit" method="POST">

        <h2>Login</h2>

        <div id="inputgroup">

            <div id="sec01">
                <label for="username">Inserisci il tuo username</label>
                <div id="usernameWrap">
                    <i class='bx bxs-user'></i>
                    <input type="text" id="username" name="username" placeholder="Username" required onchange="checkUsername()">
                </div>
                <span></span>
            </div>


            <div id="sec02">
                <label for="password">Inserisci Password</label>
                <div>
                    <i class='bx bx-lock-alt'></i>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <span></span>
            </div>


        </div>

        <div id="form_footer">
        <button type="submit">LOGIN</button>
        <p >Non hai una password? <a href="/CheckString/form_register">Registrati !</a></p>
        </div>

    </form>
</div>


<script src=${pageContext.request.contextPath}/resources/js/login.js></script>
</BODY>
</HTML>