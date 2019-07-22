function onAllProductsResponse() {
    if (this.status === OK) {
        let productDto = JSON.parse(this.responseText);
        let products = productDto.products;
        showTable(products);
        showContents(['profile-content', 'topnav', 'product-content']);
    } else {
        alert("Some error occured try again")
    }
}

function showTable(products) {
    let table = document.getElementById("product-table");
    if (table == null) {
        document.getElementById('product-content').appendChild(generateTable(null, products));
    } else {
        table.remove();
        document.getElementById('product-content').appendChild(generateTable(null, products));
    }
    showContents(['profile-content', 'topnav', 'product-content']);
}


function generateTable(table, products) {
    if (!table) table = document.createElement('table');

    table.setAttribute('id', "product-table");
    table.setAttribute('border', "1px");

    for (let i = 0; i < products.length; i++) {
        localStorage.removeItem("productId");
        let product = products[i];
        let a = document.createElement('a');
        a.href = 'javascript:void(0);';
        a.addEventListener("click", function () {
            onProductClicked(product.id)
        });
        a.textContent = product.name;
        let tableREl = document.createElement('tr');
        tableREl.appendChild(a);
        table.appendChild(tableREl);

    }
    return table;

}

function onSignaturesClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onSignaturesResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'signature?');
    xhr.send();

}

function onSignaturesResponse() {
    if (this.status === OK) {
        let signaturesDto = JSON.parse(this.responseText);
        isTableNeeded(signaturesDto.allNames);
    } else {
        alert("Some error occured try again");
    }

}

function isTableNeeded(signatures) {
    let table = document.getElementById("signature-table");
    if (table == null) {
        document.getElementById('signature-display').appendChild(showSignatures(null, signatures));
    } else {
        table.remove();
        document.getElementById('signature-display').appendChild(showSignatures(null, signatures));
    }
    showContents(['signature-display', 'topnav', 'profile-content']);

}

function showSignatures(table, signatures) {

    if (!table) table = document.createElement('table');

    table.setAttribute('id', "signature-table");
    table.setAttribute('border', "1px");

    let tableREl = document.createElement('tr');

    for (let i = 0; i < signatures.length; i++) {
        let signature = signatures[i];
        let tableDEl = document.createElement('td');
        for (let j = 0; j < signature.length ; j++) {
            let p = document.createElement('p');
            p.textContent = signature[j];
            tableDEl.appendChild(p);
        }
        tableREl.appendChild(tableDEl);
        table.appendChild(tableREl);

    }
    return table;
}

function onAscendingOrderClicked() {
    const params = new URLSearchParams();
    const ordering = "asc";
    params.append('ordering', ordering);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', OnOrderingResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'products?' + params.toString());
    xhr.send();
}

function onDescendingOrederClicked() {
    const params = new URLSearchParams();
    const ordering = "desc";
    params.append('ordering', ordering);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', OnOrderingResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'products?' + params.toString());
    xhr.send();
}

function OnOrderingResponse() {
    if (this.status === OK) {
        let products = (JSON.parse(this.responseText));
        showTable(products);
        showContents(['profile-content', 'topnav', 'product-content']);
    } else {
        alert("Some error occured try again");
    }
}

function onAllProductsClicked() {
    const params = new URLSearchParams();
    const typeId = "all";
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'products?' + params.toString());
    xhr.send();
}

function onProductClicked(productId) {

    const params = new URLSearchParams();
    params.append('productId', productId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onProductResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'product?' + params.toString());
    xhr.send();

}

function onAllGripsClicked() {
    const params = new URLSearchParams();
    const typeId = 2;
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'products?' + params.toString());
    xhr.send();
}

function onAllDecksClicked() {
    const params = new URLSearchParams();
    const typeId = 1;
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'product?' + params.toString());
    xhr.send();
}

function onAllTrucksClicked() {
    const params = new URLSearchParams();
    const typeId = 3;
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'products?' + params.toString());
    xhr.send();
}

function onAllWheelsClicked() {
    const params = new URLSearchParams();
    const typeId = 4;
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'products?' + params.toString());
    xhr.send();
}

function onProductResponse() {
    if (this.status === OK) {
        let product = JSON.parse(this.responseText);
        showProductDetails(product);
        showContents(['profile-content', 'topnav', 'product-display']);
    } else {
        alert("Some error occured try again");
    }

}

function showProductDetails(product) {
    let table = document.getElementById("display-product-table");
    if (table == null) {
        document.getElementById('product-display').appendChild(displayProduct(null, product));
    } else {
        table.remove();
        document.getElementById('product-display').appendChild(displayProduct(null, product));
    }

}

function displayProduct(table, product) {

    if (!table) table = document.createElement('table');

    let productDisplayTable = document.createElement('table');
    productDisplayTable.setAttribute('id', "display-product-table");

    let title = document.createElement('th');
    title.appendChild(document.createTextNode(product.name));

    let brand = product.brand;
    let price = product.price;

    let brandTrEl = document.createElement('tr');
    let priceTrEl = document.createElement('tr');
    let buyTrEl = document.createElement('tr');
    let gobackTrEl = document.createElement('tr');

    let brandTd = document.createElement('td');
    brandTd.innerHTML = brand;
    brandTrEl.appendChild(brandTd);

    let priceTd = document.createElement('td');
    priceTd.innerHTML = price;
    priceTrEl.appendChild(priceTd);

    var buy = document.createElement('button');
    buy.innerHTML = "Buy!"
    buy.onclick = function (){putinCart(product.id)};
    buyTrEl.appendChild(buy);

    var goback = document.createElement('button');
    goback.innerHTML = "Back to all products"
    goback.onclick = onAllProductsClicked;
    gobackTrEl.appendChild(goback);

    productDisplayTable.appendChild(title);
    productDisplayTable.appendChild(brandTrEl);
    productDisplayTable.appendChild(priceTrEl);
    productDisplayTable.appendChild(buyTrEl);
    productDisplayTable.appendChild(gobackTrEl);

    document.getElementById('product-display').appendChild(productDisplayTable);

    return productDisplayTable;

}