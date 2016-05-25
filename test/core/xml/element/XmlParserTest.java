package core.xml.element;

import static org.junit.Assert.*;

import org.junit.Test;

import core.xml.visitor.HeaderVisitor;
import core.xml.visitor.HtmlVisitor;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */


public class XmlParserTest {


	@Test
	public void testHeaderVisitor() {
		String expectedStr = "Header 1" +
				"Nested Header " + 
				"Header 2";
		expectedStr = expectedStr.trim();

		XmlParser xmlParser = new XmlParser();
		CS635Document doc = xmlParser.parseXml("docs/sample2.xml");

		HeaderVisitor headerVisitor = new HeaderVisitor();
		String docStr = doc.accept(headerVisitor);
		docStr = docStr.replace("\t", "");
		docStr = docStr.replace("\n", "").trim();

		assertEquals(expectedStr, docStr);
	}

	@Test
	public void testHtmlVisitor() {
		String expectedStr ="Header 1" +
				"Text 1" +
				"Nested Header " +
				"Header 2" +
				"Text 2";
		expectedStr = expectedStr.trim();

		XmlParser xmlParser = new XmlParser();
		CS635Document doc = xmlParser.parseXml("docs/sample2.xml");


		HtmlVisitor htmlVisitor = new HtmlVisitor();
		String docStr = doc.accept(htmlVisitor);
		docStr = docStr.replace("\t", "");
		docStr = docStr.replace("\n", "").trim();

		assertEquals(expectedStr, docStr);
	}


	@Test
	public void testParse() {
		String expectedStr = "Header 1" +
				"Text 1" +
				"Nested Header " +
				"Header 2" +
				"Text 2";
		expectedStr = expectedStr.trim();

		XmlParser xmlParser = new XmlParser();
		CS635Document doc = xmlParser.parseXml("docs/sample2.xml");
		String docStr = doc.printComponent();
		docStr = docStr.replace("\t", "");
		docStr = docStr.replace("\n", "").trim();
		assertEquals(expectedStr, docStr);
	}
}
