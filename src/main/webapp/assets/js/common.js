function  search(e) {
    const criteria = document.getElementById("search-criteria").value;
    const content = document.getElementById("search-content").value;
    window.location.href = e.value+"&queryCondition=q("+criteria+")p"+"&queryValue="+content;

}
function refresh(e) {
    window.location.href=e.value;
}
