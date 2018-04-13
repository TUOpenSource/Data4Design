package com.Data4Design.services;

import java.io.StringWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.Data4Design.results.doubleResult;

public class RainfallService implements IRainfallService  {
	/**
	 * Makes a call to OpenWeatherMap to get the rainfall percentage(as in number now) in next 3 hours in
	 * a specified city. The number is measured every 3 hours, so if needed we can change 
	 * parameters,also we can see if it's raining or snowing, all sort of thing
	 * 
	 * 
	 * Return type is Double or String, (So i pushed a doubleResult.java) could be change later according to the result class
	 */
	public doubleResult getRainfall(String cityName) {
		doubleResult ForecastRainfall = new doubleResult();
		double FRainfall=0.0;
		String output=null;
		    try {
		    	String url = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&mode=xml&cnt=1&appid=0f8e689eb3609499ebb9c46273e17071", cityName);
		        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        org.w3c.dom.Document doc = db.parse(new URL(url).openStream());
		        TransformerFactory tf = TransformerFactory.newInstance();
		        Transformer transformer = tf.newTransformer();
		        StringWriter writer = new StringWriter();
		        transformer.transform(new DOMSource(doc), new StreamResult(writer));
		        output = writer.getBuffer().toString().split("precipitation")[1];
		        
		    }
		    catch (Exception e) {
	            System.out.println("ERROR: "+e);
	        } 
		    if (output.substring(0, 1).equals("/")){
			    ForecastRainfall.setData(FRainfall);
		    }
		    else{
	        	System.out.println("Hello"+output.split("value=")[1].split("\"")[1]);
	        	FRainfall=Double.parseDouble(output.split("value=")[1].split("\"")[1]);
	        }
		    ForecastRainfall.setData(FRainfall);
			return ForecastRainfall;
	    }

}
