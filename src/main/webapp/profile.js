function onAllProductsClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllDecksResponse);
    xhr.addEventListener('error', onNetworkError);
    const params = new URLSearchParams();
    xhr.open('GET', 'product');
    xhr.send();
}


function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'topnav']);

}