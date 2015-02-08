package web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import api.Event;

public class Events {
<<<<<<< HEAD
	public static Event getAll(String authentication){
		String eventSigninEventsId = "";
		Node loginXMLObj = XMLHandler.parseString(WebRequest.send(WebRequest.WEB_URL + "&token=" + authentication, new HashMap<String, String>(), "", "POST"));
		Node[] output = XMLHandler.getNodes(loginXMLObj, "apiHandlers handler");
=======
	public static Event getAll(){
		String targetURL = "http://octoraro22.org/eventsignin/index.php?api=1";
		HashMap<String, String> requestProperties = new HashMap<String, String>();
		String urlParameters = "";
		String method = "POST";
>>>>>>> branch 'master' of https://github.com/Krono5/Checkin-System.git
		
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
									
									if(name.equals("name") && value.equals("Event Signin Events")){
										eventSigninEventsId = id;
									}
								}
							}
						}
					}
				}
			}
		}
		
		String responseStr = WebRequest.send(WebRequest.WEB_URL + "&token=" + authentication, new HashMap<String, String>(), "id=" + WebRequest.base64_encode(eventSigninEventsId) + "&task=getEvents", "GET");
		Node eventSigninEventsObj = XMLHandler.parseString(responseStr);
		Node[] eventSigninEventsResult = XMLHandler.getNodes(eventSigninEventsObj, "events event");
		
		XMLHandler.printStructure(eventSigninEventsObj);
		
		if(eventSigninEventsResult != null){
			for(int x = 0; x < eventSigninEventsResult.length; x++){
				Node currNode = eventSigninEventsResult[x];
				
				if(currNode != null){
					// There can be more than 1 response
					NodeList list = currNode.getChildNodes();
					
					if(list.getLength() > 0){
						for(int i = 0; i < list.getLength(); i++){
							if(list.item(i).hasChildNodes() == true){
								if(list.item(i).getNodeName() != null){
									String name = list.item(i).getNodeName();
									String value = list.item(i).getTextContent();
									
									System.out.println(name + " " + value);
								}
							}
						}
					}
				}
			}
		}
		
		return null;
	}
}
