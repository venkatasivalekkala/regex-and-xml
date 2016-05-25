package core.xml.element;

import core.xml.visitor.Visitor;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class Header implements XmlElement {
	private String text;
	private int tabIndex;

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

	/**
	 * Get the current tab space of this compoenent, used for displaying purpose
	 * 
	 * @param tabIndex
	 * @return the current tab index
	 */
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
		builder.append(tab + text ).append("\n");
		return builder.toString();
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
