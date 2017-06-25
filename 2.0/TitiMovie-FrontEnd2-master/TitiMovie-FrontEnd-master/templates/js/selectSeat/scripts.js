(function() {
    "use strict";

    // custom scrollbar

    $("html").niceScroll({styler:"fb",cursorcolor:"#000", cursorwidth: '4', cursorborderradius: '10px', background: '#ccc', spacebarenabled:false, cursorborder: '0',  zindex: '1000'});

    $(".scrollbar1").niceScroll({styler:"fb",cursorcolor:"#000", cursorwidth: '4', cursorborderradius: '0',autohidemode: 'false', background: '#ccc', spacebarenabled:false, cursorborder: '0'});

	
	
    $(".scrollbar1").getNiceScroll();
    if ($('body').hasClass('scrollbar1-collapsed')) {
        $(".scrollbar1").getNiceScroll().hide();
    }

})(jQuery);

function findAndDelete(selectedList, seat) {
    for (i = 0; i < selectedList.length; i++) {
        if (selectedList[i].row == seat.row)
            if (selectedList[i].col == seat.col)
                selectedList.splice(i, 1)
    }

}

function proceed() {
    if (selectedList.length > 0) {
        $.ajax({
            url: window.location.href,
            method: 'POST',
            data: {
                show_id: show_id,
                selectedList_JSON: JSON.stringify(selectedList)
            },
            success: function (data) {
                if (data == "succeed") {
                    window.location.href = '/payment'
                }
                else {
                    if (data == "SeatChosenError") {
                        $("#errorMessage").text("Some of chosen seats have been booked just now");
                        nextURL = null;
                    }
                    else if (data == "LoginError") {
                        $("#errorMessage").text("Please login before booking");
                        nextURL = '/login';
                    }
                    $("#seat_taken").modal('show');
                }
            }
        });
    }
    else {
        $("#no_selected").modal("show");
    }
}