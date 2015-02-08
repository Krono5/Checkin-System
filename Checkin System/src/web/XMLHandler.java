package web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLHandler {
	public static Node parseString(String inputXML){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		if(inputXML != null){
			try {
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document dom = db.parse(new InputSource(new ByteArrayInputStream(inputXML.getBytes("utf-8"))));
				
				return dom.getDocumentElement().getParentNode();
			} catch(ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			} catch(SAXParseException e){
				// Do nothing since we will return null
			} catch(SAXException se) {
				se.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static Document parseStringToDom(String inputXML){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		if(inputXML != null){
			try {
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document dom = db.parse(new InputSource(new ByteArrayInputStream(inputXML.getBytes("utf-8"))));
				
				return dom;
			}catch(ParserConfigurationException pce) {
				pce.printStackTrace();
			}catch(SAXException se) {
				se.printStackTrace();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static Node[] getNodes(Node inputNode, String inputPath){
		if(inputNode != null && inputPath.length() > 0){
			// Parse the string
			String[] pathParts = inputPath.split(" ");
			
			if(pathParts.length > 0){
				// It was successful. 
				NodeList list = inputNode.getChildNodes();
				
				if(list.getLength() > 0){
					Node[] output = new Node[list.getLength()]; 
					int outputCount = 0;
					
					for(int i = 0; i < list.getLength(); i++){
						if(list.item(i).getNodeName().equals(pathParts[0])){
							// We found the node... lets continue
							String outputString = "";
							
							for(int n = 1; n < pathParts.length; n++){
								outputString += pathParts[n];
								
								if(n != (pathParts.length - 1)){
									outputString += " ";
								}
							}
							
							if(outputString.length() > 0){
								// This is not the node you were looking for
								return getNodes(list.item(i), outputString);
							} else {
								// This is the node you were looking for
								output[outputCount] = list.item(i);
								outputCount++;
							}
						}
					}
					
					if(outputCount > 0){
						return output;
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 */
	public static String[] getNodeValue(Node inputNode, String attributeValue){
		Node[] x = XMLHandler.getNodes(inputNode, attributeValue);
		int nodeCount = 0;
		
		if(x != null){
			for(int i = 0; i < x.length; i++){
				if(x[i] != null && x[i].getTextContent().length() > 0){
					nodeCount++;
				}
			}
			
			String[] output = new String[nodeCount];
			nodeCount = 0;
			
			for(int i = 0; i < x.length; i++){
				if(x[i] != null && x[i].getTextContent().length() > 0){
					output[nodeCount] = x[i].getTextContent();
					nodeCount++;
				}
			}
			
			if(nodeCount > 0){
				return output;
			}
		}
		
		return null;
	}
	
	public static String getSingleNode(String[] inputString){
		if(inputString != null){
			return inputString[0];
		}
		
		return null;
	}
	
	public static void printStructure(Node inputNode){
		if(inputNode != null){
			traverseDomStructure(inputNode, 0);
		} else {
			System.out.println("null");
		}
	}
	
	public static void printStructure(Document inputDocument){
		if(inputDocument != null){
			Element docRoot = inputDocument.getDocumentElement();
			
			if(docRoot.getChildNodes().getLength() > 0){
				traverseDomStructure(docRoot.getParentNode(), 0);
			}
		} else {
			System.out.println("null");
		}
	}
	
	private static final void traverseDomStructure(Node inputNode, int tabs){
		if(inputNode != null){
			NodeList list = inputNode.getChildNodes();
			
			if(list.getLength() > 0){
				for(int i = 0; i < list.getLength(); i++){
					if(list.item(i).hasChildNodes() == true){
						String tabString = "";
						for(int t = 0; t < tabs; t++){
							tabString += '\t';
						}
						
						System.out.println(tabString + "+ " + list.item(i).getNodeName() + " : " + list.item(i).getTextContent());
						
						traverseDomStructure(list.item(i), (tabs + 1));
					}
				}
			}
		}
	}
	
	public static String toString(Node n){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		try {
			db = dbf.newDocumentBuilder();
			NodeList list = n.getChildNodes();
			Document currDom = db.newDocument();
			
			currDom.appendChild(currDom.adoptNode(list.item(0).cloneNode(true)));
			
			return XMLHandler.toString(currDom);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String toString(Document doc){
		try {
			StringWriter sw = new StringWriter();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.transform(new DOMSource(doc), new StreamResult(sw));
			return sw.toString();
		} catch (Exception ex){
			throw new RuntimeException("Error converting to String", ex);
		}
	}
	
}