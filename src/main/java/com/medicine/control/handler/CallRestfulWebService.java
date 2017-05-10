package com.medicine.control.handler;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.medicine.control.json.handler.ItsONWrapper;
import com.medicine.control.json.handler.SensorWrapper;

public class CallRestfulWebService {
	public static WebTarget getRequestRest (String URL){
		Client client = ClientBuilder.newClient();
		return client.target(URL);
	}
	
	public static String getJSON (String URL){
		/*Se for JSON*/
		WebTarget target1 = getRequestRest(URL);
		return target1.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	
	public static int getTemperature (String URL){
		Gson g = new GsonBuilder().create();
		SensorWrapper temperature = g.fromJson(getJSON(URL), SensorWrapper.class);
		return Integer.parseInt(temperature.toString());
	}
	
	public static boolean getItsON(String URL){
		Gson g = new GsonBuilder().create();
		ItsONWrapper itson = g.fromJson(getJSON(URL), ItsONWrapper.class);
		return Boolean.parseBoolean(itson.toString());
	}
	
	/*public static void getXML(String URL){
		WebTarget target2 = getRequestRest(URL);
		System.out.println(target2.request(MediaType.APPLICATION_XML).get(String.class));
	}*/
	
	public static void main(String[] args){
		
		System.out.println(getJSON("http://senseup.gq/sensor/7b4aa763-a201-4564-9659-ce226abf1d2d/resource/2270b8c2-d21a-4b38-ab18-982fcb6c8350"));
		//System.out.println(getTemperature("http://localhost:8084/RestfulWS/solicitation/temperature"));
		
		//System.out.println(getItsON("http://localhost:8084/RestfulWS/solicitation/itsON"));		
	}
}
