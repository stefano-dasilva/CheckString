const form = document.getElementById('form');

form.addEventListener('submit', (e) =>{
    e.preventDefault();


    console.log('Submit da effettuare');
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    console.log("lo username è " + username)
    console.log(password)

    if (username === '') {
        document.getElementById("error_login_js").innerText = "Si prega di inserire l'username"
        return false;
    }
    else{
        document.getElementById("error_login_js").innerText = ""

    }

    if (password === '') {
        document.getElementById("error_login_js_pass").innerText = "Si prega di inserire la password"
        return false;
    }
    else{
        document.getElementById("error_login_js_pass").innerText = ""

    }
    document.getElementById('form').submit();



});

