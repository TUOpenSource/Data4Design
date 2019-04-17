<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  .header-container {
    width: 100%;
    height: 1100px;
    border-left: none;
    border-right: none;
    position: relative;
    padding: 20px;
  }

  .select-container {
    text-align: center;
    margin-right: auto;
    margin-left: auto;
    margin-top: 10%;
    padding: 10px;
    z-index: 2147483647;
    position: absolute;
    margin: 0 auto;
    width: 300px;
  }


  .select-container2 {
    text-align: center;
    top: 20%;
    left: 45%;
    z-index: 2;
    position: absolute;
    width: 300px;
  }

  select {
    margin-left: 20px;
    max-width: 250px;

  }

  .select-title {
    color: #ffffff;
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
  <script src="/js/typeahead.bundle.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <!--<link href="/js/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />-->
  <link rel="icon" href="../../../../favicon.ico">

  <!-- Custom styles for this template -->
  <!-- <link href="/css/startbootstrap-portfolio-item-gh-pages/css/portfolio-item.css" rel="stylesheet"> -->

  <!-- Bootswatch for color -->
  <link href="/js/node_modules/bootswatch/dist/yeti/bootstrap.min.css" rel="stylesheet">
  <link href="/css/typeahead-sample.css" rel="stylesheet">

  <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/1.2.1/typeahead.jquery.min.js"></script> -->


  <title>Hardware Human-Centered Design</title>

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
  <div class="container">
    <div style="padding-top: 10%">
      <div style="text-align: center">
        <h1>Data4Design</h1>
        <h3>The goal of <i>Data4Design</i> is to provide you with resources to jump start your humanitarian project.
        </h3>
        <br>
        <h5 class="select-title" style="color:black; text-align: center">To get started, please select a country for
          your project</h5>
      </div>
      <div style="text-align: center; margin: auto">
        <!-- <select id="country_select" onchange="redirect(this);">
          <option value="" selected disabled hidden>Please select a country</option>
        </select> -->
        <div id="typeahead-country-selector">
          <input id="searchField" class="typeahead form-control" type="text" placeholder="ex: 'Uruguay'">
          <button id="searchButton" class="btn-md btn-success">Search</button>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
<script>

  var countryArray = JSON.parse('${country_list}');
  var arrayOfCountries = [];

  $(document).ready(function () {

    //Get Countries
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

      arrayOfCountries.push(value);
    }

    var ret = {};
    for (var key in countryArray) {
      ret[countryArray[key]] = key;
    }
    countryArray = ret;

  });


  function redirect(sel) {
    console.log($('#country_select').val());
    var selection = $('#country_select').val();
    window.location.replace("/country/" + selection);
  }

  $("#searchButton").click(function () {
    var country = $("#searchField").val();
    var code = countryArray[country];

    if (code == null) {
      window.alert("Please select a valid country");
    } else {
      console.log(code);
      window.location.replace("/country/" + code);
    }
  });

  var substringMatcher = function (strs) {
    return function findMatches(q, cb) {
      var matches, substringRegex;

      // an array that will be populated with substring matches
      matches = [];

      // regex used to determine if a string contains the substring `q`
      substrRegex = new RegExp(q, 'i');

      // iterate through the pool of strings and for any string that
      // contains the substring `q`, add it to the `matches` array
      $.each(strs, function (i, str) {
        if (substrRegex.test(str)) {
          matches.push(str);
        }
      });

      cb(matches);
    };
  };

  $('#typeahead-country-selector .typeahead').typeahead({
    hint: true,
    highlight: true,
    minLength: 1
  },
    {
      name: 'arrayOfCountries',
      source: substringMatcher(arrayOfCountries)
    });
</script>