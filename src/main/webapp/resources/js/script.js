function alertWarning() {
    $('#alertWar').html('<div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><h4><strong>Warning!</strong> If You want to buy something, You have to be logged.</h4></div>')
}

var cartAdd = {};
function addToCart(element) {

    cartAdd.nameProduct = element.name;
    $.ajax({
        url: "/addToCart",
        type: "GET",
        data: cartAdd,
        dataType: 'json'
    })
}

var cartRemove = {};
var removeId;
function removeFromCart(element) {

    cartRemove.idProduct = element.name;
    removeId = element.name;
    $('#'+removeId).remove();

    $.ajax({
        url: "/removeItem",
        type: "GET",
        data: cartRemove,
        dataType: 'json'
    })
}

function countSubTotalProductPrice(element) {
    var numberOfProduct = element.value;
    var productPrice = element.name;
    var productId = element.id;
    var total = numberOfProduct*productPrice;
    $.ajax({
        success: function () {
            $('#priceDigit' + productId).remove();
            $('#productPrice' + productId).html('<strong id="priceDigit">$'+total+'</strong>')
        }
    })
}