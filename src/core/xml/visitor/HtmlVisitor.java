package core.xml.visitor;

import core.xml.element.CS635Document;
import core.xml.element.Header;
import core.xml.element.Text;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class HtmlVisitor implements Visitor {

	@Override
	public String visit(CS635Document cs635Document) {
		String text = (cs635Document.getText() == null) ? "" : cs635Document.getText();
		return ( text + "\n");
	}

	@Override
	public String visit(Header header) {
		String text = (header.getText() == null) ? "" : header.getText();
		return ( text + "\n");
	}

	@Override
	public String visit(Text text) {
		String myText = (text.getText() == null) ? "" : text.getText();
		return ( myText + "\n");
	}
}
