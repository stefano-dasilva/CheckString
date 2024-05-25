import paesijson from '../countries.json' with { type: 'json' };

document.addEventListener('DOMContentLoaded', (event) => {
    var parte2 = document.getElementById("parte2");
    parte2.parentNode.removeChild(parte2);

    document.getElementById("iniziaBottone").addEventListener('click', inizia);

    function inizia(){
        document.getElementById("container").appendChild(parte2);
        var parte1=document.getElementById("parte1");
        parte1.parentNode.removeChild(parte1);


        var standard;



        fetch('randomcountry2')
            .then(response => response.json())
            .then(data => {
                    var paese1 = paesijson.find(paese => paese.cca2 === data.code1 )
                    var paese2 = paesijson.find(paese => paese.cca2 === data.code2 )
                    var paese3 = paesijson.find(paese => paese.cca3 === data.code3 )
                    var paese4 = paesijson.find(paese => paese.cca4 === data.code4 )
                    img.src = paese1.flags.png

                    var paeseIndovinato=paese1.name.common;
                    var paese=document.getElementById("paese");
                    paese.textContent=paeseIndovinato;
                    var first=document.getElementById("first");
                    var second=document.getElementById("second");
                    var third=document.getElementById("third");
                    var fourth=document.getElementById("fourth");

                    var paese1Cap=paese1.capital;
                    var paese2Cap=paese2.capital;
                    var paese3Cap=paese3.capital;
                    var paese4Cap=paese4.capital;

                    first.textContent=paese1Cap;
                    second.textContent=paese2Cap;
                    third.textContent=paese3Cap;
                    fourth.textContent=paese4Cap;








                standard = data
                console.log(paese1)
                console.log(paese2)
                console.log(paese3)
                console.log(paese4)
                console.log(data)
                console.log(paese)

                }
            )
    }
});
