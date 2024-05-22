const img = document.getElementById("img");
const formUpload = document.getElementById("upload");
const formDelete = document.getElementById("delete");

formUpload.addEventListener('submit', changePathUpload)


function changePathUpload(){
    img.src = "data:image/jpeg;base64,${immagine}";
}


function changePathDelete(){
    img.src = "profile.jpg";
}
