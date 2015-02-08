package web;

import java.util.HashMap;
import api.Event;

public class Events {
	public static Event getAll(){
		String targetURL = "http://172.16.191.166/lodgePortal/index.php?api=1";
		HashMap<String, String> requestProperties = new HashMap<String, String>();
		String urlParameters = "";
		String method = "POST";
		
		String webResult = WebRequest.send(targetURL, requestProperties, urlParameters, method);
		
		System.out.println(webResult);
		
		return null;
	}
}
