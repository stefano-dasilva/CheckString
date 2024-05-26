
import paesijson from '../countries.json' with { type: 'json' };


document.addEventListener('DOMContentLoaded', (event) => {
    var parte2 = document.getElementById("parte2");
    parte2.parentNode.removeChild(parte2);

    document.getElementById("iniziaBottone").addEventListener('click', inizia);
    var punteggio = 0;


    function inizia(){
        document.getElementById("container").appendChild(parte2);
        var parte1=document.getElementById("parte1");
        parte1.parentNode.removeChild(parte1);
        fetchCountries();
    }

    function fetchCountries() {
        fetch('randomcountry2')
            .then(response => response.json())
            .then(data => {
                var paese1 = paesijson.find(paese => paese.cca2 === data.code1);
                var paese2 = paesijson.find(paese => paese.cca2 === data.code2);
                var paese3 = paesijson.find(paese => paese.cca2 === data.code3);
                var paese4 = paesijson.find(paese => paese.cca2 === data.code4);


                if (!paese1.capital || !paese2.capital || !paese3.capital || !paese4.capital) {
                    console.log("Non ho trovato tutte le capitali");
                    fetchCountries();
                    return;
                }


                var paeseIndovinato = paese1.name.common;
                var paese = document.getElementById("paese");
                paese.textContent = paeseIndovinato;

                var first = document.getElementById("first");
                var second = document.getElementById("second");
                var third = document.getElementById("third");
                var fourth = document.getElementById("fourth");

                var paese1Cap = paese1.capital[0];
                var paese2Cap = paese2.capital[0];
                var paese3Cap = paese3.capital[0];
                var paese4Cap = paese4.capital[0];

                var capitali = [paese1Cap, paese2Cap, paese3Cap, paese4Cap];

                const randomIdx1 = Math.floor(Math.random() * capitali.length);
                first.textContent = capitali[randomIdx1];
                capitali.splice(randomIdx1, 1);

                const randomIdx2 = Math.floor(Math.random() * capitali.length);
                second.textContent = capitali[randomIdx2];
                capitali.splice(randomIdx2, 1);

                const randomIdx3 = Math.floor(Math.random() * capitali.length);
                third.textContent = capitali[randomIdx3];
                capitali.splice(randomIdx3, 1);

                const randomIdx4 = Math.floor(Math.random() * capitali.length);
                fourth.textContent = capitali[randomIdx4];
                capitali.splice(randomIdx4, 1);

                var img = document.getElementById("img");
                img.src = paese1.flags.png;
                console.log(data);
                console.log(paese1);

                first.addEventListener("click", () => verifica(first, paese1.capital));
                second.addEventListener("click", () => verifica(second, paese1.capital));
                third.addEventListener("click", () => verifica(third, paese1.capital));
                fourth.addEventListener("click", () => verifica(fourth, paese1.capital));
                 document.getElementById("punti").innerText= punteggio;
                resetColor();
            })

        function verifica(capitaleSelezionata, CapitaleCorretta) {

            console.log(" Capitale Selezionata:", capitaleSelezionata);
            console.log("Capitale Corretta:", CapitaleCorretta);



            if (capitaleSelezionata.textContent === CapitaleCorretta[0]) {
                console.log("Risposta corretta");
                capitaleSelezionata.style.backgroundColor="green";

                punteggio++;
                var punti = document.getElementById("punti").innerText= punteggio;
                var message=document.getElementById("rispostaCorretta");
                message.style.display = "inline-flex";
                setTimeout(function (){
                    message.style.display = "none";
                    fetchCountries();
                }, 1000);
            } else {
                console.log("Risposta sbagliata");
                capitaleSelezionata.style.backgroundColor="red";
            }
        }

        function resetColor(){

            var span1=document.getElementById("first");
            var span2=document.getElementById("second");
            var span3=document.getElementById("third");
            var span4=document.getElementById("fourth");
            const spanArray = [span1, span2, span3, span4];
            for (let i=0; i<spanArray.length; i++){
                spanArray[i].style.backgroundColor = "white";

            }
        }






    }})

