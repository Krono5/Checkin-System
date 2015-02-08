package web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WebRequest {
	public static final String WEB_URL = "http://172.16.191.166/lodgePortal/index.php?api=1";
	
	public static String send(String targetURL){
		return send(targetURL, null, null, "POST");
	}
	
	public static String send(String targetURL, HashMap<String, String> requestProperties, String urlParameters, String method){
		// Create a new connection
		HttpURLConnection connection = null;
		
		if(targetURL == null || targetURL.isEmpty() == true) {
			// There was no URL passed in
			// TODO: Throw error
			return null;
		}
		
		if(method == null || method.isEmpty() == true) {
			// There was no method passed in
			// TODO: Throw error
			return null;
		}
		
		if(!method.equalsIgnoreCase("GET") && !method.equalsIgnoreCase("POST")) { // TODO: Handle more than GET & POST
			// There was an invalid method passed in
			// TODO: Throw error
			return null;
		}
		
		try {
			// Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method.toUpperCase());
			
			// Add the parameters if they are set
			// TODO: Verify the parameter keys are valid
			// TODO: Verify the parameter values are of the right type
			if(requestProperties != null) {
				for(Map.Entry<String, String> property : requestProperties.entrySet()) {
					connection.setRequestProperty(property.getKey(), property.getValue());
				}
			}
			
			// Set the length
			// TODO: Cleanup this
			if(urlParameters != null) {
				connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			} else {
				connection.setRequestProperty("Content-Length", "0");
			}
			
			// Set the language
			connection.setRequestProperty("Content-Language", "en-US");
			
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			// Send request
			DataOutputStream writeStream = new DataOutputStream(connection.getOutputStream());
			writeStream.writeBytes((urlParameters != null ? urlParameters : ""));
			writeStream.flush();
			writeStream.close();
			
			// Get Response
			BufferedReader readStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuffer response = new StringBuffer();
			while((line = readStream.readLine()) != null) {
				response.append(line);
				response.append('\n');
			}
			readStream.close();
			
			if(connection != null) {
				connection.disconnect();
			}
			
			return response.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String login(String inputUsername, String inputPassword){
		if(inputUsername != null & inputUsername.length() > 0 && inputPassword != null && inputPassword.length() > 0) {
			String loginAPIId = "";
			Node loginXMLObj = XMLHandler.parseString(WebRequest.getAPIs());
			Node[] output = XMLHandler.getNodes(loginXMLObj, "apiHandlers handler");
			
			if(output != null){
				for(int x = 0; x < output.length; x++){
					Node currNode = output[x];
					
					if(currNode != null){
						// There can be more than 1 response
						NodeList list = currNode.getChildNodes();
						
						if(list.getLength() > 0){
							String id = "";
							
							for(int i = 0; i < list.getLength(); i++){
								if(list.item(i).hasChildNodes() == true){
									if(list.item(i).getNodeName() != null){
										String name = list.item(i).getNodeName();
										String value = list.item(i).getTextContent();
										
										if(name.equals("id")){
											id = value;
										}
										
										if(name.equals("name") && value.equals("Login")){
											loginAPIId = id;
										}
									}
								}
							}
						}
					}
				}
			}
			
			if(loginAPIId.length() > 0){
				
			}
			
			String webResult = WebRequest.send(WEB_URL, new HashMap<String, String>(), "id=" + loginAPIId + "&task=login&username=" + inputUsername + "&password=" + inputPassword, "POST");
			
			return webResult;
		}
		
		return null;
	}
	
	public static String getAPIs(){
		HashMap<String, String> requestProperties = new HashMap<String, String>();
		
		String webResult = WebRequest.send(WebRequest.WEB_URL, requestProperties, "", "POST");
		
		return webResult;
	}
	
	public static String base64_encode(String inputString){
		try {
			inputString = java.net.URLEncoder.encode(inputString, "UTF-8").replaceAll("\\+", "%20");
		} catch(UnsupportedEncodingException e) {
			// Nothing we can do
		}
		
//		inputString = inputString.replaceAll("\\+", "-");
//		inputString = inputString.replaceAll("[/]", "_");
//		inputString = inputString.replaceAll("[=]", "~");
		
		return inputString;
	}
}
