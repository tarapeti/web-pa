function onAllProductsClicked() {
    const params = new URLSearchParams();
    const typeId = "all";
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'product?' + params.toString());
    xhr.send();
}


function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'topnav']);

}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}