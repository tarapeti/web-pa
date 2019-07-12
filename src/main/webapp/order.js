function checkOut(cartItems) {
        const params = new URLSearchParams();
        const productIds = Object.keys(sessionStorage);
        params.append('productIds', productIds);

        const xhr = new XMLHttpRequest();
        xhr.addEventListener('load', onCheckoutResponse);
        xhr.addEventListener('error', onNetworkError);
        xhr.open('POST', 'order?' + params.toString());
        xhr.send();
}

function onCheckoutResponse() {
    if (this.status === OK) {
        sessionStorage.clear();
        alert('Items checked out');
        showContents(['profile-content', 'topnav', 'product-content']);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }
}