function checkUsername(){
    var username = document.getElementById("username");
    var wrapper = document.getElementById("usernameWrap");
    var section = document.getElementById("sec01")

    if(username.value.length < 5){
        wrapper.style.borderColor = "red"
        section.querySelector("span").innerText = "Username < 5"


    }
    else{
        wrapper.style.borderColor = "black"
        section.querySelector("span").innerText = ""

    }
}