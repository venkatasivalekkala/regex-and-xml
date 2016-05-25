package core.xml.element;

import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import core.xml.*;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class XmlParser extends DefaultHandler {
	Stack<CS635Document> stack;
	private CS635Document doc;
	private XmlElement element;

	public XmlParser() {
		stack = new Stack<CS635Document>();
	}

	public CS635Document parseXml(String xmlLocation) {
		parseDataFromXmlFile(xmlLocation);
		return doc;
	}

	private void parseDataFromXmlFile(String xmlLocation) {
		try {
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			parser.parse(xmlLocation, this);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException("Error while pasing json at: " + xmlLocation + ", the error message is: " + e.getMessage(), e);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("CS635Document".equals(qName)) {
			doc = new CS635Document();
			doc.setTabIndex(stack.size());
			stack.push(doc);
		} else if ("header".equals(qName)) {
			element = new Header();
			element.setTabIndex(stack.size());
		} else if ("text".equals(qName)) {
			element = new Text();
			element.setTabIndex(stack.size());
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String text = String.valueOf(ch, start, length);
		if (text != null && text.trim().length() != 0) {
			element.setText(text);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("CS635Document".equals(qName)) {
			CS635Document element = stack.pop();
			if (!stack.isEmpty()) {
				CS635Document doc = stack.peek();
				doc.addXmlElement(element);
			} else {
				this.doc = element; // root element
			}
		} else if ("header".equals(qName) || "text".equals(qName)) {
			CS635Document doc = stack.peek();
			doc.addXmlElement(element);
		}
	}

}
