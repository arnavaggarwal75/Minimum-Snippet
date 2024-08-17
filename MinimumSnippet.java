import java.util.Arrays; 
import java.util.List; 
 
public class MinimumSnippet { 
 
    /* These will be set by the constructor */ 
    private int[] bestPos;   // positions of search terms within document 
    private int startingPos; // beginning of minimum snippet 
    private int endingPos;   // end of minimum snippet 
         
    public MinimumSnippet(Iterable<String> document, List<String> terms) { 
        if (terms.isEmpty()) { 
            throw new IllegalArgumentException("Terms are empty"); 
        } 
        int[] recentPositionOfTerm = new int[terms.size()]; 
        int smallestSnippetLength = Integer.MAX_VALUE; 
 
        for (int i = 0; i < recentPositionOfTerm.length; i++) { 
            recentPositionOfTerm[i] = Integer.MIN_VALUE; 
        } 
 
        int currIndex = -1; 
        for (String currWord : document) { 
            currIndex++;   // index of currWord in the document 
            int termNumber = terms.indexOf(currWord); 
            if (termNumber < 0) { 
                continue; // not a term we're looking for 
            } 
            recentPositionOfTerm[termNumber] = currIndex; 
            int leftmostPosition = findSmallest(recentPositionOfTerm); 
            if (leftmostPosition == Integer.MIN_VALUE) { 
                continue; // haven't found all terms yet 
            } 
            int snippetLength = currIndex - leftmostPosition + 1; 
            if (snippetLength < smallestSnippetLength) {  // found new best snippet 
                smallestSnippetLength = snippetLength; 
                bestPos = Arrays.copyOf(recentPositionOfTerm, recentPositionOfTerm.length); 
                startingPos = leftmostPosition; 
                endingPos = currIndex; 
            } 
        } 
    } 
 
    private int findSmallest(int[] pos) { 
        int result = Integer.MAX_VALUE; 
        for (int p : pos) { 
            if (result > p) { 
                result = p; 
            }        
        } 
        return result; 
    } 
 
    public boolean foundAllTerms() { 
        return bestPos != null; 
    } 
 
    public int getStartingPos() { 
        return startingPos; 
    } 
 
    public int getEndingPos() { 
        return endingPos; 
    } 
 
    public int getLength() { 
        return endingPos - startingPos + 1; 
    } 
 
    public int getPos(int index) { 
        return bestPos[index]; 
    } 
 
}
