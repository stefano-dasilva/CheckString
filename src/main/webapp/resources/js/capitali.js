
import paesijson from '../countries.json' with { type: 'json' };


document.addEventListener('DOMContentLoaded', (event) => {
    var parte2 = document.getElementById("parte2");
    parte2.parentNode.removeChild(parte2);

    document.getElementById("iniziaBottone").addEventListener('click', inizia);

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

                first.addEventListener("click", () => verifica(first.textContent, paese1.capital));
                second.addEventListener("click", () => verifica(second.textContent, paese1.capital));
                third.addEventListener("click", () => verifica(third.textContent, paese1.capital));
                fourth.addEventListener("click", () => verifica(fourth.textContent, paese1.capital));
            })

        function verifica(param1, param2) {
            console.log("Parametro 1:", param1);
            console.log("Parametro 2:", param2);

            if (param1 === param2[0]) {
                console.log("Risposta corretta");

                fetchCountries();
            } else {
                console.log("Risposta sbagliata");


            }
        }



    }})

