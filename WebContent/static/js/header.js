var BASE_PATH = '';
if (/\d+\.\d+\.\d+\.\d+/.test(location.host)) {
    BASE_PATH = location.protocol
            + '//'
            + location.host
            + location.pathname.substring(0, location.pathname.substring(1)
                    .indexOf('/') + 1);
} else {
    BASE_PATH = location.protocol + '//' + location.host;
}

$(function() {
    $(".nav-handler").mouseover(function() {
        $(this).find("a").css("color", "#03a9f4");
    });

    $(".nav-handler").mouseleave(function() {
        $(this).find("a").css("color", "#383838");
    });
})