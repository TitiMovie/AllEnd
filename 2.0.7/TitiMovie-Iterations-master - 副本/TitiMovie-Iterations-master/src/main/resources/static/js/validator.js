function checktel(tel) {
    return new RegExp("^[1-9][0-9]{10}$").test(tel);
}

function checkEmail(email) {
    return new RegExp("^[a-zA-Z_\-]+@(([0-9a-zA-Z_\-])+\.)+[a-zA-Z]{2,4}$").test(email);
}

function checkName(name) {
    return new RegExp("[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*").test(name);
}