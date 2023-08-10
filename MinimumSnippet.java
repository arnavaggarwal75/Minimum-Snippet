import java.util.ArrayList;
import java.util.List;

/* Given a document (a sequence of words) and set of search terms, this class finds the minimal length subsequence in 
 * the document that contains all of the search terms. This class contains a few instance variables and instance methods
 * which can be used to get more information about the MinimumSnippet.
 */
public class MinimumSnippet {

	// private Instance Variables
	private Iterable<String> document; 
	private List<String> terms;
	private ArrayList<String> minimumSnippet;
	private ArrayList<String> docList; // document in the form of an ArrayList

	/* Constructor which takes in a document (an Iterable), and a set of terms (a List), and computes the shortest 
	 * subsequence of the document that contains all of the terms and store it in the minimumSnippet instance variable.
	 */
	public MinimumSnippet(Iterable<String> document, List<String> terms) {
		if (terms == null || terms.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.document = document;
		this.terms = terms;
		minimumSnippet = new ArrayList<String>(); // empty ArrayList
		docList = new ArrayList<String>();

		// Copying the document to docList
		for (String string : this.document) {
			docList.add(string);
		}

		if (docList.containsAll(terms)) { // If document doesn't have all the terms, minimumSnippet will remain empty
			minimumSnippet = docList; /* We assume that the biggest snippet possible is the shortest snippet in the
										 beginning */
			for (int i = 0; i < docList.size(); i++) {
				ArrayList<String> temp = new ArrayList<>(); /* A temporary arrayList which gets instantiated for every
															   index in the docList */

				/* The below condition is true when the current element of docList is one of the terms and the elements
				 * of the docList after it contain the rest of the terms.
				 */
				if (terms.contains(docList.get(i)) && docList.subList(i, docList.size()).containsAll(terms)) {
					int index = i;
					// Elements will get added to the temp ArrayList until temp contains all terms 
					while (index < docList.size() && !docList.subList(i, index).containsAll(terms)) {
						temp.add(docList.get(index));
						index += 1;
					}

					// if the size of temp is less than the size of the current minimumSnippet
					if (temp.size() < minimumSnippet.size()) { 
						minimumSnippet = temp;
					}
				}
			}
		}
	}

	// This instance method returns true if the document contains all the terms and false otherwise
	public boolean foundAllTerms() {
		return docList.containsAll(terms);
	}

	// This instance method returns the starting index of the snippet. It cannot be called if all terms aren't found
	public int getStartingPos() {
		// To ensure that the user is not able to call this method if all the terms are not been found in the document
		if (!foundAllTerms()) { 
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < docList.size(); i ++) {
			/* The below condition is true when the current element of the document is one of the terms and if the 
			 * sublist of document starting from that element and with a length equal to the size of the minimumSnippet 
			 * contains all the terms */
			if (terms.contains(docList.get(i)) && docList.subList(i, i + minimumSnippet.size()).containsAll(terms)) {
				return i;
			}
		}
		return -1; /* This return statement will never be reached as minimum snippet will be computed in all cases as 
		this method only runs when all terms were found. It is only there because an int value needs to be returned 
		outside the if condition. */
	}

	// This instance method returns the starting index of the snippet. It cannot be called if all terms aren't found
	public int getEndingPos() {
		// To ensure that the user is not able to call this method if all the terms are not been found in the document
		if (!foundAllTerms()) {
			throw new IllegalArgumentException();
		}
		return this.getStartingPos() + minimumSnippet.size() - 1;
	}

	// This instance method returns the length of the snippet
	public int getLength() {
		// To ensure that the user is not able to call this method if all the terms are not been found in the document
		if (!foundAllTerms()) {
			throw new IllegalArgumentException();
		}
		return minimumSnippet.size();
	}

	/* This instance method takes in index of the term in the original list of terms as a parameter. It returns 
	 * the position of the search term at this index as it appears in the original document.
	 */
	public int getPos(int index) {
		// To ensure that the user is not able to call this method if all the terms are not been found in the document
		if (!foundAllTerms()) {
			throw new IllegalArgumentException();
		}
		return this.getStartingPos() + minimumSnippet.indexOf(terms.get(index)); /* indexOf is giving us index of the
																					required search term in the
																					arrayList of minimum snippet */
	}

}
