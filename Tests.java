import org.junit.Test;

import java.util.Arrays;

import junit.framework.TestCase;

public class Tests extends TestCase {

	static MinimumSnippet get(String[] doc, String[] terms) {
		return new MinimumSnippet(Arrays.asList(doc), Arrays.asList(terms));
	}

	/** Test the case where none of the terms are found */
	@Test
	public void testNotFoundAny() {
		MinimumSnippet m = get(new String[] { "1", "2", "3" }, new String[] { "x" });
		assertFalse(m.foundAllTerms());
	}

	/** Test the case where only some of the terms are found */
	@Test
	public void testNotFoundAll() {
		MinimumSnippet m = get(new String[] { "19", "12", "353" }, new String[] { "19", "x" });
		assertFalse(m.foundAllTerms());
	}

	/* Test finding "10" in the document "10", "21", "32" */
	@Test
	public void test1in123() {
		MinimumSnippet m = get(new String[] { "10", "21", "32" }, new String[] { "10" });
		assertTrue(m.foundAllTerms());
		assertEquals(0, m.getStartingPos());
		assertEquals(0, m.getEndingPos());
		assertEquals(1, m.getLength());
		assertEquals(0, m.getPos(0));
	}

	/* Test finding "33" in the document "13", "23", "33" */
	@Test
	public void test3in123() {
		MinimumSnippet m = get(new String[] { "31", "32", "33" }, new String[] { "33" });
		assertTrue(m.foundAllTerms());
		assertEquals(2, m.getStartingPos());
		assertEquals(2, m.getEndingPos());
		assertEquals(1, m.getLength());
		assertEquals(2, m.getPos(0));
	}

	/* Test finding "1" and "3" in the document "1", "2", "2", "3", "2", "1" */
	@Test
	public void test13in122321() {
		MinimumSnippet m = get(new String[] { "1", "2", "2", "3", "2", "1" }, new String[] { "1", "3" });
		assertTrue(m.foundAllTerms());
		assertEquals(3, m.getStartingPos());
		assertEquals(5, m.getEndingPos());
		assertEquals(3, m.getLength());
		assertEquals(5, m.getPos(0));
		assertEquals(3, m.getPos(1));
	}

	/* Test finding "1" and "3" in the document "1", "2", "2", "3", "2", "1" */
	@Test
	public void test31in122321() {
		MinimumSnippet m = get(new String[] { "1", "2", "2", "3", "2", "1" }, new String[] { "3", "1" });
		assertTrue(m.foundAllTerms());
		assertEquals(3, m.getStartingPos());
		assertEquals(5, m.getEndingPos());
		assertEquals(3, m.getLength());
		assertEquals(3, m.getPos(0));
		assertEquals(5, m.getPos(1));
	}

	@Test
	public void testMine() {
		MinimumSnippet m = get(new String[] { "1", "3", "2", "3", "0", "1", "2", "1" }, new String[] { "3", "1", "0" });
		assertTrue(m.foundAllTerms());
		assertEquals(3, m.getStartingPos());
	}
}