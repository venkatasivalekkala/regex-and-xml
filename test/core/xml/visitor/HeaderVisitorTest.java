package core.xml.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import core.xml.element.CS635Document;
import core.xml.element.XmlParser;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class HeaderVisitorTest {
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
}
