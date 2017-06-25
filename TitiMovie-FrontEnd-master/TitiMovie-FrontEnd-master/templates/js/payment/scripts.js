function proceed() {
    $.ajax({
        type: 'POST',
        url: "/payment",
        data: {
            email:$("input[name=email]").val(),
            phone:$("input[name=phone]").val(),
            card_number:$("input[name=card_number]").val(),
            cvv:$("input[name=cvv]").val(),
            card_holder_name:$("input[name=card_holder_name]").val(),
            valid_thru:$("input[name=valid_thru]").val()
        },
        success: function (data) {
            if (data == "succeed")
                $("#succeed").modal('show');
            else {
                $("#error_text").text(data);
                $("#failure").modal('show');
            }

        }
    });
}