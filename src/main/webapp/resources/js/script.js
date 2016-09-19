function alertWarning() {
    $('#alertWar').html('<div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><h4><strong>Warning!</strong> If You want to buy something, You have to be logged.</h4></div>')
}

var cartAdd = {};
function addToCart(element) {

    cartAdd.nameProduct = element.name;
    $.ajax({
        url: "/addToCart",
        type: "GET",
        data: cartAdd
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
        data: cartRemove
    })
}

function countSubTotalProductPrice(element) {
    var numberOfProduct = element.value;
    var productPrice = element.name;
    var productId = element.id;
    var productOldTotalPrice = $('#priceDigit' + productId).text();
    var total = numberOfProduct*productPrice;
    var priceTotal = $('#total').text();
    priceTotal -= productOldTotalPrice;
    priceTotal += total;
    var price = priceTotal.toFixed(2);
    var subtotal = price - 6.94;
    subtotal = subtotal.toFixed(2);
    $('#subtotal').remove();
    $('#subtotalA').html('<strong>$</strong><strong id="subtotal">'+subtotal+'</strong>')
    $('#total').remove();
    $('#totalA').html('<strong>$</strong><strong id="total">'+price+'</strong>');
    $('#priceDigit' + productId).remove();
    $('#productPrice' + productId).html('<strong>$</strong><strong id="priceDigit'+productId+'">'+total+'</strong>');
}