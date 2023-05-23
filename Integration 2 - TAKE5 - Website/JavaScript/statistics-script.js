document.addEventListener("DOMContentLoaded", function () {
    var loginForm = document.querySelector(".login-form");
    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        var username = document.getElementById("username-field").value;
        var password = document.getElementById("password-field").value;

        if (username !== "lais" || password !== "lais1410") {
            alert("Invalid username or password. Please try again.");
            setTimeout(function () {
                document.getElementById("username-field").focus();
            }, 0);
        } else {
            window.location.href = "../HTML/statistics-landing.html";
        }

        loginForm.reset();
    });
});