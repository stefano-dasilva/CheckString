const pass= document.getElementById("pass");
const pass2= document.getElementById("pass2");
const form= document.getElementById("rom");



function checkSpecial(pass){
    const specialCar= ["@", "#", "!", "$", "&"];
    
    for(let j=0; j<pass.length; j++){
            if(specialCar.includes(pass[j])){
                return true
            } 
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

          }
            else if(pass.value !== pass2.value){
            
                alert("le due password non sono identiche");
                event.preventDefault();

            }
        }
    

form.addEventListener('submit', check);








