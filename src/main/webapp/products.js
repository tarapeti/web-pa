function onAllProductsResponse() {
    if (this.status === OK) {
        let productDto = JSON.parse(this.responseText);
        let products = productDto.products;
        showTable(products);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }
}

function showTable(products) {
    let table = document.getElementById("product-table");
    if (table == null) {
        document.getElementById('product-content').appendChild(generateTable(table, products ));
    } else {
        table.remove();
        document.getElementById('product-content').appendChild(generateTable(table, products ));
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
        tableDEl.innerHTML = product.id;
        let tableREl = document.createElement('tr');
        tableREl.appendChild(tableDEl);
        table.appendChild(tableREl);
    }
    return table;

}