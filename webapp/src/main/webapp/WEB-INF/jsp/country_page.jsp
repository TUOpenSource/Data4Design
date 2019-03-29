<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  #map {
    height: 400px;
    width: 800px;
  }

  select {
    margin-left: 20px;
    max-width: 250px;

  }
</style>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <script src="/js/node_modules/jquery/dist/jquery.min.js"></script>
  <script src="/js/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="${map}" async defer></script>
  <!--<link href="/js/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />-->
  <link rel="icon" href="../../../../favicon.ico">


  <!-- Custom styles for this template -->
  <link href="/css/startbootstrap-portfolio-item-gh-pages/css/portfolio-item.css" rel="stylesheet">

  <!-- Bootswatch for color -->
  <link href="/js/node_modules/bootswatch/dist/yeti/bootstrap.min.css" rel="stylesheet">

  <!-- Font Awesome Glyphs -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
    integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

  <title>HHCD - ${country_name}</title>



</head>

<body class="">
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/">Data 4 Design</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
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
  <div class="container" style="padding-top: 70px; padding-bottom: 15px">



    <div class="row">
      <!-- <div class="col-md-4 order-md-12" style="text-align: right; margin: auto">
        <select id="country_select" onchange="redirect(this);">
          <option value="" selected disabled hidden>Please select a country</option>
        </select>
      </div> -->
      <!-- Country Name -->
      <div style="display:block" class="header col-md-8 order-md-1">
        <span>
          <h1 id="country-name" class="my-4" style="display: inline">
            ${country_name} <h5 style="display:inline"> (${country_code} / ${country_code_3})</h5>
          </h1>
        </span>
      </div>
    </div>

    <!-- Item Row -->
    <div class="row" style="padding-bottom: 20px">
      <!-- Interactive Country Map using Javascript API-->
      <div id="map" class="col-sm-12" style="padding-top: 10px"></div>
      <!-- Country Description -->

    </div>
    <!-- /.row -->

    <!-- <div class="row">
      <h3 class="col-sm-12">Population Data</h3>
      <ul>
        <li>
          <h5><i class="fas fa-users"></i> Population: ${population}</h5>
        </li>
        <li>
          <h5><i class="fas fa-mobile-alt"></i> Mobile Phone Penetration: ${cell_penetration}%</h5>
        </li>
        <li>
          <h5 class="card-title"><i class="fas fa-bolt"></i> Electricity Penetration: ${electricity_usage}%</h5>
        </li>
      </ul>
    </div> -->

    <div class="row">
      <div class="col-md-6">
        <h3>Population Data</h3>
        <ul class="fa-ul">
          <li>
            <span class="fa-li"><i class="fas fa-users"></i></span>
            <h5>Population: ${population}</h5>
          </li>
          <li>
            <span class="fa-li"><i class="fas fa-mobile-alt"></i></span>
            <h5> Mobile Phone Penetration: ${cell_penetration}%</h5>
          </li>
          <li>
            <span class="fa-li"><i class="fas fa-bolt"></i></span>
            <h5>Electricity Penetration: ${electricity_usage}%</h5>
          </li>
        </ul>
      </div>

      <div class="col-md-6">
        <h3>Environement Data</h3>
        <ul class="fa-ul">
          <li>
            <span class="fa-li"><i class="fas fa-thermometer-half"></i></span>
            <h5>Average Annual Temperature: 23&deg;C</h5>
          </li>
          <li>
            <span class="fa-li"><i class="fas fa-tint"></i></span>
            <h5> Average Annual Rainfall: 500mm</h5>
          </li>
          <li>
            <span class="fa-li"><i class="fas fa-tree"></i></span>
            <h5>Natural Resources Available: ${natural_resources}</h5>
          </li>
        </ul>
      </div>
    </div>

    <div class="row">

      <div class="col-md-6">
        <h3>Major Cities</h3>
        <ul>
          <li>
            <h5>This data coming soon</h5>
          </li>
        </ul>
      </div>

      <div class="col-md-6">
        <h3>Safety & Statistics</h3>
        <ul>
          <li>
            <h5>This data coming soon</h5>
          </li>
        </ul>
      </div>

    </div>
    <!-- Statisitacal Information -->

    <!-- First Data Row -->
    <!-- <div class="row">

      <div class="col-md-3 col-sm-6 mb-4">
        <div id="population-card" class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fas fa-users"></i> Population </h5>
            <p class="card-text">Country Wide Population: ${population}</p>
          </div>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <div id="cell-usage-card" class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fas fa-mobile-alt"></i> Mobile Phone Usage</h5>
            <p class="card-text">${cell_penetration} cell phones per 100 people</p>
          </div>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <div id="electricity-usage-card" class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fas fa-tint"></i> Average monthly Rainfall</h5>
            <p class="card-text">${monthly_rainfall}</p>
          </div>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <div id="electricity-usage-card" class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fas fa-bolt"></i> Electricity Usage</h5>
            <p class="card-text">Country Wide Average: ${electricity_usage}%</p>
          </div>
        </div>
      </div>


    </div> -->
    <!-- /.row -->

    <!-- First Data Row -->
    <!-- <div class="row">

      <div class="col-md-3 col-sm-6 mb-4">
        <div id="monthly-temperature-card" class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fas fa-thermometer-half"></i> Average monthly Temperature </h5>
            <p class="card-text">${monthly_temperature}</p>
          </div>
        </div>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <div id="natural-resources-card" class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fas fa-tree"></i> Natural Resources</h5>
            <p class="card-text">${natural_resources}</p>
          </div>
        </div>
      </div>

    </div> -->
    <!-- /.row -->
    <!-- /.container -->
  </div>
</body>

</html>

<script>
  //Interactive map script
  var map;
  var geocoder;
  function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
      center: { lat: 0.00, lng: 0.00 },
      zoom: 8
    });
    geocoder = new google.maps.Geocoder();
  }
  $(document).ready(function () {

    initMap();
    geocoder.geocode({
      componentRestrictions: {
        country: "${country_code}"
      }
    }, function (results, status) {
      if (status == 'OK') {
        map.setCenter(results[0].geometry.location);
        map.fitBounds(results[0].geometry.viewport);
      } else {
        console.log('Geocode was not successful for the following reason: ' + status);
      }
    });

    // //One of these worked not sure which
    // $('#header_video').volume = 0;
    // document.getElementsByTagName('video')[0].volume = 0;
    // $("video").prop("volume", 0);

    //console.log($('#header_video').volume);

    //Get Countries
    var countryArray = JSON.parse('${country_list}');
    console.log(countryArray);

    var sortable = [];
    $.each(countryArray, function (key, value) {
      sortable.push({ key, value });
    });

    sortable.sort(function (a, b) {
      return (a.value > b.value) ? 1 : -1;
    });

    for (var i = 0; i < sortable.length; i++) {
      key = sortable[i].key;
      value = sortable[i].value;
      $('#country_select').append("<option value=\"" + key + "\"><a href=\"/country/" + key + "\">" + value + "</a></option>");
    }

  });


  function redirect(sel) {
    console.log($('#country_select').val());
    var selection = $('#country_select').val();
    window.location.replace("/country/" + selection);
  }
</script>