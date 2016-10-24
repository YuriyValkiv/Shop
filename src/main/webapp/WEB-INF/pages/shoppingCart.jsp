<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valkiv
  Date: 8/25/16
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShoppingCart</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/resources/css/shop-homepage.css" rel="stylesheet">
</head>
<body>

<!-- Navigation -->
<jsp:include page="header.jsp"/>

<div class="container">

    <div class="row cartTable">

        <h3><strong><c:out value="${message}"/></strong></h3>
            <table class="table table-hover" style="display: <c:out value="${block}"/>">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th class="text-center">Price</th>
                    <th class="text-center">Total</th>
                    <th> </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${carts}">
                    <tr id="${product.id}">
                        <td class="col-sm-8 col-md-6">
                            <div class="media">
                                <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${product.image}" style="width: 72px; height: 33px;"> </a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="#">${product.name}</a></h4>
                                    <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                                </div>
                            </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                            <input type="number" class="form-control text-center" min="1" name="${product.price}" id="${product.id}" autocomplete="off" onchange="countSubTotalProductPrice(this)" value="1">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>\$${product.price}</strong></td>
                        <td id="productPrice${product.id}" class="col-sm-1 col-md-1 text-center"><strong>$</strong><strong id="priceDigit${product.id}">${product.price}</strong></td>
                        <td class="col-sm-1 col-md-1">
                            <button type="button" name="${product.id}" onclick="removeFromCart(this)" class="btn btn-danger">
                                <span class="glyphicon glyphicon-remove"></span> Remove
                            </button></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td>   </td>
                    <td>   </td>
                    <td>   </td>
                    <td><h5>Subtotal</h5></td>
                    <td class="text-right"><h5 id="subtotalA"><strong id="subtotal">$<c:out value="${subTotal}"/></strong></h5></td>
                </tr>
                <tr>
                    <td>   </td>
                    <td>   </td>
                    <td>   </td>
                    <td><h5>Estimated shipping</h5></td>
                    <td class="text-right" id="estimatedShipping"><h5><strong>$6.94</strong></h5></td>
                </tr>
                <tr>
                    <td>   </td>
                    <td>   </td>
                    <td>   </td>
                    <td><h3>Total</h3></td>
                    <td class="text-right"><h3 id="totalA"><strong>$</strong><strong id="total"><c:out value="${total}"/></strong></h3></td>
                </tr>
                <tr>
                    <td>   </td>
                    <td>   </td>
                    <td>   </td>
                    <td>
                        <a href="/products"><button type="button" class="btn btn-default">
                             <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></a></td>
                    <td id="checkOUT">
                        <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></td>
                </tr>
                </tbody>
            </table>

    </div>
</div>

    <!-- jQuery -->
    <script src="/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>

    <script src="/resources/js/script.js"></script>

</body>
</html>
