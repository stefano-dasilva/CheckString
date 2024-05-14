const pass= document.getElementById("pass");
const pass2= document.getElementById("pass2");
const form= document.getElementById("rom");
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
    

form.addEventListener('submit', check);








