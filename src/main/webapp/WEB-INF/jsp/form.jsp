<%@page contentType="text/html; charset=UTF-8" %>

<HTML>
     <HEAD>
        <title>Registrazione</title>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css" />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        
     </HEAD>
     <BODY>
        
        <div id="first">
           
            <div id="form">

            <form id="rom" action="submit" method="POST">
               
                <h2 id="h2">Registrati</h2>


                <div id="sec0">
                <label for="nome">Inserisci il tuo nome</label><br>
                </div>
                <div id="sec1">
                <input type="text" id="nome" name="nome" placeholder="Nome" required>
                <i class='bx bxs-user'></i><br><br>
            </div>
                

                <div id="sec2">
                <label for="cognome">Inserisci il tuo cognome</label><br>
                </div>
                <div id="sec3">
                <input type="text" id="cognome" name="cognome" placeholder="Cognome">
                <i class='bx bxs-user'></i><br><br>
                </div>
               

                <div id="sec4">
                <label for="nazione">Inserisci la tua nazionalità</label><br>
                </div>
                <div id="sec11">
                <input type="text" id="nazione" name="nazione" placeholder="Nazionalità" required>
                <i class='bx bx-world'></i><br><br>
                </div>
                

                <div id="sec5">
                <label for="nascita">Data di Nascita</label><br>
                </div>
                <div id="sec8">
                <input type="date" id="nascita" name="nascita" required><br><br>
                </div>
              

               <div id="sec6">
                <label for="pass">Inserisci Password</label><br>
                </div>
                <div id="sec7">
                <input type="password" id="pass" name="password" placeholder="Password" required>
                <i class='bx bx-lock-alt'></i><br><br>
                </div>

                <div id="sec9">
                <label for="pass">Inserisci Nuovamente Password</label><br>
                </div>
                <div id="sec10">
                <input type="password" id="pass2" name="password" placeholder="Password" required>
                <i class='bx bx-lock-alt'></i><br><br>
                </div>
               

                <div id="tasto">
               <input id="sub" type="submit" value="Registrati">
               </div>
               
            </form>
        </div> 
        </div>


        <script src=${pageContext.request.contextPath}/resources/js/form.js></script>
     </BODY>
</HTML>