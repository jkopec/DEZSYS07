window.onpageshow = function(evt) {
    // If persisted then it is in the page cache, force a reload of the page.
    if (evt.persisted) {
        document.body.style.display = "none";
        location.reload();
    }
};

function iknowGet() {
    window.location.href = "/iknow/get";
}
function iknowPost() {
    window.location.href = "/iknow/post";
}
function iknowPut() {
    window.location.href = "/iknow/put";
}
function iknowDelete() {
    window.location.href = "/iknow/delete";
}
