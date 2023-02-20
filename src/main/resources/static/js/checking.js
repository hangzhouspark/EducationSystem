function checkInput(id) {
    var val = $("#" + id).val().trim();
    if (val != "") {
        if ($("#" + id + "Title")[0]) {
            $("#" + id + "Title").html("");
        }
        return true;
    } else {
        if ($("#" + id + "Title")[0]) {
            $("#" + id + "Title").html("不能为空").css("color", "red");
        } else {
            alert("不能为空");
        }
        return false;
    }
}