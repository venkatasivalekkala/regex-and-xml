package core.regex;

/**
 * The Chain
 * @author Venkatasiva Lekkala
 *
 */
public class Chain {
	private char character;
	private Chain nextChain;

	public Chain() {
	}

	/**
	 * Create a new chain based on the input patter
	 * @param pattern
	 */
	public Chain(String pattern) {
		int i = 0;
		int length = pattern.length();
		character = pattern.charAt(i++);

		Chain currentChain = this;
		Chain nextChain;
		while (i < length) {
			nextChain = new Chain();
			nextChain.setCharacter(pattern.charAt(i++));
			currentChain.setNextChain(nextChain);
			currentChain = nextChain;
		}
		currentChain.setNextChain(null); // Mark last chain as null
	}

	/**
	 * Match the chain
	 * @param previousCharIndex
	 * @param string input string to match
	 * @return the index if matched, otherwise -1
	 */
	public int match(int previousCharIndex, String string) {
		int currentIndex = previousCharIndex + 1;
		if ((currentIndex >= string.length()) && (character == '*')) { // Start at last position
			return previousCharIndex;
		} else if ((character == '.') && nextChain == null) {// Dot at last position
			return currentIndex;
		} else if ((string.charAt(currentIndex) == character) && nextChain == null) {
			return currentIndex;
		} else if ((character == '.') || (character == string.charAt(currentIndex))) {
			return nextChain.match(currentIndex, string);
		} else if (character == '*' && nextChain == null) {
			return currentIndex;
		} else if (character == '*') {
			for (int i = currentIndex; i < string.length(); i++) {
				int matchedIndex = nextChain.match(i, string);
				if (matchedIndex != -1) {
					return matchedIndex;
				}
			}
		}
		return -1;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public Chain getNextChain() {
		return nextChain;
	}

	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public String toString() {
		return "[character: " + character + ", nextChain: " + nextChain + "]";
	}
}
