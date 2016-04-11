package com.ranial.core.mediation.camel;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ConvertXMLToMap {
	
	public Map<String, Object> convert(String xmlString) {
       // String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user><kyc>123</kyc><address>test</address><resiFI>asds</resiFI></user>";
        Document xml = convertStringToDocument(xmlString);
        HashMap<String, Object> values = new HashMap<String, Object>();
        Node user = xml.getFirstChild();
        buildMap(user,values);
        
       return values;
    }
	
	private void buildMap(Node node,Map<String,Object> values){
		
        NodeList childs = node.getChildNodes();
        Node child;
        for (int i = 0; i < childs.getLength(); i++) {
            child = childs.item(i);
            /*System.out.println(child.getNodeName());
            System.out.println(child.getTextContent());*/
            if(child.hasChildNodes() && !child.getFirstChild().getNodeName().equals("#text")){
            	String childName = child.getNodeName();
            	Map<String,Object> childMap = (Map) values.get(childName);
            	if(childMap==null){
            		childMap = new HashMap<String,Object>();
            		values.put(childName, childMap);
            	}
            	buildMap(child,childMap);
            }else{
            	System.out.println(child.getNodeName() + "value "+child.getTextContent());
            	values.put(child.getNodeName(), child.getTextContent());
            }
        }
}

    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(
                    xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
