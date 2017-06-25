function addInputboxListener() {
    $(":input[name=first_name]").on("blur", checkFirstNameBox);
    $(":input[name=last_name]").on("blur", checkLastNameBox);
    $(":input[name=email]").on("blur", checkEmailBox);
    $(":input[name=confirm_password]").on("blur", checkConfirmPasswordBox);
}

function checkFirstNameBox() {
    var first_name = $(":input[name=first_name]").val();
    if (first_name == "" || checkName(first_name)) {
        $("#invalid_first_name").css("visibility", "hidden");
    }
    else {
        $("#invalid_first_name").css("visibility", "visible");
    }
}

function checkLastNameBox() {
    var last_name= $(":input[name=last_name]").val();
    if (last_name == "" || checkName(last_name)) {
        $("#invalid_last_name").css("visibility", "hidden");
    }
    else {
        $("#invalid_last_name").css("visibility", "visible");
    }
}

function checkEmailBox() {
    var email = $(":input[name=email]").val();
    if (email == "" || checkEmail(email)) {
        $("#invalid_email").css("visibility", "hidden");
    }
    else {
        $("#invalid_email").css("visibility", "visible");
    }
}

function checkConfirmPasswordBox() {
    var confirm_password = $(":input[name=confirm_password]").val();
    var password = $(":input[name=password]").val();
    if (confirm_password == "" || confirm_password == password) {
        $("#password_dismatch").css("visibility", "hidden");
    }
    else {
        $("#password_dismatch").css("visibility", "visible");
    }
}



window.onload = function () {
    addInputboxListener();
}