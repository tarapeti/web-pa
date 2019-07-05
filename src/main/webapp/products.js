function onAllProductsResponse() {
    if (this.status === OK) {
        let productDto = JSON.parse(this.responseText);
        let products = productDto.products;
        showTable(products);
        showContents(['profile-content', 'topnav', 'product-content']);
        console.log(productDto.products);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }
}

function showTable(products) {
    let table = document.getElementById("product-table");
    if (table == null) {
        document.getElementById('product-content').appendChild(generateTable(null, products));
    } else {
        document.getElementById("product-table").remove();
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

        /*        let tableDEl = document.createElement('td');
                tableDEl.innerHTML = product.name;
                tableDEl.addEventListener("click", onProductClicked);*/
        let tableREl = document.createElement('tr');
        tableREl.appendChild(a);
        table.appendChild(tableREl);
    }
    return table;

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
        console.log(product);
        displayProduct(product);
        showContents(['profile-content', 'topnav', 'product-display']);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }

}

function displayProduct(product) {

    let productDisplayTable = document.createElement('table');
    productDisplayTable.setAttribute('id', "display-product-table");

    let title = document.createElement('th');
    title.appendChild(document.createTextNode(product.name));

    let brand = product.brand;
    let price = product.price;

    let brandTrEl = document.createElement('tr');
    let priceTrEl = document.createElement('tr');

    let brandTd = document.createElement('td');
    brandTd.innerHTML = brand;
    brandTrEl.appendChild(brandTd);

    let priceTd = document.createElement('td');
    priceTd.innerHTML = price;
    priceTrEl.appendChild(priceTd);

    productDisplayTable.appendChild(title);
    productDisplayTable.appendChild(brandTrEl);
    productDisplayTable.appendChild(priceTrEl);

    document.getElementById('product-display').appendChild(productDisplayTable);

}