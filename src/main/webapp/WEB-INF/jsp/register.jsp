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
           

            <form id="form" action="submit" method="POST">
               
                <h2>Registrati</h2>

                <div id="inputgroup">

                <div>
                <label for="nome">Inserisci il tuo nome</label>
                <div>
                <i class='bx bxs-user'></i>
                <input type="text" id="nome" name="nome" placeholder="Nome" required>
                </div>
                </div>


                <div>
                <label for="cognome">Inserisci il tuo cognome</label>
                    <div>
                <i class='bx bxs-user'></i>
                <input type="text" id="cognome" name="cognome" placeholder="Cognome">
                    </div>
                </div>
               

                <div >
                <label for="nazione">Inserisci la tua nazionalità</label>
                    <div>
                <i class='bx bx-world'></i>
                <input type="text" id="nazione" name="nazione" placeholder="Nazionalità" required>
                    </div>
                </div>
                

                <div>
                <label for="nascita">Data di Nascita</label>
                    <div>

                        <i class='bx bxs-calendar'></i>

                <input type="date" id="nascita" name="nascita" required>
                    </div>
                </div>
              

               <div>
                <label for="pass">Inserisci Password</label>
                   <div>
                <i class='bx bx-lock-alt'></i>
                <input type="password" id="pass" name="password" placeholder="Password" required onchange="controllapassword()">
                   </div>
                </div>

                <div >
                <label for="pass">Inserisci Nuovamente Password</label>
                    <div id="ripetipassword">
                <i class='bx bx-lock-alt'></i>
                <input type="password" id="pass2" name="password" placeholder="Password" required onchange="controllapassword()">
                    </div>
                </div>
                </div>


                <button type="submit">SUBMIT</button>
            </form>
        </div>


        <script src=${pageContext.request.contextPath}/resources/js/register.js></script>
     </BODY>
</HTML>