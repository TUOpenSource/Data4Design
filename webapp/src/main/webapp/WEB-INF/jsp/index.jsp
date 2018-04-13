<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.header-container{
  width: 100%;
  height: 1100px;
  border-left: none;
  border-right: none;
  position: relative;
  padding: 20px;
}

.video-container{
  top: 0%;
  left:0%;
  height: 100%;
  width: 100%;
  position: absolute;
  overflow: hidden;
}

.select-container{
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


.select-container2{
  text-align: center;
  top: 20%;
  left: 45%;
  z-index: 2;
  position: absolute;
  width: 300px;
}

select{
  margin-left: 20px;
  max-width: 250px;

}

video {
  position: absolute;
  z-index: -1;
  opacity: 0.78;
  width: 100%;
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
    <!--<link href="/js/node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />-->
    <link rel="icon" href="../../../../favicon.ico">


    <!-- Custom styles for this template -->
    <link href="/css/startbootstrap-portfolio-item-gh-pages/css/portfolio-item.css" rel="stylesheet"> 

    <!-- Bootswatch for color -->
    <link href="/js/node_modules/bootswatch/dist/yeti/bootstrap.min.css" rel="stylesheet">

    <title>Hardware Human-Centered Design</title>

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

    <!-- Video Header -->
    <div class="header-container">
      <div class="video-container">
        <video id = "header_video" preload = "true" loop = "loop" autoplay = "autoplay" volume = "0" poster = "/media/pictures/header_picture2.jpg">
          <source src="/media/video/header_video2.mp4" type = "video/mp4">
        </video>
      </div>
      <!-- Page Content --> 
      <div class="select-container2">
        <h2 class="select-title">Please Select a Country</h2>
        <div class ="center">
          <select style="margin-left: 20px;" class="form-control" id="country_select" onchange="redirect(this);">
          </select>
        </div>
      </div>
    </div>


    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
<script>
$(document).ready(function() {

//One of these worked not sure which
$('#header_video').volume = 0;
document.getElementsByTagName('video')[0].volume = 0;
$("video").prop("volume", 0);

//console.log($('#header_video').volume);

//Get Countries
var countryArray = JSON.parse('${country_list}');
console.log(countryArray);
$.each(countryArray, function(key,value) {
  $('#country_select').append("<option value=\""+key+"\"><a href=\"/country/"+key+"\">"+value+"</a></option>");
});


});


function redirect(sel)
{
    console.log($('#country_select').val());
    var selection = $('#country_select').val();
    window.location.replace("/country/"+selection);
}
</script>