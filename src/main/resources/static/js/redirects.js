$(function(){
	$('#suchbegriff').focus().val($("#suchbegriff").val());
});

window.onpageshow = function(evt) {
    // If persisted then it is in the page cache, force a reload of the page.
    if (evt.persisted) {
        document.body.style.display = "none";
        location.reload();
    }
};

function iknow() {
    window.location.href = "/iknow";
}
function edit() {
    window.location.href = "/iknow/edit";
}

function removeRecord(id) {
    $.ajax({
        url: "/data/" + id,
        contentType: "application/json",
        processData: false,
        type: 'DELETE',
        success: function (data) {
            alert('Deleted data successfully!');
            $("#" + id).hide();
        },
        error: function (data) {
            alert('Data not deleted: '  + data.responseJSON.message);
        }
    });
}