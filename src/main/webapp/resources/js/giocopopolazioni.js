import paesijson from "../countries.json" with { type: 'json' };

document.getElementById("inizia").addEventListener("click", function() {
    iniziaGioco();
});

/*N.B DATO CHE HO SEMPRE DUE BANDIERE SX SI RIFERISCE A QUELLA CHE SI TROVA A SX- DESTRA A DESTRA*/

/* conterrà le informazioni sul paese random ottenuto dal json che ho in locale dopo aver cercato il paese con codice casuale*/
var paese_randomsx;
var paese_randomdx;

/* conterrà la risposta json ottenuta da /randomcountry*/
var standardsx;
var standarddx;
var bandiere_azzeccate = 0;



async function fetchRandomCountry() {
    const response = await fetch("randomcountry3")
    return response.json()
}

async function iniziaGioco(){

    /* crea la composizione della card, rimuovendo i bottoni e creando i vari div p.s la funzione è sotto a questa*/
   creaComposizioneCard()

    await fetchRandomCountry().then(data=>{
        /* prende i due paesi corrispondenti dal json locale presi tramite codice casuale*/
        const paesesx = paesijson.find(paese => paese.cca2 === data.standard1.code);
        const paesedx = paesijson.find(paese => paese.cca2 === data.standard2.code);

        /*assenga ai tag immagini corrispondente le bandiere*/
        imgsx.src = paesesx.flags.png;
        imgdx.src = paesedx.flags.png;

        paese_randomsx = paesesx;
        paese_randomdx = paesedx;
        standardsx = data.standard1;
        standarddx = data.standard2;
        nome_paesesx.innerText = standardsx.value
        nome_paesedx.innerText = standarddx.value
        console.log(paesesx);
        console.log(paesedx);
    })


}

async function provaTentativo(event){

    var confronto_popolazione = (paese_randomsx.population > paese_randomdx.population)
    console.log("popolazione paese sx : " +  paese_randomsx.population + " popolazione paese dx : " + paese_randomdx.population)

    var scelta = event.target.value;
    if(confronto_popolazione){
        if(scelta === "lower"){
            console.log("bravo")
        }
        else{
            console.log("hai sbagliato")
        }
    }
    if(!confronto_popolazione){
        if(scelta === "lower"){
            console.log("hai sbagliato")
        }
        else{
            console.log("bravo")
        }
    }



}

function creaComposizioneCard(){

    document.getElementById("inizia").remove()
    document.getElementById("title").remove()


    const card = document.getElementById("third_game_content")





    var wrapper_paesi = document.createElement("div");

    wrapper_paesi.id = "wrapper_paesi"
    card.appendChild(wrapper_paesi);

    /*in questo pezzo sto creando il wrapper che conterrà le informazioni del paese di sx ( bandiera e nome)*/
    var paese_wrappersx = document.createElement("div");
    paese_wrappersx.classList.add("paese_wrappersx");
    wrapper_paesi.appendChild(paese_wrappersx);


    /*in questo pezzo sto creando il wrapper che conterrà la bandiera che si vede a sx*/
    var img_wrappersx = document.createElement("div");
    img_wrappersx.classList.add("img_wrappersx");
    img_wrappersx.id = "img_wrappersx"
    paese_wrappersx.appendChild(img_wrappersx)
    /*in questo pezzo sto creando lo spazio che conterrà il nome del paese che si vede a sx*/
    var nome_paesesx = document.createElement("span");
    nome_paesesx.id = "nome_paesesx"
    paese_wrappersx.appendChild(nome_paesesx)


    /*in questo pezzo sto creando il wrapper che conterrà le informazioni del paese di dx ( bandiera e nome)*/
    var paese_wrapperdx = document.createElement("div");
    paese_wrapperdx.classList.add("paese_wrapperdx");
    wrapper_paesi.appendChild(paese_wrapperdx);
    /*in questo pezzo sto creando il wrapper che contienerà la bandiera che si vede a dx*/
    var img_wrapperdx = document.createElement("div");
    img_wrapperdx.classList.add("img_wrapperdx");
    img_wrapperdx.id = "img_wrapperdx"
    paese_wrapperdx.appendChild(img_wrapperdx)
    /*in questo pezzo sto creando lo spazio che conterrà il nome del paese che si vede a dx*/
    var nome_paesedx = document.createElement("span");
    nome_paesedx.id = "nome_paesedx"
    paese_wrapperdx.appendChild(nome_paesedx)

    /*in questo pezzo sto creando il tag dell'immagine della bandiera che si vede a sx*/
    var imgsx = document.createElement("img");
    imgsx.id = "imgsx";
    img_wrappersx.appendChild(imgsx)

    /*in questo pezzo sto creando il tag dell'immagine della bandiera che si vede a dx*/
    var imgdx = document.createElement("img");
    imgdx.id = "imgdx";
    img_wrapperdx.appendChild(imgdx)

    /*in questo pezzo sto creando lo spazio che conterrà i due bottoni higher e lower*/
    var bottoni_wrapper = document.createElement("div")
    bottoni_wrapper.id = "bottoni_wrapper"
    card.appendChild(bottoni_wrapper)

    /*creo i bottoni higher e lower*/
    var lower = document.createElement("button")
    lower.id = "lower"
    bottoni_wrapper.appendChild(lower)
    lower.innerText = "Lower"
    lower.value = "lower"

    var higher = document.createElement("button")
    higher.id = "higher"
    higher.innerText = "Higher"
    higher.value = "higher"
    bottoni_wrapper.appendChild(higher)

    /*e gli aggiungo un event listener di click*/
    lower.addEventListener("click", provaTentativo)
    higher.addEventListener("click",provaTentativo)

}