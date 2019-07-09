function putinCart(productId) {
    const params = new URLSearchParams();
    params.append('productId', productId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', putinCartResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'cart?' + params.toString());
    xhr.send();

}

function putinCartResponse() {
    if (this.status === OK) {
        alert("Item put into cart")
        showContents(['profile-content', 'topnav', 'product-display']);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }

}