fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username: 'admin', password: '123' })
})
.then(response => response.json())
.then(data => {
    if (data.success) {
        alert('Login exitoso');
    } else {
        alert('Credenciales incorrectas');
    }
});
