package core.xml.element;

import core.xml.visitor.Visitor;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public interface XmlElement extends XmlComponent {
	public String accept(Visitor visitor);

	public void setText(String text);

	public String getText();

	public void setTabIndex(int tabIndex);

	public int getTabIndex();
}
