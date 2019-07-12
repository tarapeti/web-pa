function putinCart(productId) {
    sessionStorage.setItem(productId, productId);
    putinCartResponse();
}

function putinCartResponse() {
    alert("Item put into cart");
    showContents(['profile-content', 'topnav', 'product-display']);
}

function onCartClikced(){
    const params = new URLSearchParams();
    const productIds = Object.keys(sessionStorage);
    params.append('productIds', productIds);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onCartClikcedResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'cart?' + params.toString());
    xhr.send();

}
function onCartClikcedResponse() {
    if (this.status === OK) {
        let cartItems = JSON.parse(this.responseText);
        console.log(cartItems);
        displayCart(cartItems);
        showContents(['profile-content', 'topnav', 'cart-display']);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }
}

function displayCart(cartItems)  {
    if (cartItems = null){
        let emptlyCart = document.createElement('p');
        emptlyCart.textContent = "The cart is emptpy";
        document.getElementById('cart-display').appendChild(emptlyCart);
    }else{
        let table = document.getElementById("cart-table");
        if (table == null) {
            document.getElementById('cart-display').appendChild(generateSimpleTable(null, cartItems));
        } else {
            table.remove();
            document.getElementById('cart-display').appendChild(generateSimpleTable(null, cartItems));
        }
        let checkOutButton = document.createElement('button');
        checkOutButton.addEventListener("click", function () {checkOut(cartItems)});
        checkOutButton.innerHTML = "Check out";
        document.getElementById('cart-display').appendChild(checkOutButton);
    }
}


function generateSimpleTable(table, cartItems) {
    if (!table) table = document.createElement('table');

    table.setAttribute('id', "cart-table");
    table.setAttribute('border', "1px");

    for (let i = 0; i < cartItems.length; i++) {
        let product = cartItems[i];
        let name = document.createElement('p');
        name.textContent = product.name;
        let tableREl = document.createElement('tr');

        let price = document.createElement('p');
        price.textContent = product.price;
        let priceTrEl = document.createElement('td');

        //remove from cart

        priceTrEl.appendChild(price);
        tableREl.appendChild(name);
        table.appendChild(tableREl);
        table.appendChild(priceTrEl);

    }
    return table;

}

