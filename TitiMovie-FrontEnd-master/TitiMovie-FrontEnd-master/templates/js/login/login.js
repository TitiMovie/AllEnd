function addInputboxListener() {
    $(":input[name=email]").on("blur", checkEmailBox);
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

window.onload = function () {
    addInputboxListener();
}