function onAllProductsResponse() {
    if (this.status === OK) {
        console.log(JSON.parse(this.responseText));
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }

}