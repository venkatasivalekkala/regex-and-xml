package core.regex;

/**
 * The HeadChain
 * @author Venkatasiva Lekkala
 *
 */
public class HeadChain {
	private char character;
	private String pattern;

	public HeadChain(String pattern) {
		this.pattern = pattern;
		this.character = pattern.charAt(0);
	}

	public int match(String inputString) {
		return inputString.indexOf(character);
	}

	public int match(int index, String string) {
		if (character == '*' || character == '.') {
			return -1;
		}
		return string.indexOf(character, index);
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String toString() {
		return "[HeadChain, first character: " + character + ", pattern: " + pattern + "]";
	}

}
