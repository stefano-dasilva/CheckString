<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
<HEAD>
    <title>Login</title>
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
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero non, cupiditate eaque, labore provident excepturi, voluptatum quos obcaecati dolore minus fuga. Reprehenderit hic dolorum voluptates accusamus unde repudiandae, sed accusantium iure soluta ipsa maiores quia! Quod aliquid laboriosam hic animi fuga numquam quaerat corrupti repellat expedita, est perspiciatis sunt provident?
            </p>
            </div>
            <div id="first_footer">
                <span>GIOCA</span>
                <i class='bx bx-right-arrow-alt'></i>


            </div>
        </div>
        <div id="second_game">
            <h2>Indovina le bandiere</h2>
            <div class="p_wrapper">


            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero non, cupiditate eaque, labore provident excepturi, voluptatum quos obcaecati dolore minus fuga. Reprehenderit hic dolorum voluptates accusamus unde repudiandae, sed accusantium iure soluta ipsa maiores quia! Quod aliquid laboriosam hic animi fuga numquam quaerat corrupti repellat expedita, est perspiciatis sunt provident?
            </p>
            </div>
            <div id="second_footer">

                <span>GIOCA</span>
                <i class='bx bx-right-arrow-alt'></i>


            </div>
        </div>
        <div id="third_game">
            <h2>Indovina la popolazione</h2>
            <div class="p_wrapper">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero non, cupiditate eaque, labore provident excepturi, voluptatum quos obcaecati dolore minus fuga. Reprehenderit hic dolorum voluptates accusamus unde repudiandae, sed accusantium iure soluta ipsa maiores quia! Quod aliquid laboriosam hic animi fuga numquam quaerat corrupti repellat expedita, est perspiciatis sunt provident?
            </p>
            </div>
            <div id="third_footer">

                <span>GIOCA</span>
                <i class='bx bx-right-arrow-alt'></i>


            </div>
        </div>
    </div>

</div>





<script src=${pageContext.request.contextPath}/resources/js/gamesselection.js></script>

</BODY>
</HTML>