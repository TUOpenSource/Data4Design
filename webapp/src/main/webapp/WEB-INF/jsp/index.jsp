<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
    <c:url value="/css/bootstrap.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <title>Hardware Human-Centered Design</title>

    <!-- Bootstrap core CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css" rel="stylesheet">
  </head>
  <body class="">
    <div class="container justify-content-center">
        <div class="row text-center">
            <form class="form-signin justify-content-center">
              <label for="inputEmail" class="sr-only">Select Country</label>
          <p>Please select a country for which you would like data</p>
          <div class="form-group">
            <select class="form-control" id="exampleFormControlSelect1" style="padding:0">
              <option>United States</option>
              <option>United Kingdom</option>
              <option>Canada</option>
              <option>Mexico</option>
            </select>
            <select class="form-control" id="exampleFormControlSelect1" style="padding:0">
              <option>Tulsa</option>
              <option>Collinsville</option>
              <option>Broken Arrow</option>
              <option>Sapulpa</option>
            </select>
          </div>    
              <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
              <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>