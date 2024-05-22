const img = document.getElementById("img");
const formUpload = document.getElementById("upload");


formUpload.addEventListener('submit', changePathUpload)


function changePathUpload(){
    img.src = "data:image/jpeg;base64,${immagine}";
}



