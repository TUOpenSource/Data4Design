<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <script src="/js/node_modules/jquery/dist/jquery.min.js"></script>
    <script src="/js/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <!--<link href="/js/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />-->
    <link rel="icon" href="../../../../favicon.ico">


    <!-- Custom styles for this template -->
    <link href="/css/startbootstrap-portfolio-item-gh-pages/css/portfolio-item.css" rel="stylesheet"> 

    <!-- Bootswatch for color -->
    <link href="/js/node_modules/bootswatch/dist/yeti/bootstrap.min.css" rel="stylesheet">
    
    <title>HHCD - ${country_name}</title>

    
    
  </head>
  <body class="">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Data 4 Design</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="http://localhost:8080">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <!-- Country Name -->
      <h1 class="my-4">${country_name}
      </h1>

      <!-- Item Row -->
      <div class="row">
        <!-- Country Map -->
        <div class="col-md-8">
          <img class="img-fluid" src= "${pageContext.request.contextPath}${map}" alt="">
        </div>
        <!-- Country Description -->
        <div class="col-md-4">
          <h3 class="my-3">Country Description</h3>
          <p>${country_description}</p>
          <h3 class="my-3">Supplementary Details</h3>
          <ul>
            <li>ISO 2 Code: ${country_code}</li>
            <li>ISO 3 Code: ${country_code_3}</li>
          </ul>
        </div>

      </div>
      <!-- /.row -->

      <!-- Statisitacal Information -->
      <h3 class="my-4">Data:</h3>
      <!-- First Data Row -->
      <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
            <div id ="population-card" class="card" >
              <div class="card-body">
                <h5 class="card-title">Population </h5>
                <p class="card-text">Country Wide Population: ${population}</p>
              </div>
            </div>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <div id ="example-card" class="card" >
              <div class="card-body">
                <h5 class="card-title">Cell Penetration</h5>
                <p class="card-text">${cell_penetration}</p>
              </div>
            </div>
        </div>

       <div class="col-md-3 col-sm-6 mb-4">
            <div id ="electricity-usage-card" class="card" >
              <div class="card-body">
                <h5 class="card-title">Rainfall</h5>
                <p class="card-text">${yearly_rainfall}</p>
              </div>
            </div>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
            <div id ="electricity-usage-card" class="card" >
              <div class="card-body">
                <h5 class="card-title">Electricity Usage</h5>
                <p class="card-text">Country Wide Average: ${electricity_usage}%</p>
              </div>
            </div>
        </div>

      </div>
      <!-- /.row -->

      <!-- First Data Row -->
      <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
            <div id ="population-card" class="card" >
              <div class="card-body">
                <h5 class="card-title">Temperature </h5>
                <p class="card-text">${yearly_temperature}</p>
              </div>
            </div>
        </div>

      <!-- /.row -->

    </div>
    <!-- /.container -->
  </body>
</html>