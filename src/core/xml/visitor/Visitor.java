package core.xml.visitor;

import core.xml.element.CS635Document;
import core.xml.element.Header;
import core.xml.element.Text;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public interface Visitor {
	public String visit(CS635Document cs635Document);

	public String visit(Header header);

	public String visit(Text text);
}
