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

async function iniziaGioco() {


    /*il gioco è iniziato, cancello i bottoni*/
    document.getElementById("inizia").remove()
    document.getElementById("title").remove()


    /*creo i tag del wrapper dell'immagine e dell'immagine stessa che sarà la bandiera*/
    const card = document.getElementById("second_game_card")
    var img_wrapper = document.createElement("div");
    img_wrapper.classList.add("img_wrapper");
    img_wrapper.id = "img_wrapper"
    card.appendChild(img_wrapper);
    var img = document.createElement("img");
    img.id = "image";
    img_wrapper.appendChild(img)


    /*faccio una fetch a /randomcountry che mi restituisce il codice e il valore di un paese random standard*/
    await fetchRandomCountry().then(data =>{

        /*qui prendo dal json locale dei paesi il paese che ha come codice quello casuale preso prima*/
        var paese = paesijson.find(paese => paese.cca2 === data.code)
        /* e setto la src dell'immagine la pandiera del paese ottenuto*/
        img.src = paese.flags.png
        /*mi salvo in delle variabili la parte del json che rappresenta le informaizoni del paese appena
        trovato e salvo in una variabile standard il valore codice valore che ho ottenuto dello standard casuale in /randomcountry
         */
        paese_random = paese;
        standard = data
        console.log(paese)
        console.log(data)
    })




    /*creo semplicemente il tag input per permette allo user di scrivere ed un bottone per inviare il tentativo*/
    var inputUtente = document.createElement("input");
    inputUtente.type = "text";
    inputUtente.id = "inputUtente";
    inputUtente.placeholder = "Inserisci un tentativo.."
    card.appendChild(inputUtente)
    var button = document.createElement("button")
    button.id = "bottone"
    button.textContent = "PROVA";
    /*aggiunto l'evento di click al bottone*/
    button.addEventListener("click", function () {
        provaTentativo();
    })
    card.appendChild(button)

}

/*fa una fetch a /checkstring e restituisce il risultato in json*/
 async function fetchCheckString(input) {
     const response = await fetch("checkstring?input=" + encodeURIComponent(input))
     return response.json()
}

/*fa una fetch a /randomcountry e restituisce il risultato in json*/
async function fetchRandomCountry() {
    const response = await fetch("randomcountry")
    return response.json()
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
    bandiere_azzeccate++;

    /*stesso discorso di prima cambia l'immagine in base alla random country*/
    await fetchRandomCountry().then(data => {
        const paese = paesijson.find(paese => paese.cca2 === data.code);
        img.src = paese.flags.png;
        paese_random = paese;
        standard = data;
        console.log(paese);
        console.log(data);
    });


}

/*viene invocato quando l'utente perde, pulisce la card e chiama /finiscigioco, che andrà a scrivere sul database il nuovo record( se presente )*/

async function finisciGioco(){

    var input_utente = document.getElementById("inputUtente");

    image.remove();
    input_utente.remove()
    var bottone = document.getElementById("bottone")
    bottone.remove()
    var img_wrapper = document.getElementById("img_wrapper")
    img_wrapper.remove()
    const card = document.getElementById("second_game_card")
    var punteggio = document.createElement("h3");
    punteggio.innerText = "Hai totalizzato " + bandiere_azzeccate + " punti"
    card.appendChild(punteggio)
    fetch("finiscigioco?gioco=giocoBandiere")

}

/*viene invocato quando schiacci il bottone per inviare il tentativo*/
async function provaTentativo() {

    /*prende il valore inserito dall'utente...*/
    var input_utente = document.getElementById("inputUtente");



    try {

        /* e lo converte in parola standard tramite fetchCheckString ( è definita sopra )*/
        const data = await fetchCheckString(input_utente.value);
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

        var paese_mappa = document.getElementById(standard.code)
        if (paese_mappa !== null) {
            paese_mappa.style.fill = "#F00";
        }
    } catch (error) {
        console.log(error);
    }






}