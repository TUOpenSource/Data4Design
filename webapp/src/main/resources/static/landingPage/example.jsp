<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">



<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Home
                    </a>
                </li>
                <li>
                    <a href="#">Dashboard</a>
                </li>
              
                <li>
                <div class="checkbox">
                    <label><input type="checkbox" value="">Rainfall</label>
                </div>
                </li>
                
                <li>
                    <div class="checkbox">
                    <label><input type="checkbox" value="">Electrification</label>
                </div>
                </li>
                
                <li><div class="checkbox">
                    <label><input type="checkbox" value="">Cell Phone Usage</label>
                </div>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <h1>Bolivia</h1>
                <img id = "header-img" src = "bolivia.jpg">
                <p>A country of statistical extremes, landlocked Bolivia is the highest and most isolated country in South America. It has the
                largest proportion of indigenous people, who make up around two-thirds of the population.</p>
                <p>Though rich in mineral and energy resources, Bolivia is one of South America's poorest countries. Wealthy urban elites, who
                are mostly of Spanish ancestry, have traditionally dominated political and economic life, whereas most Bolivians
                are low-income subsistence farmers, miners, small traders or artisans.</p>
                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>

                

            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>
