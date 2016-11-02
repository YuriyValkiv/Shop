<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyShop | Products</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/shop-homepage.css" rel="stylesheet">
    <link href="/resources/css/styles.css" rel="stylesheet">

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

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="<c:out value="${bigImageOne}"/>" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="<c:out value="${bigImageTwo}"/>" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="<c:out value="${bigImageThree}"/>" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <div class="row">

                    <!--Products-->

                    <c:forEach var="product" items="${products}">
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="${product.image}" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">$${product.price}</h4>
                                    <h4><a href="/item?name=${product.name}">${product.name}</a>
                                    </h4>
                                    <p>${product.description}</p>
                                </div>
                                <div class="ratings">
                                    <p class="pull-right">15 reviews</p>
                                    <p>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                    </p>
                                </div>
                                <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                                    <a tabindex="0" id="popOver" name="${product.name}" onclick="addToCart(this)" class="btn btn-success" role="button" data-toggle="popover" data-trigger="focus" data-content="Added">Add to cart</a>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                                    <a href="#"><button class="btn btn-success" id="addToCart" onclick="alertWarning()">Add to cart</button></a>
                                </sec:authorize>
                            </div>
                        </div>
                    </c:forEach>

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <!-- Footer -->
        <jsp:include page="footer.jsp"/>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>

    <script src="/resources/js/script.js"></script>

    <script>
        $(document).ready(function(){
            $('[data-toggle="popover"]').popover();
        });
    </script>

</body>

</html>
