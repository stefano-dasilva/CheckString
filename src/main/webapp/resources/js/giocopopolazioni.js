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


function aggiornaCardInfo(){


    var chart = document.getElementById("first_chart");
    var third_game_info = document.getElementById("third_game_info");
    chart.remove();

    var finish_content = document.createElement("div");
    finish_content.id = "finish_content"
    third_game_info.appendChild(finish_content)
    var didascalia = document.createElement("h3");
    didascalia.id = "didascalia"
    didascalia.innerText = `Rigioca`
    finish_content.appendChild(didascalia)
    var refresh = document.createElement("i");
    refresh.classList.add('bx', 'bx-refresh');
    refresh.addEventListener('click',restart)
    finish_content.appendChild(refresh)

}

async function restart(){
    fetch('show_giocopopolazione').then(window.location.reload())
}

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
        drawTemperatureChart(paesesx.capitalInfo.latlng,paesedx.capitalInfo.latlng)
        console.log(paesesx.capitalInfo.latlng);
        console.log(paesedx.capitalInfo.latlng);
    })


}

async function finisciGioco(){

    var wrapper_paesi = document.getElementById("wrapper_paesi");
    var bottoni_wrapper = document.getElementById("bottoni_wrapper");
    wrapper_paesi.remove()
    bottoni_wrapper.remove()
    var third_game_content = document.getElementById("third_game_content_card")


    fetch("finiscigioco?gioco=giocoPopolazione")
        .then(response => response.json())
        .then((data) => {
            var punteggio = document.createElement("h3");
            punteggio.innerText = "Hai totalizzato " + data.punteggio + " punti"
            console.log(data.nuovo_record)
            if(data.nuovo_record === "true"){
                console.log("c'è stato un nuovo record")
                console.log(data)
                var nuovo_record = document.createElement("h3");
                nuovo_record.innerText = "Hai superato il tuo record!"
                console.log(nuovo_record)
                third_game_content.appendChild(nuovo_record)
            }
            third_game_content.appendChild(punteggio)
            console.log(data)
        })

    aggiornaCardInfo()

    /*
        var punteggio = document.createElement("h3");
        punteggio.innerText = "Hai totalizzato " + bandiere_azzeccate + " punti"
        card.appendChild(punteggio)
        fetch("finiscigioco?gioco=giocoPopolazione")


     */
}

async function provaTentativo(event){

    var confronto_popolazione = (paese_randomsx.population > paese_randomdx.population)
    console.log("popolazione paese sx : " +  paese_randomsx.population + " popolazione paese dx : " + paese_randomdx.population)

    /*fa un confronto tra le due popolazioni, quindi confronto_popolazione sarà true quando il paese di sx avrà una pop maggione
    e sarà false quando la popolazione del paese di sx sarà minore di quella di destra
     */
    var scelta = event.target.value;
    /* caso in cui la popolazione del paese di sinistra è maggiore... */
    if(confronto_popolazione){
        /* e l'utente ha schiacciato lower ( ovvero che quella di destra sia minore )*/
        if(scelta === "lower"){
            aumentaPunti()
            var nome_paese_sx = document.getElementById("nome_paesesx")
            nome_paese_sx.innerText = paese_randomsx.population
            var nome_paese_dx = document.getElementById("nome_paesedx")
            nome_paese_dx.innerText = paese_randomdx.population
            if(paese_randomdx.population > paese_randomsx.population){
                nome_paese_dx.style.color = "green"
                nome_paese_sx.style.color = "red"
            }
            else{
                nome_paese_dx.style.color = "red"
                nome_paese_sx.style.color = "green"
            }
            setTimeout(function () {
                nome_paese_dx.style.color = "black"
                nome_paese_sx.style.color = "black"
            aggiornaCard()
            }, 1000);
        }
        /* e l'utente ha schiacciato higher */
        else{
            console.log("hai sbagliato")
            await finisciGioco()
        }
    }
    if(!confronto_popolazione){
        if(scelta === "lower"){
            await finisciGioco()
        }
        else{
            aumentaPunti()
            var nome_paese_sx = document.getElementById("nome_paesesx")
                nome_paese_sx.innerText = paese_randomsx.population
            var nome_paese_dx = document.getElementById("nome_paesedx")
            nome_paese_dx.innerText = paese_randomdx.population
            if(paese_randomdx.population > paese_randomsx.population){
                nome_paese_dx.style.color = "green"
                nome_paese_sx.style.color = "red"
            }
            else{
                nome_paese_dx.style.color = "red"
                nome_paese_sx.style.color = "green"
            }
            setTimeout(function () {
                nome_paese_dx.style.color = "black"
                nome_paese_sx.style.color = "black"
            aggiornaCard()
            }, 1000);
        }
    }
}


/*fa una fetch a /aumentapunti e restituisce i punti attuali della partita e restituisce in json ( solo per test )*/
async function aumentaPunti() {
    const response = await fetch("aumentapunti")
    return response.json();
}

async function  aggiornaCard(){

    await fetchRandomCountry().then((data)=>{
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
        drawTemperatureChart(paesesx.capitalInfo.latlng,paesedx.capitalInfo.latlng)
        console.log(paesesx);
        console.log(paesedx);

    })



}

function creaComposizioneCard() {

    document.getElementById("inizia").remove()
    document.getElementById("title").remove()

    const game_card = document.getElementById("third_game_card");
    const da_cancellare = document.getElementById("third_game_content")
    da_cancellare.remove()


    const card = document.createElement("div")
    card.id = "third_game_content_card"
    game_card.appendChild(card);


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
    lower.innerText = "Lower "
    lower.value = "lower"
    var downarrow = document.createElement('i');
    downarrow.classList.add('bx', 'bxs-down-arrow');
    lower.appendChild(downarrow)



    var higher = document.createElement("button")
    higher.id = "higher"
    higher.innerText = "Higher"
    higher.value = "higher"
    bottoni_wrapper.appendChild(higher)
    var uparrow = document.createElement('i');
    uparrow.classList.add('bx', 'bxs-up-arrow');
    higher.appendChild(uparrow)




    /*e gli aggiungo un event listener di click*/
    lower.addEventListener("click", provaTentativo)
    higher.addEventListener("click", provaTentativo)

}


async function fetchWeatherAPI(latlng){



    const response = await fetch(`https://api.open-meteo.com/v1/forecast?latitude=${latlng[0]}&longitude=${latlng[1]}&hourly=temperature_2m`)
    return response.json()
}



async function drawTemperatureChart(latlngsx,latlngdx ) {

    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(async function () {

        const responsesx = await fetchWeatherAPI(latlngsx);
        const responsedx = await fetchWeatherAPI(latlngdx);

        const temperaturesx = responsesx.hourly;
        const temperaturedx = responsedx.hourly;

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'ora');
        data.addColumn('number', standardsx.value);
        data.addColumn('number', standarddx.value);
        var rows = [];

        temperaturesx.time.forEach(function(ora, indice) {
            rows.push([ora.slice(5,16), temperaturesx.temperature_2m[indice], temperaturedx.temperature_2m[indice]]);
        });

        data.addRows(rows);

        var options = {
            hAxis: {
                title: "Ora"
            },
            vAxis: {
                title: "Temperatura (°C)"
            },
            backgroundColor: '#FFF2F9'
        };

        var chartElement = document.getElementById( 'first_chart');
        var chart = new google.visualization.LineChart(chartElement);
        chart.draw(data, options);
    });
}
