package web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebRequest {
	public static String send(String targetURL){
		return send(targetURL, null, null, "POST");
	}
	
	public static String send(String targetURL, HashMap<String, String> requestProperties, String urlParameters, String method){
		// Create a new connection
		HttpURLConnection connection = null;
		
		if(targetURL == null || targetURL.isEmpty() == true){
			// There was no URL passed in 
			// TODO: Throw error
			return null;
		}
		
		if(method == null || method.isEmpty() == true){
			// There was no method passed in
			// TODO: Throw error
			return null;
		}
		
		if(!method.equalsIgnoreCase("GET") && !method.equalsIgnoreCase("POST")){ // TODO: Handle more than GET & POST
			// There was an invalid method passed in 
			// TODO: Throw error
			return null;
		}
		
		try {
			// Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod(method.toUpperCase());
			
			// Add the parameters if they are set
			// TODO: Verify the parameter keys are valid
			// TODO: Verify the parameter values are of the right type
			if(requestProperties != null){
				for (Map.Entry<String, String> property : requestProperties.entrySet()) {
					connection.setRequestProperty(property.getKey(), property.getValue());
				}
			}

			// Set the length
			// TODO: Cleanup this
			if(urlParameters != null){
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
			while ((line = readStream.readLine()) != null){
				response.append(line);
				response.append('\n');
			}
			readStream.close();
			
			if (connection != null) {
				connection.disconnect();
			}
			
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
