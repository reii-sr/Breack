document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevenir el envío normal del formulario

    // Obtener los valores del formulario
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Crear el objeto de datos para enviar al backend
    const data = {
        username: username,
        password: password
    };

    // Enviar los datos al servidor usando fetch
    fetch('/login', {
        method: 'POST', // Método HTTP
        headers: {
            'Content-Type': 'application/json' // Especificar que estamos enviando JSON
        },
        body: JSON.stringify(data) // Convertir el objeto data a JSON
    })
    .then(response => response.json()) // Convertir la respuesta a JSON
    .then(data => {
        if (data.message === "Login exitoso") {
            // Si la respuesta es exitosa, redirigir al usuario a la página de bienvenida
            window.location.href = 'welcome.html';
        } else {
            // Si las credenciales son incorrectas, mostrar mensaje de error
            document.getElementById('errorMessage').style.display = 'block';
        }
    })
    .catch(error => {
        console.error('Error al enviar la solicitud:', error);
    });
});
