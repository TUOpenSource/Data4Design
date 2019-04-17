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
  <script src="/js/mdb.min.js"></script>
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
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <select id="country_select" onchange="redirect(this);">
              <option value="" selected disabled hidden>Please select a country</option>
            </select>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container" style="padding-top: 70px; padding-bottom: 15px">

    <div class="row">
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
        <h3>Environment Data</h3>
        <ul class="fa-ul">
          <li>
            <span class="fa-li"><i class="fas fa-thermometer-half"></i></span>
            <h5>Average Annual Temperature: ${yearly_temperature}&deg;C</h5>
          </li>
          <li>
            <span class="fa-li"><i class="fas fa-tint"></i></span>
            <h5> Average Annual Rainfall: ${yearly_rainfall}mm</h5>
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

    <div class="row">

      <div class="col-md-6">
        <canvas id="monthlyTemperatureChart"></canvas>
      </div>

      <div class="col-md-6">
        <canvas id="monthlyRainfallChart"></canvas>
      </div>

    </div>
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

    //Get Countries
    var countryArray = JSON.parse('${country_list}');

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

  var monthlyTemperatureObject = ${monthly_temperature};
  var monthlyRainfallObject = ${monthly_rainfall};

  var tempChart = document.getElementById("monthlyTemperatureChart").getContext('2d');
  var myLineChart = new Chart(tempChart, {
    type: 'line',
    data: {
      labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
      datasets: [{
        label: "Temperature (C)",
        data: [
          monthlyTemperatureObject.January,
          monthlyTemperatureObject.February,
          monthlyTemperatureObject.March,
          monthlyTemperatureObject.April,
          monthlyTemperatureObject.May,
          monthlyTemperatureObject.June,
          monthlyTemperatureObject.July,
          monthlyTemperatureObject.August,
          monthlyTemperatureObject.September,
          monthlyTemperatureObject.October,
          monthlyTemperatureObject.November,
          monthlyTemperatureObject.December,
        ],
        backgroundColor: [
          'rgba(105, 0, 132, .2)',
        ],
        borderColor: [
          'rgba(200, 99, 132, .7)',
        ],
        borderWidth: 2
      },
      ]
    },
    options: {
      responsive: true
    }
  });

  var rainChart = document.getElementById("monthlyRainfallChart").getContext('2d');
  var myLineChart = new Chart(rainChart, {
    type: 'line',
    data: {
      labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
      datasets: [{
        label: "Rainfall (mm)",
        data: [
          monthlyRainfallObject.January,
          monthlyRainfallObject.February,
          monthlyRainfallObject.March,
          monthlyRainfallObject.April,
          monthlyRainfallObject.May,
          monthlyRainfallObject.June,
          monthlyRainfallObject.July,
          monthlyRainfallObject.August,
          monthlyRainfallObject.September,
          monthlyRainfallObject.October,
          monthlyRainfallObject.November,
          monthlyRainfallObject.December,
        ],
        backgroundColor: [
          'rgba(0, 137, 132, .2)',
        ],
        borderColor: [
          'rgba(0, 10, 130, .7)',
        ],
        borderWidth: 2
      },
      ]
    },
    options: {
      responsive: true
    }
  });
</script>