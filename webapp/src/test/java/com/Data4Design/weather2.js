$(document).ready(function(){
    $('#submitWeather').click(function(){
        var city=$("#city").val();
        if(city !=''){
            $.ajax({
                url: 'http://api.openweathermap.org/data/2.5/weather?q='+city+"&units=metric"z+"&APPID=a08a0e8bff100d3e9ea4a7f41243460a",
                type:"GET"，
                dataType: "jsonp",
                success:function(data);
                $("#show").html(widget);
                $("#city").val('');
            }
        });
    }else{
    $("#error").html('Field cannot be empty'); 
}
});
    });
                function show(data){
                    return "<h2>Current Weather for " + data.name + ", " + data.sys.country +"</h2>" +
                "<h3><strong>Weather</strong>:"+ data.weather[0].main+"</h3>" +
                "<h3><strong>Description</strong>:"+ data.weather[0].description+"</h3>" +
                "<h3><strong>Weather</strong>:"+ data.main.temp + "&deg;C</h3>" +
                "<h3><strong>Weather</strong>:"+ data.main.pressure +"</h3>" +
                "<h3><strong>Weather</strong>:"+ data.main.humidity +"</h3>" +
                "<h3><strong>Weather</strong>:"+ data.main.temp_min+"</h3>" +
                "<h3><strong>Weather</strong>:"+ data.main.temp_max+"</h3>" +
                
                }