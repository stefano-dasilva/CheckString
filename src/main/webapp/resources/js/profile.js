document.addEventListener('DOMContentLoaded', function() {
    const editButton = document.getElementById('editButton');
    const saveButton = document.getElementById('saveButton');
    const formFields = document.querySelectorAll('#formDati input');

    editButton.addEventListener('click', function() {
        formFields.forEach(field => {
            field.removeAttribute('readonly');
        });
        editButton.classList.add('d-none');
        saveButton.classList.remove('d-none');
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const fileInput = document.getElementById('file');
    const saveButton = document.getElementById('salva');
    const fotolabel = document.getElementById('fotolabel');

    // Nascondi il pulsante Salva inizialmente
   saveButton.style.display = 'none';
    //saveButton.classList.add('d-none');

    // Quando il file input cambia (file selezionato), mostra il pulsante Salva e nascondi Carica
    fileInput.addEventListener('change', function() {
       if (fileInput.files.length > 0) {
            fotolabel.style.display = 'none';
            saveButton.style.display = 'inline';
        } else {
            fotolabel.style.display = 'inline';
            saveButton.style.display = 'none';
        }
      /*  if (fileInput.files.length > 0) {
            // Mostra il pulsante Salva
            saveButton.classList.remove('d-none');
            // Nascondi il pulsante Carica (label)
            fotolabel.classList.add('d-none');
        } else {
            // Nascondi di nuovo il pulsante Salva se non c'è nessun file
            saveButton.classList.add('d-none');
            // Mostra il pulsante Carica (label)
            fotolabel.classList.remove('d-none');
        }*/
    });
});
