document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Validación básica (puedes reemplazar con lógica real)
    if (username === "admin" && password === "1234") {
        window.location.href = "welcome.html";
    } else {
        document.getElementById("errorMessage").style.display = "block";
    }
});