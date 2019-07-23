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
//gusztustalan és nemjo
function onCartClikcedResponse() {
    if (this.status === OK) {
        let emptyCart = document.createElement('p');
        emptyCart.setAttribute('id', 'empty');
        emptyCart.textContent = "The cart is emptpy";
        let coButton = document.getElementById("checkOutButton");
        try{//ha a json null, tehát a dto üres, szervleten is meg lehetett vona oldani kb
            if(document.getElementById('empty') == null){
                let json = JSON.parse(this.responseText);
                let cartItems = json.products;
                console.log(cartItems);
                displayCart(cartItems);
            }else{
                emptyCart.remove();
                coButton.remove();
            }
        }catch (e) {
            let empty = document.getElementById('empty');
            let table = document.getElementById("cart-table");
            if (table == null){
                if (empty == null){
                    document.getElementById('cart-display').appendChild(emptyCart);
                } else{
                    empty.remove();
                    coButton.remove();
                    document.getElementById('cart-display').appendChild(emptyCart);
                }
            }else{
                table.remove();
                coButton.remove();
            }
        }finally {
            showContents(['profile-content', 'topnav', 'cart-display']);

        }
    } else {
        alert("Some error occured, try again later");
    }

}

function displayCart(cartItems)  {
    let table = document.getElementById("cart-table");
    if (table == null) {
        document.getElementById('cart-display').appendChild(generateSimpleTable(null, cartItems));
    } else {
        table.remove();
        document.getElementById('cart-display').appendChild(generateSimpleTable(null, cartItems));
    }
    let checkOutButton = document.createElement('button');
    checkOutButton.setAttribute('id', 'checkOutButton')
    checkOutButton.addEventListener("click", function () {checkOut(cartItems)});
    checkOutButton.innerHTML = "Check out";
    document.getElementById('cart-display').appendChild(checkOutButton);
}


function generateSimpleTable(table, cartItems) {
    console.log(cartItems);
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

        let removeFromCartEl = document.createElement("button");
        removeFromCartEl.textContent = "Remove from cart";
        removeFromCartEl.addEventListener("click", function () {removeFromCart(product.id)});
        let buttonTEl = document.createElement('td');
        buttonTEl.appendChild(removeFromCartEl);
        //remove from cart

        priceTrEl.appendChild(price);
        tableREl.appendChild(name);
        table.appendChild(tableREl);
        table.appendChild(priceTrEl);
        table.appendChild(buttonTEl);

    }
    return table;

}

function removeFromCart(productId) {
    alert("item removed from cart");
    sessionStorage.removeItem(productId);
    showContents(['profile-content', 'topnav', 'cart-display']);
}

