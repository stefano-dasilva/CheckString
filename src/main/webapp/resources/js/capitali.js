import paesijson from '../countries.json' with { type: 'json' };

document.addEventListener('DOMContentLoaded', (event) => {
    var parte2 = document.getElementById("parte2");
    parte2.parentNode.removeChild(parte2);

    document.getElementById("iniziaBottone").addEventListener('click', inizia);
    var punteggio = 0;

    function inizia() {
        document.getElementById("container").appendChild(parte2);
        var parte1 = document.getElementById("parte1");
        parte1.parentNode.removeChild(parte1);
        fetchCountries();
    }

    async function aumentaPunti() {
        const response = await fetch("aumentapunti");
        return response.json();
    }

    var paese1;

    function fetchCountries() {
        fetch('randomcountry2')
            .then(response => response.json())
            .then(data => {
                paese1 = paesijson.find(paese => paese.cca2 === data.code1);
                var paese2 = paesijson.find(paese => paese.cca2 === data.code2);
                var paese3 = paesijson.find(paese => paese.cca2 === data.code3);
                var paese4 = paesijson.find(paese => paese.cca2 === data.code4);

                if (!paese1 || !paese2 || !paese3 || !paese4 || !paese1.capital || !paese2.capital || !paese3.capital || !paese4.capital) {
                    fetchCountries();
                    return;
                }

                var paeseIndovinato = paese1.name.common;
                var paese = document.getElementById("paese");
                paese.textContent = paeseIndovinato;

                var capitaleIndovinata = paese1.capital[0];

                // Assicurarsi che le capitali siano uniche
                var capitali = [...new Set([paese1.capital[0], paese2.capital[0], paese3.capital[0], paese4.capital[0]])];

                if (capitali.length < 4) {
                    fetchCountries();
                    return;
                }

                // Assegna le capitali casualmente agli elementi
                var first = document.getElementById("first");
                var second = document.getElementById("second");
                var third = document.getElementById("third");
                var fourth = document.getElementById("fourth");

                const randomIdx1 = Math.floor(Math.random() * capitali.length);
                first.textContent = capitali[randomIdx1];
                capitali.splice(randomIdx1, 1);

                const randomIdx2 = Math.floor(Math.random() * capitali.length);
                second.textContent = capitali[randomIdx2];
                capitali.splice(randomIdx2, 1);

                const randomIdx3 = Math.floor(Math.random() * capitali.length);
                third.textContent = capitali[randomIdx3];
                capitali.splice(randomIdx3, 1);

                fourth.textContent = capitali[0];

                var img = document.getElementById("img");
                img.src = paese1.flags.png;

                first.replaceWith(first.cloneNode(true));
                second.replaceWith(second.cloneNode(true));
                third.replaceWith(third.cloneNode(true));
                fourth.replaceWith(fourth.cloneNode(true));

                first = document.getElementById("first");
                second = document.getElementById("second");
                third = document.getElementById("third");
                fourth = document.getElementById("fourth");

                first.addEventListener("click", () => verifica(first, capitaleIndovinata));
                second.addEventListener("click", () => verifica(second, capitaleIndovinata));
                third.addEventListener("click", () => verifica(third, capitaleIndovinata));
                fourth.addEventListener("click", () => verifica(fourth, capitaleIndovinata));

                document.getElementById("punti").innerText = punteggio;
                resetColor();
            });
    }

    async function verifica(capitaleSelezionata, capitaleCorretta) {
        console.log("Capitale Selezionata:", capitaleSelezionata.textContent);
        console.log("Capitale Corretta:", capitaleCorretta);

        if (capitaleSelezionata.textContent === capitaleCorretta) {
            console.log("Risposta corretta");
            capitaleSelezionata.style.backgroundColor = "green";

            punteggio++;
            const risposta = await aumentaPunti();
            console.log(risposta);
            document.getElementById("punti").innerText = punteggio;
            var message = document.getElementById("rispostaCorretta");
            message.style.display = "inline-flex";
            setTimeout(function () {
                message.style.display = "none";
                fetchCountries();
            }, 1000);
        } else {

            fetch("finiscigioco?gioco=giocoCapitali")
                .then(response => response.json())
                .then((data) => {


                    console.log(data)
                    console.log(data.punteggio)
                    console.log(data.nuovo_record)

                    console.log("Risposta sbagliata");
                    var message1 = document.getElementById("rispostaSbagliata");
                    var right = document.getElementById("right").innerText = " " + paese1.capital;
                    message1.style.display = "inline-flex";
                    setTimeout(function () {
                        message1.style.display = "none";
                        parte2.parentNode.removeChild(parte2);
                    }, 2000);

                    setTimeout(function () {
                        var finale = document.getElementById("cont4");
                        var puntiFinali = document.getElementById("punteggioFinale").innerText =data.punteggio;
                        document.getElementById("container").appendChild(finale);
                        finale.style.display = "inline-flex";
                        punteggio = 0;
                    }, 2000);

                })


        }

    }

    function resetColor() {
        var span1 = document.getElementById("first");
        var span2 = document.getElementById("second");
        var span3 = document.getElementById("third");
        var span4 = document.getElementById("fourth");
        const spanArray = [span1, span2, span3, span4];
        for (let i = 0; i < spanArray.length; i++) {
            spanArray[i].style.backgroundColor = "white";
        }
    }
});
