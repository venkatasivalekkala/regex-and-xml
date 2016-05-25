package core.xml.visitor;

import core.xml.element.CS635Document;
import core.xml.element.Header;
import core.xml.element.Text;

/**
 * The Header visitor, it will print all header of the document it visits
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class HeaderVisitor implements Visitor {

	@Override
	public String visit(CS635Document cs635Document) {
		return (""); // Header visitor does not deal with Text and Document elements
	}

	@Override
	public String visit(Header header) {
		return ( header.getText() + "\n");

	}

	@Override
	public String visit(Text text) {
		return (""); // Header visitor does not deal with Text and Document elements
	}

}
