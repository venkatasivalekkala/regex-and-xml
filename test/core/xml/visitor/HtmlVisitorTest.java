package core.xml.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import core.xml.element.CS635Document;
import core.xml.element.XmlParser;

public class HtmlVisitorTest {
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
}
