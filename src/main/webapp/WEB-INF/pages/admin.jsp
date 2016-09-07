<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin database</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/shop-homepage.css" rel="stylesheet">

</head>
<body>

    <!-- Navigation -->
    <jsp:include page="header.jsp"/>

    <div class="container">

        <div class="row">

            <jsp:include page="left_menu.jsp"/>

            <!-- Content -->

            <form class="form-horizontal" action="/admin/add" method="post" enctype="multipart/form-data">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add lot to database</legend>

                    <!-- Name -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="name">Lot name</label>
                        <div class="col-md-4">
                            <input id="name" name="name" placeholder="name" class="form-control input-md" type="text">

                        </div>
                    </div>

                    <!-- Type -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="type">Lot type</label>
                        <div class="col-md-4">
                            <select id="type" name="type" class="form-control input-md">
                                <option>smartphone</option>
                                <option>notebook</option>
                            </select>

                        </div>
                    </div>

                    <!-- Country -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="country">Lot country</label>
                        <div class="col-md-4">
                            <input id="country" name="country" class="form-control input-md" placeholder="country" type="text">

                        </div>
                    </div>

                    <!-- Prcie-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="price">Lot price</label>
                        <div class="col-md-4">
                            <input id="price" name="price" placeholder="price in double" class="form-control input-md" type="text">

                        </div>
                    </div>

                    <!-- Description -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="description">Lot description</label>
                        <div class="col-md-4">
                            <textarea class="form-control" id="description" name="description">Short text</textarea>
                        </div>
                    </div>

                    <!-- Description big -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="descriptionBig">Lot description big</label>
                        <div class="col-md-4">
                            <textarea class="form-control" id="descriptionBig" name="descriptionBig">Big description</textarea>
                        </div>
                    </div>

                    <!-- Image big -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="imageBig">Lot image (800x300)</label>
                        <div class="col-md-4">
                            <input id="imageBig" name="imageBig" class="input-file" type="file">
                        </div>
                    </div>

                    <!-- Image -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="image">Lot image (320x150)</label>
                        <div class="col-md-4">
                            <input id="image" name="image" class="input-file" type="file">
                        </div>
                    </div>

                    <!-- Submit -->
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <input type="submit" name="Submit" class="btn btn-primary"/>
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
    </div>
    <!-- Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>
