package xmlparsing;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.sun.xml.internal.ws.util.xml.NodeListIterator;

public class xmlparser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		 File file = new File("C://Users//chirag.atmaram.ghag//Desktop//cpsc.xml");
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(file);
		  Document docclone = db.parse(file);
		  
		  docclone.getDocumentElement().normalize();
		  NodeList n1= docclone.getChildNodes();
		  NodeList n=docclone.getElementsByTagName("serviceItemData");
		Node node=n1.item(0);
		  System.out.println(n.getLength());
		  System.out.println(node.getTextContent());
		for(int a=0; a==n.getLength();a=a)
		{
			// removeAll(n.item(0));
			node.removeChild(n.item(0));
			System.out.println("---------------------------"+n.getLength());
			
		}
		
		  System.out.println(node.getTextContent());
		  doc.getDocumentElement().normalize();
		  System.out.println("Root element " + doc.getDocumentElement().getNodeName());
		  
		  
		  
		NodeList doc1= doc.getChildNodes();
		
		for (int i=0; i<doc1.getLength(); i++)
		{
			
			Node fstNode = doc1.item(i);
			
			Node clone=fstNode.cloneNode(true);
		}
		  
		  
		  
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
