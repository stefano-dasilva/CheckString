import paesijson from '../countries.json' with { type: 'json' };

document.getElementById("inizia").addEventListener("click", function() {
    iniziaGioco();
});

/* conterrà le informazioni sul paese random ottenuto dal json che ho in locale dopo aver cercato il paese con codice casuale*/
var paese_random;

/* conterrà la risposta json ottenuta da /randomcountry*/
var standard;

var bandiere_azzeccate = 0;
var input_standardizzato;


function creaCard(){

    /*il gioco è iniziato, cancello i bottoni*/
    document.getElementById("inizia").remove()
    document.getElementById("title").remove()


    /*creo i tag del wrapper dell'immagine e dell'immagine stessa che sarà la bandiera*/
    const card = document.getElementById("second_game_card")
    var upper_wrapper = document.createElement("div")
    var box_skips = document.createElement("div")
    box_skips.id = "box_skips"
    upper_wrapper.id = "upper_wrapper";
    var img_wrapper = document.createElement("div");
    img_wrapper.id = "img_wrapper"
    upper_wrapper.appendChild(img_wrapper)
    upper_wrapper.appendChild(box_skips)
    var box_skip = document.createElement("i")
    var box_skip2 = document.createElement("i")
    var box_skip3 = document.createElement("i")

    box_skip.classList.add('bx', 'bx-world');
    box_skip2.classList.add('bx', 'bx-world');
    box_skip3.classList.add('bx', 'bx-world');

    box_skips.appendChild(box_skip)
    box_skips.appendChild(box_skip2)
    box_skips.appendChild(box_skip3)

    card.appendChild(upper_wrapper);
    var img = document.createElement("img");
    img.id = "image";
    img_wrapper.appendChild(img)

    //var input_wrapper = document.createElement("div");
    var bottoni_wrapper = document.createElement("div");

  //  input_wrapper.id = "input_wrapper"
    bottoni_wrapper.id = "bottoni_wrapper"

    /*creo semplicemente il tag input per permette allo user di scrivere ed un bottone per inviare il tentativo*/
    var form = document.createElement("form")
    form.method = "POST";
    form.action = "checkstring";
    form.id = "input_wrapper"
    var inputUtente = document.createElement("input");
    inputUtente.type = "text";
    inputUtente.name = "inpututente"
    inputUtente.id = "inputUtente";
    inputUtente.placeholder = "Inserisci un tentativo.."
    form.appendChild(inputUtente)
    //input_wrapper.appendChild(inputUtente)
    var button = document.createElement("button")
    button.id = "bottone"
    button.textContent = "PROVA";
    button.type = "submit"
    var skip = document.createElement("button")
    skip.id = "skipbottone"
    skip.textContent = "SKIP";

    form.addEventListener("submit", handleFormSubmit);

    /*aggiunto l'evento di click al bottone*/
    /*
    button.addEventListener("click", function () {
        provaTentativo();
    })

     */
    skip.addEventListener("click", function () {
        saltaBandiera();
    })
   // input_wrapper.appendChild(bottoni_wrapper)
    form.appendChild(bottoni_wrapper)
    bottoni_wrapper.appendChild(button)
    bottoni_wrapper.appendChild(skip)

    card.appendChild(form)

}


async function handleFormSubmit(event) {
    console.log("sono qui")
    event.preventDefault();
    const my_form = document.getElementById("input_wrapper")
    const response = await fetch(my_form.action, {
        method: my_form.method,
        body: document.getElementById("inputUtente").value
    })
    const risultato = await  response.json()
    console.log(risultato)
        return provaTentativo(risultato)
}

async function saltaBandiera(){

    fetch('controllatentativi')
        .then(response=>response.json())
        .then(async (data) => {
            if (data.tentativi_rimasti >= 0) {
                console.log(data.tentativi_rimasti)
                await cambiaBandiera()
                var box_skips = document.getElementById("box_skips")
                var cambia_colore = box_skips.children[data.tentativi_rimasti];
                cambia_colore.classList.add('nondisponibile')
            }
        })



}

function aggiornaCardInfo(){


    var mappa_wrapper = document.getElementById("mappa");

    mappa_wrapper.remove();

    var finish_content = document.createElement("div");
    finish_content.id = "finish_content"
    var second_game_info = document.getElementById("second_game_info")
    second_game_info.appendChild(finish_content)
    second_game_info.classList.add("centerbox")
    var didascalia_wrapper = document.createElement("div");
    didascalia_wrapper.id = "didascalia_wrapper"
    var didascalia = document.createElement("h3");
    didascalia.id = "didascalia"
    didascalia.innerText = `Scopri ulteriori informazioni su ${standard.value}`
    var button_external = document.createElement("button");
    button_external.id = "bottone_esterno"
    button_external.innerText = "SCOPRI"
    button_external.addEventListener("click", function (){
        window.open(paese_random.maps.openStreetMaps, "_blank");
    })

    didascalia_wrapper.appendChild(didascalia)
    didascalia_wrapper.appendChild(button_external)
    finish_content.appendChild(didascalia_wrapper)
    console.log(paese_random.maps.openStreetMaps);

    var separatore = document.createElement("div")
    separatore.id = "separatore"
    finish_content.appendChild(separatore)
    var rigioca_wrapper = document.createElement("div")
    rigioca_wrapper.id = "rigioca_wrapper"
    finish_content.appendChild(rigioca_wrapper)
    var didascalia2 = document.createElement("h3");
    didascalia2.id = "didascalia2"
    didascalia2.innerText = `Rigioca`
    rigioca_wrapper.appendChild(didascalia2)
    var refresh = document.createElement("i");
    refresh.classList.add('bx', 'bx-refresh');
    refresh.addEventListener('click',restart)
    rigioca_wrapper.appendChild(refresh)

}

