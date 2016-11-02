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

var comments = {};
function leaveAComment() {
    comments.product = $('#product').val();
    comments.comment = $('#comment').val();
    if ($('#rating1').prop('checked')) comments.stars = $('#rating1').val();
    if ($('#rating2').prop('checked')) comments.stars = $('#rating2').val();
    if ($('#rating3').prop('checked')) comments.stars = $('#rating3').val();
    if ($('#rating4').prop('checked')) comments.stars = $('#rating4').val();
    if ($('#rating5').prop('checked')) comments.stars = $('#rating5').val();

    $.ajax({
        url: "/newComment",
        type: "GET",
        data: comments,
        dataType: "html",

        success: function (data) {
            $('#comm').append(data);
        }
    })
}