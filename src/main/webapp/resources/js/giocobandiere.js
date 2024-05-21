document.getElementById("inizia").addEventListener("click", function() {
    iniziaGioco();
});


var dati;
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
                img.src = data[0].flags.png;
                dati = data;
                console.log(data?.[0]?.translations?.ita?.common)
            }
        )


    var inputUtente = document.createElement("input");
    inputUtente.type = "text";
    inputUtente.id = "inputUtente";
    card.appendChild(inputUtente)
    var button = document.createElement("button")
    button.id = "bottone"
    button.textContent = "invia";
    button.addEventListener("click",function (){
        provaTentativo();
    })
    card.appendChild(button)


}

function provaTentativo(){
    var input_utente = document.getElementById("inputUtente");
    var image = document.getElementById("image");
    if(input_utente.value === dati?.[0]?.translations?.ita?.common ){
        console.log("azzeccata")
        bandiere_azzeccate++;
        fetch('randomcountry')
            .then(response => response.json())
            .then(data => {
                    image.src = data[0].flags.png;
                    dati = data;
                console.log(data?.[0]?.translations?.ita?.common)
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
        punteggio.innerText = "Hai totalizzato " + bandiere_azzeccate + "punti"
        card.appendChild(punteggio)

    }


}