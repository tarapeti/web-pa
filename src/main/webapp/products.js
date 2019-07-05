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
        document.getElementById('product-content').appendChild(generateTable(null, products ));
    } else {
        document.getElementById("product-table").remove();
        document.getElementById('product-content').appendChild(generateTable(null, products ));
    }
    showContents(['profile-content', 'topnav', 'product-content']);
}


function generateTable(table, products) {
    if (!table) table = document.createElement('table');

    table.setAttribute('id', "product-table");
    table.setAttribute('border', "1px");

    for (let i = 0; i < products.length; i++) {
        let product = products[i];
        let tableDEl = document.createElement('td');
        tableDEl.innerHTML = product.name;
        let tableREl = document.createElement('tr');
        tableREl.appendChild(tableDEl);
        table.appendChild(tableREl);
    }
    return table;

}

function onAllGripsClicked(){
    const params = new URLSearchParams();
    const typeId = 2;
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'product?' + params.toString());
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
    xhr.open('GET', 'product?' + params.toString());
    xhr.send();
}

function onAllWheelsClicked() {
    const params = new URLSearchParams();
    const typeId = 4;
    params.append('typeId', typeId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAllProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'product?' + params.toString());
    xhr.send();
}