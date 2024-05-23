import paesijson from '../countries.json' with { type: 'json' };

document.getElementById("inizia").addEventListener("click", function() {
    iniziaGioco();
});




var paese_random;
var standard;
var bandiere_azzeccate = 0;

function iniziaGioco() {
    document.getElementById("inizia").remove()
    document.getElementById("title").remove()


    const card = document.getElementById("second_game_card")
    var img_wrapper = document.createElement("div");
    img_wrapper.classList.add("img_wrapper");
    img_wrapper.id = "img_wrapper"
    card.appendChild(img_wrapper);
    var img = document.createElement("img");
    img.id ="image";
    img_wrapper.appendChild(img)


    fetch('randomcountry')
        .then(response => response.json())
        .then(data => {
                var paese = paesijson.find(paese => paese.cca2 === data.code )
                img.src = paese.flags.png
                paese_random = paese;
                standard = data
                console.log(paese)
                console.log(data)
            }
        )


    var inputUtente = document.createElement("input");
    inputUtente.type = "text";
    inputUtente.id = "inputUtente";
    inputUtente.placeholder = "Inserisci un tentativo.."
    card.appendChild(inputUtente)
    var button = document.createElement("button")
    button.id = "bottone"
    button.textContent = "PROVA";
    button.addEventListener("click",function (){
        provaTentativo();
    })
    card.appendChild(button)

}

function provaTentativo(){
    var input_utente = document.getElementById("inputUtente");
    var img = document.getElementById("image");

    if(input_utente.value === standard?.value ){
        console.log("azzeccata")
        input_utente.value = ""
        bandiere_azzeccate++;
        fetch('randomcountry')
            .then(response => response.json())
            .then(data => {
                var paese = paesijson.find(paese => paese.cca2 === data.code )
                img.src = paese.flags.png
                paese_random = paese;
                standard = data
                console.log(paese)
                console.log(data)
                }
            )

    }
    else{
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
    }
    var paese_mappa = document.getElementById(standard.code)
    if(paese_mappa !== null){
        paese_mappa.style.fill = "#F00";
    }
}