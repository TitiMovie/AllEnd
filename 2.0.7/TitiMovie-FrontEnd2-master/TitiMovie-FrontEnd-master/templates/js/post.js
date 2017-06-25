function post(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";
    for (var x in PARAMS) {
        var opt = document.createElement("textarea");
        opt.name = x;
        opt.value = PARAMS[x];
        // alert(opt.name)
        temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}

function ajaxPost(URL, PARAMS, CALLBACK) {
    var data = new FormData();
    for (var key in PARAMS) {
        data.append(key, PARAMS[key]);
    }

    var xhr = new XMLHttpRequest();
    xhr.open('POST', URL, true);
    xhr.onload = function (data) {
        CALLBACK();
    };
    xhr.send(data);
}