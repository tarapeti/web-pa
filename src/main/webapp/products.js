function onAllProductsResponse() {
    if (this.status === OK) {
        let json = JSON.parse(this.responseText);
        console.log(json);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }

}