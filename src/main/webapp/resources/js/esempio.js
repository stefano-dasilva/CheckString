function checkform(){

    var nome = document.getElementById("nome")
    var cognome = document.getElementById("cognome")
    var nazione = document.getElementById("nazione")

    if(!nome.value || !cognome.value || !nazione.value){
        document.getElementById("errore").innerHTML = "Si prega di inserire tutti i campi"
        return false;
    }
    else{
        return  true;
    }
}

function controllapassword(){

    var pass1 = document.getElementById("password");
    var pass2 = document.getElementById("password2");
    var inputbox = document.getElementById("ripetipassword");

    if(pass1.value && pass2.value){

        if(pass1.value !== pass2.value){

            document.getElementById("errore").innerHTML = "Le due password non coincidono"
            inputbox.style.borderColor = "red";
        }
        else{
            inputbox.style.borderColor = 'black'
            document.getElementById("errore").innerHTML = ""
        }
    }
    console.log(pass1.value,pass2.value)
}