async function restart(){
    fetch('show_giocobandiere').then(window.location.reload())
}

async function iniziaGioco() {



    creaCard()

    /*faccio una fetch a /randomcountry che mi restituisce il codice e il valore di un paese random standard*/
    await fetchRandomCountry().then(data =>{

        /*qui prendo dal json locale dei paesi il paese che ha come codice quello casuale preso prima*/
        var paese = paesijson.find(paese => paese.cca2 === data.code)
        var img = document.getElementById("image")
        /* e setto la src dell'immagine la pandiera del paese ottenuto*/
        img.src = paese.flags.png
        /*mi salvo in delle variabili la parte del json che rappresenta le informaizoni del paese appena
        trovato e salvo in una variabile standard il valore codice valore che ho ottenuto dello standard casuale in /randomcountry
         */
        paese_random = paese;
        standard = data
        console.log(paese)
        console.log(data)

        console.log(standard.code)
        var paese_mappa = document.getElementById(standard.code)
        if (paese_mappa !== null) {
            paese_mappa.style.fill = "#F00";
        }
    })




}

/*fa una fetch a /checkstring e restituisce il risultato in json*/
 async function fetchCheckString(input) {
     const response = await fetch("checkstring?input=" + encodeURIComponent(input))
     return response.json()
}

/*fa una fetch a /randomcountry e restituisce il risultato in json*/
async function fetchRandomCountry() {
    try {
        const response = await fetch("randomcountry");
        const data = await response.json();
        const paese = paesijson.find(paese => paese.cca2 === data.code);
        if(paese === undefined || paese === null || paese.flags.png === undefined || paese.flags.png === null){
            fetchRandomCountry()
        }
        else{
            return data;
        }
    } catch (error) {
        console.error('error su fetchrandomcountry', error);
    }

}

/*fa una fetch a /aumentapunti e restituisce i punti attuali della partita e restituisce in json ( solo per test )*/
async function aumentaPunti() {
    const response = await fetch("aumentapunti")
    return response.json();
}

/* funzione per cambiare la bandiera se l'utente è andato avanti ( fa una fetch a /randomcountry ) */
async function cambiaBandiera(){

    var input_utente = document.getElementById("inputUtente");
    var img = document.getElementById("image");

    input_utente.value = ""

    /*stesso discorso di prima cambia l'immagine in base alla random country*/
    await fetchRandomCountry().then(data => {
        const paese = paesijson.find(paese => paese.cca2 === data.code);
        img.src = paese.flags.png;
        paese_random = paese;
        standard = data;
        console.log(paese);
        console.log(data);
        console.log(standard.code)
        var paese_mappa = document.getElementById(standard.code)
        if (paese_mappa !== null) {
            paese_mappa.style.fill = "#F00";
        }
    });


}

/*viene invocato quando l'utente perde, pulisce la card e chiama /finiscigioco, che andrà a scrivere sul database il nuovo record( se presente )*/

async function finisciGioco(){



    var upper_wrapper = document.getElementById("upper_wrapper")
    upper_wrapper.remove()

    var input_wrapper = document.getElementById("input_wrapper")
    input_wrapper.remove()

    const card = document.getElementById("second_game_card")


    fetch("finiscigioco?gioco=giocoBandiere")
        .then(response => response.json())
        .then((data) => {
            var punteggio = document.createElement("h2");
            punteggio.innerText = "Hai totalizzato " + data.punteggio + " punti"
            card.appendChild(punteggio)
            console.log(data.nuovo_record)
            if(data.nuovo_record === "true"){
                var nuovo_record = document.createElement("h3");
                nuovo_record.innerText = "Hai superato il tuo record!"
                card.appendChild(nuovo_record)
            }
            console.log(data)
        })

  aggiornaCardInfo()

}

/*viene invocato quando schiacci il bottone per inviare il tentativo*/
async function provaTentativo(data) {

console.log(data)

    /*prende il valore inserito dall'utente...*/
    /*
    var input_utente = document.getElementById("inputUtente");

     */



    try {

        /* e lo converte in parola standard tramite fetchCheckString ( è definita sopra )*/
      //  const data = await fetchCheckString(input_utente.value);
        /*questo è l'input standardizzato, lo stampo per prova*/
        const inputStandardizzato = data?.inputstandard;
        console.log(inputStandardizzato);


        /* se il mio input è uguale a standard?.value dove quest'ultimo è la parola standard che abbiamo preso dal backend e ci siamo salvati nella var standard*/
        if (inputStandardizzato === standard?.value) {
            /* allora faccio una chiamata al backend per aumentare i punti della session*/
            const risposta = await aumentaPunti()
            console.log(risposta)
            /* e vado avanti cambiando bandiera*/
            await cambiaBandiera();
        } else {
            /* in caso contrario finisco il gioco*/
            await finisciGioco()

        }


    } catch (error) {
        console.log(error);
    }






}