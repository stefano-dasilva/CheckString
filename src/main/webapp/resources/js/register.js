/*
const pass= document.getElementById("pass");
const pass2= document.getElementById("pass2");
const register= document.getElementById("form");
const date=document.getElementById("nascita");



function checkSpecial(pass){
    const specialCar= ["@", "#", "!", "$", "&"];
    
    for(let j=0; j<pass.length; j++){
            if(specialCar.includes(pass[j])){
                return true
            } 
        }
                return false;
            }





function checkDate(dateValue) {
    const dataValue = new Date(dateValue); // Parse string to Date object
    const yearInserito = dataValue.getFullYear();
    const monthInserito = dataValue.getMonth();
    const dayInserito = dataValue.getDate();
    const dataAttuale = new Date();
    const yearAttuale = dataAttuale.getFullYear();
    const monthAttuale = dataAttuale.getMonth();
    const dayAttuale = dataAttuale.getDate();

    if (yearAttuale - yearInserito >= 18 && monthInserito <= monthAttuale && dayInserito <= dayAttuale) {
        return true;
    }
    return false;
}



            

        

function check(event){

    if(pass.value.length < 6){

        alert("La password è troppo corta");
        event.preventDefault();
    }else if(pass.value.length >=20){

            alert("La password è troppo lunga");
            event.preventDefault();

register.addEventListener('submit', check);








          }
          else if(!checkSpecial(pass.value)){
            alert("La password deve contenere almeno un carattere speciale tra @, #, !, $, &");
            event.preventDefault();

          } else if(!checkDate(date.value())){
              alert("Non sei maggiorenne. Torna dalla mamma");
              event.preventDefault();

    }
            else if(pass.value !== pass2.value){
            
                alert("le due password non sono identiche");
                event.preventDefault();

            }
        }




function controllapassword(){

    var pass1 = document.getElementById("password");
    var pass2 = document.getElementById("pass2");
    var inputbox = document.getElementById("ripetipassword");

    if(pass1.value && pass2.value){

        if(pass1.value !== pass2.value){

            inputbox.style.borderColor = "red";
        }
        else{
            inputbox.style.borderColor = 'black'
        }
    }



    console.log(password1.value,password2.value)
}
    */

const form = document.getElementById('form');
const nome = document.getElementById('nome');
const username = document.getElementById('username');
const cognome = document.getElementById('cognome');
const nazione = document.getElementById('nazione');
const pass= document.getElementById("pass");
const pass2= document.getElementById("pass2");
const date= document.getElementById("nascita");


form.addEventListener('submit', (e) =>{
    e.preventDefault();

    if (checkInputs()){
        console.log('Submit da effettuare');
        document.getElementById('form').submit();

    }

});

function checkInputs() {
    const nomeValue = nome.value.trim();

    const cognomeValue = cognome.value.trim();
    const usernameValue = username.value.trim();
    const nazioneValue = nazione.value.trim();
    const passValue = pass.value;
    const pass2Value = pass2.value;
    const dateValue = date.value;

  /*  console.log('data:' + dateValue.value);
    const oggi = new Date();
    const dataJS = new Date(oggi.getFullYear(), oggi.getMonth(), oggi.getDay());

    console.log('data js:' + dataJS);
if(dateValue.value > dataJS){
    console.log('dataFutura');
}*/
    let valid = true;
    /*
        if (nomeValue === ''){
            //mostra errore aggiungere error class
            setErrorFor(nome, 'Nome non può essere vuoto');
        } else {
            //aggiungere success class
         setSuccessFor(nome);
        }
    }
*/

    if (nomeValue === '') {
        setErrorFor(nome, 'Nome non può essere vuoto!');
        valid = false;
    } else {
        setSuccessFor(nome);
    }


    if (cognomeValue === '') {
        setErrorFor(cognome, 'Cognome non può essere vuoto!');
        valid = false;
    } else {
        setSuccessFor(cognome);
    }

    if (usernameValue.length < 3 || usernameValue.length > 20) {
        setErrorFor(username, 'Username deve essere tra 3 e 20 caratteri');
        valid = false;
    } else {
        setSuccessFor(username);
    }

if (nazioneValue.length < 3){
    setErrorFor(nazione,'Inserisci almeno 3 caratteri!');
    valid = false;
} else {
    setSuccessFor(nazione);
}
    if(passValue === '') {
        setErrorFor(pass, 'Inserire una password');
        valid = false;
    }else if (passValue.length < 6) {
        setErrorFor(pass, 'La password è troppo corta');
        valid = false;
    } else if (passValue.length > 20) {
        setErrorFor(pass, 'La password è troppo lunga');
        valid = false;
    } else if (!checkSpecial(passValue)) {
        setErrorFor(pass, 'La password deve contenere almeno un carattere speciale tra @, #, !, $, &');
        valid = false;
    } else {
        setSuccessFor(pass);
    }

    if (passValue !== pass2Value) {
        setErrorFor(pass2, 'Le password non corrispondono');
        valid = false;
    } else if(pass2Value === '') {
        setErrorFor(pass2,'Inserire una password')
    }
    else {
        setSuccessFor(pass2);
    }

    if (!isValidDateOfBirth(dateValue)) {
        setErrorFor(date, 'La data di nascita deve essere precedente ad oggi.');
        valid = false;
    } else {
        setSuccessFor(date);
    }
    return valid;

}

