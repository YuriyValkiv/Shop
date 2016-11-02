<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyShop | <c:out value="${nameTitle}"/></title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/shop-item.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <jsp:include page="header.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <jsp:include page="left_menu.jsp"/>

            <div class="col-md-9">
                <c:forEach var="product" items="${product}">
                    <div class="thumbnail">
                        <img class="img-responsive" src="${product.imageBig}" alt="">
                        <div class="caption-full">
                            <h4 class="pull-right">\$${product.price}</h4>
                            <h4>${product.name}</h4>
                            <p>${product.descriptionBig}</p>
                        </div>
                        <div class="ratings">
                            <p class="pull-right">3 reviews</p>
                            <p>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star-empty"></span>
                                4.0 stars
                            </p>
                        </div>
                    </div>
                </c:forEach>

                <!-- Comments Form -->
                <div class="well">
                    <h4>Comment:</h4>
                    <form role="form">
                        <div class="form-group">
                            <textarea class="form-control" rows="3" name="comment" id="comment"></textarea>
                        </div>
                        <input type="hidden" name="product" id="product" value="<c:out value="${lotName}"/>">
                        <div class="form-group">
                            <span class="starRating">
                                <input id="rating5" type="radio" name="rating" value="5">
                                <label for="rating5">5</label>
                                <input id="rating4" type="radio" name="rating" value="4">
                                <label for="rating4">4</label>
                                <input id="rating3" type="radio" name="rating" value="3" checked>
                                <label for="rating3">3</label>
                                <input id="rating2" type="radio" name="rating" value="2">
                                <label for="rating2">2</label>
                                <input id="rating1" type="radio" name="rating" value="1">
                                <label for="rating1">1</label>
                            </span>
                        </div>

                    </form>
                    <button class="btn btn-primary" onclick="leaveAComment()">Leave a Comment</button>
                </div>

                <div class="well" id="commentsBlock">
                    <div id="comm">

                        <div class="text-right">
                            <a class="btn btn-success" href="/products">Leave a Review</a>
                        </div>

                        <c:forEach var="comments" items="${commentsList}">
                            <hr>
                            <div class="row">
                                <div class="col-md-12">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <c:choose>
                                        <c:when test="${comments.stars == 1}">
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </c:when>
                                        <c:when test="${comments.stars == 2}">
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </c:when>
                                        <c:when test="${comments.stars == 3}">
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </c:when>
                                        <c:when test="${comments.stars == 4}">
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </c:when>
                                        <c:when test="${comments.stars == 5}">
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                            <span class="glyphicon glyphicon-star"></span>
                                        </c:when>
                                    </c:choose>
                                    ${comments.author}
                                    <span class="pull-right">${comments.date}</span>
                                    <p>${comments.comment}</p>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>

        </div>

    </div>

    <jsp:include page="footer.jsp"/>

    <!-- jQuery -->
    <script src="/resources/js/jquery.js"></script>

    <script src="/resources/js/script.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>

</body>

</html>
