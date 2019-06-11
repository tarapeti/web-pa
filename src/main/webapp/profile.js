function onAllProductsClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'product');
    xhr.send();
}


function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'topnav']);

}