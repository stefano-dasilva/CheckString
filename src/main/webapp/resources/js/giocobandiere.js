import paesijson from '../countries.json' with { type: 'json' };

document.getElementById("inizia").addEventListener("click", function() {
    iniziaGioco();
});


var paese_random;
var standard;
var bandiere_azzeccate = 0;
var input_standardizzato;

async function iniziaGioco() {

    document.getElementById("inizia").remove()
    document.getElementById("title").remove()


    const card = document.getElementById("second_game_card")
    var img_wrapper = document.createElement("div");
    img_wrapper.classList.add("img_wrapper");
    img_wrapper.id = "img_wrapper"
    card.appendChild(img_wrapper);
    var img = document.createElement("img");
    img.id = "image";
    img_wrapper.appendChild(img)


    await fetchRandomCountry().then(data =>{
        var paese = paesijson.find(paese => paese.cca2 === data.code)
        img.src = paese.flags.png
        paese_random = paese;
        standard = data
        console.log(paese)
        console.log(data)
    })




    var inputUtente = document.createElement("input");
    inputUtente.type = "text";
    inputUtente.id = "inputUtente";
    inputUtente.placeholder = "Inserisci un tentativo.."
    card.appendChild(inputUtente)
    var button = document.createElement("button")
    button.id = "bottone"
    button.textContent = "PROVA";
    button.addEventListener("click", function () {
        provaTentativo();
    })
    card.appendChild(button)

}

 async function fetchCheckString(input) {
     const response = await fetch("checkstring?input=" + encodeURIComponent(input))
     return response.json()
}

async function fetchRandomCountry() {
    const response = await fetch("randomcountry")
    return response.json()
}

async function aumentaPunti() {
    const response = await fetch("aumentapunti")
    return response.json();
}

async function cambiaBandiera(){

    var input_utente = document.getElementById("inputUtente");
    var img = document.getElementById("image");

    input_utente.value = ""
    bandiere_azzeccate++;

    await fetchRandomCountry().then(data => {
        const paese = paesijson.find(paese => paese.cca2 === data.code);
        img.src = paese.flags.png;
        paese_random = paese;
        standard = data;
        console.log(paese);
        console.log(data);
    });




}

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

async function provaTentativo() {
    var input_utente = document.getElementById("inputUtente");



    try {
        const data = await fetchCheckString(inputUtente.value);
        const inputStandardizzato = data?.inputstandard;
        console.log(inputStandardizzato);

        if (inputStandardizzato === standard?.value) {
            const risposta = await aumentaPunti()
            console.log(risposta)
            await cambiaBandiera();
        } else {
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