function isValidDateOfBirth(dateValue) {
    const birthDate = new Date(dateValue);
    const today = new Date();
    today.setHours(0, 0, 0, 0);

    return birthDate < today;
}





function setErrorFor(input, message){
    const formControl = input.closest('.form-control');
    const small = formControl.querySelector('small');
    const iconError = formControl.querySelector('.icon-error');
    const iconCheck = formControl.querySelector('.icon-check');


    //aggiungiamo error message dentro small
    small.innerText = message;

    //aggiungiamo error class
   // const box = formControl.querySelector('.input-container');
    //box.className = 'form-control.error';

    formControl.classList.add('error');
    formControl.classList.remove('success');
    // nascondiamo icona di check
    iconCheck.style.display = 'none';
    // mostriamo icona di errore
    iconError.style.display = 'inline';
    //return false;

}

function setSuccessFor(input){
   // const formControl = input.parentElement;
    const formControl = input.closest('.form-control');

    const iconError = formControl.querySelector('.icon-error');
    const iconCheck = formControl.querySelector('.icon-check');

    formControl.classList.add('success');
    formControl.classList.remove('error');
   // formControl.className = 'form-control success';
    // nascondiamo icona di errore
    iconError.style.display = 'none';
    // mostriamo icona di check
    iconCheck.style.display = 'inline';


}

function checkSpecial(value) {
    const specialChars = ["@", "#", "!", "$", "&"];
    return specialChars.some(char => value.includes(char));
}

/*
const form = document.getElementById('form');
const nome = document.getElementById('nome');
const username = document.getElementById('username');
const cognome = document.getElementById('cognome');
const nazione = document.getElementById('nazione');
const pass= document.getElementById("pass");
const pass2= document.getElementById("pass2");

form.addEventListener('submit', (e) =>{
    e.preventDefault();

checkInputs();
});

function checkInputs() {
    console.log("sono qui")
    const nomeValue = nome.value.trim();
    console.log(nomeValue);
    const cognomeValue = cognome.value.trim();
    const usernameValue = username.value.trim();
    const nazioneValue = nazione.value.trim();
    const passValue = pass.value;
    const pass2Value = pass2.value;
    let valid = true;
    /*
        if (nomeValue === ''){
            //mostra errore aggiungere error class
            setErrorFor(nome, 'Nome non può essere vuoto');
        } else {
            //aggiungere success class
         setSuccessFor(nome);
        }
    }


    if (nomeValue === '') {
        setErrorFor(nome, 'Nome non può essere vuoto!');
        valid = false;
    } else {
        setSuccessFor(nome);
    }


    if (cognomeValue === '') {
        setErrorFor(cognome, 'Cognome non può essere vuoto!');
        valid = false;
    } else {
        setSuccessFor(cognome);
    }

    if (usernameValue.length < 3 || usernameValue.length > 20) {
        setErrorFor(username, 'Username deve essere tra 3 e 20 caratteri');
        valid = false;
    } else {
        setSuccessFor(username);
    }

    if (nazioneValue.length < 3){
        setErrorFor(nazione,'Inserisci almeno 3 caratteri!');
        valid = false;
    } else {
        setSuccessFor(nazione);
    }

    if (passValue.length < 6) {
        setErrorFor(pass, 'La password è troppo corta');
        valid = false;
    } else if (passValue.length > 20) {
        setErrorFor(pass, 'La password è troppo lunga');
        valid = false;
    } else if (!checkSpecial(passValue)) {
        setErrorFor(pass, 'La password deve contenere almeno un carattere speciale tra @, #, !, $, &');
        valid = false;
    } else {
        setSuccessFor(pass);
    }

    if (passValue !== pass2Value) {
        setErrorFor(pass2, 'Le password non corrispondono');
        valid = false;
    } else {
        setSuccessFor(pass2);
    }

    return valid;

}




function setErrorFor(input, message){
    const formControl = input.closest('.form-control');
    const small = formControl.querySelector('small');
    console.log(small);
    console.log(formControl);

    //aggiungiamo error message dentro small
    small.innerText = message;

    //aggiungiamo error class
    const box = formControl.querySelector('div');
    box.className = 'form-control error';
    return false;
}

function setSuccessFor(input){
    const formControl = input.parentElement;
    formControl.className = 'form-control success';
}

function checkSpecial(value) {
    const specialChars = ["@", "#", "!", "$", "&"];
    return specialChars.some(char => value.includes(char));
}
*/



