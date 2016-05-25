package core.regex;

/**
 * Match Class
 * @author Venkatasiva Lekkala
 *
 */
public class Match {
	private HeadChain headChain;
	private Chain chain;
	private String pattern;

	/**
	 * Create a match object based on input patter
	 * @param pattern
	 */
	public Match(String pattern) {
		this.pattern = pattern;
		headChain = new HeadChain(pattern);
		chain = new Chain(pattern.substring(1));
	}

	/**
	 * Find first index that matches
	 * @param inputString
	 * @return the index
	 */
	public int findFirstIndex(String inputString) {
		int matchedIndex = -1;
		int chainIndex = -1;
		int i = 0;
		int length = inputString.length();

		while (i < length) {
			matchedIndex = headChain.match(i, inputString);
			if (matchedIndex == -1 && headChain.getCharacter() == '*') {
				chainIndex = chain.match(matchedIndex, inputString);
				matchedIndex = 0; // wild character at first position
			} else if (matchedIndex == -1 && headChain.getCharacter() == '.') {
				matchedIndex = 0; // wild character at first position
				chainIndex = chain.match(matchedIndex, inputString);
			} else if (matchedIndex > -1) {
				chainIndex = chain.match(matchedIndex, inputString);
			}

			if (chainIndex > -1) {
				return matchedIndex;
			}

			// If not found then we already reached end of string
			i = (matchedIndex == -1) ? length : matchedIndex + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Match match = new Match("c.t");
		int startIndex = match.findFirstIndex("0123cat");
		System.out.println("startIndex: " + startIndex);

		match = new Match("at*");
		startIndex = match.findFirstIndex("01234at");
		System.out.println("startIndex: " + startIndex);

		match = new Match("*c");
		startIndex = match.findFirstIndex("cam");
		System.out.println("startIndex: " + startIndex);
	}

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	public HeadChain getHeadChain() {
		return headChain;
	}

	public void setHeadChain(HeadChain headChain) {
		this.headChain = headChain;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
