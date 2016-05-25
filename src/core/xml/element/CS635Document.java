package core.xml.element;

import java.util.ArrayList;
import java.util.List;
import core.xml.visitor.Visitor;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class CS635Document implements XmlElement {
	private List<XmlElement> xmlElements;
	private String text;
	private int tabIndex;

	public CS635Document() {
		xmlElements = new ArrayList<>();
	}

	public List<XmlElement> getXmlElements() {
		return xmlElements;
	}

	public void setXmlElements(List<XmlElement> xmlElements) {
		this.xmlElements = xmlElements;
	}

	public void addXmlElement(XmlElement xmlElement) {
		xmlElements.add(xmlElement);
	}

	@Override
	public String accept(Visitor visitor) {
		StringBuilder builder = new StringBuilder();
		builder.append(visitor.visit(this));

		for (XmlElement xmlElement : xmlElements) {
			builder.append(xmlElement.accept(visitor));
		}

		return builder.toString();
	}

	public String getTab(int tabIndex) {
		String str = "";
		for (int i = 0; i < tabIndex; i++) {
			str += "\t";
		}
		return str;
	}

	/**
	 * Print the component
	 */
	@Override
	public String printComponent() {
		String tab = getTab(tabIndex);
		StringBuilder builder = new StringBuilder();

		builder.append(tab).append("\n");
		for (XmlComponent component : xmlElements) {
			builder.append(component.printComponent());
		}
		builder.append(tab ).append("\n");

		return builder.toString();
	}

	@Override
	public void setText(String text) {
		this.setText(text);

	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;

	}

	@Override
	public int getTabIndex() {
		return tabIndex;
	}

}
