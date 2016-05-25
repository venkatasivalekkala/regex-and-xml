package core.regex;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 
 * @author Venkatasiva Lekkala
 *
 */
public class MatchTest {
	@Test
	public void matchWithDotAtFirstPosition() {
		Match match = new Match(".ello");

		int startIndex = match.findFirstIndex("Hello World");
		assertEquals(0, startIndex);
	}

	@Test
	public void matchWithDotAtMiddlePosition() {
		Match match = new Match("e.lo");

		int startIndex = match.findFirstIndex("Hello World");
		assertEquals(1, startIndex);
	}

	@Test
	public void matchWithDotAtLastPosition() {
		Match match = new Match("Worl.");

		int startIndex = match.findFirstIndex("0124World");
		assertEquals(4, startIndex);
	}

	@Test
	public void matchWithStarAtFirstPosition() {
		Match match = new Match("*Hello");

		int startIndex = match.findFirstIndex("Hello abcd");
		assertEquals(0, startIndex);
	}

	@Test
	public void matchWithStarAtLastPosition() {
		Match match = new Match("Worl*");

		int startIndex = match.findFirstIndex("0123World");
		assertEquals(4, startIndex);
	}

	@Test
	public void matchWithStarAtMiddlePosition() {
		Match match = new Match("W*d");

		int startIndex = match.findFirstIndex("Hello World");
		assertEquals(6, startIndex);
	}
}
