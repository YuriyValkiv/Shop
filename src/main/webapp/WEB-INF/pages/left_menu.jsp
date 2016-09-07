<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div class="col-md-3">
        <p class="lead">Categories:</p>
        <div class="list-group">
            <a href="/products" class="list-group-item <c:out value="${activeListItemOne}"/>">Smartphones</a>
            <a href="/products/?type=notebook" class="list-group-item <c:out value="${activeListItemTwo}"/>">Laptops</a>
        </div>
    </div>
</body>
</html>
