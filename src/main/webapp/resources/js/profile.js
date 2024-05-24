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
