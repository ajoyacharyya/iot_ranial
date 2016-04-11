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
	
	public static Map<String, String> convert(String xmlString) {
        HashMap<String, String> values = new HashMap<String, String>();
       // String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user><kyc>123</kyc><address>test</address><resiFI>asds</resiFI></user>";
        Document xml = convertStringToDocument(xmlString);
        Node user = xml.getFirstChild();
        NodeList childs = user.getChildNodes();
        Node child;
        for (int i = 0; i < childs.getLength(); i++) {
            child = childs.item(i);
            values.put(child.getNodeName(), child.getTextContent());
        }
        
       return values;
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
