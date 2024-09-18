import java.util.Arrays;
import java.util.Comparator;


/**
 * Autocomplete.
 */
public class Autocomplete {

	private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) {
	    if(terms == null) {
            throw new NullPointerException("Terms cannot be null!");   
        }
        this.terms = terms;
        Arrays.sort(terms);
    }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
	public Term[] allMatches(String prefix) {
	    if(prefix == null) {
            throw new NullPointerException("Prefix can't be null!");
        }
        
        Term ac = new Term(prefix, 0);
        Comparator<Term> order = Term.byPrefixOrder(prefix.length());
        int a = BinarySearch.firstIndexOf(this.terms, ac, order);
        int b = BinarySearch.lastIndexOf(this.terms, ac, order);
        int c = a;
        Term[] myTerms = new Term[b - a];
        for(int index = 0; index < b - a; index++) {
            myTerms[index] = this.terms[index];
            c++;
        }
        Arrays.sort(myTerms, Term.byDescendingWeightOrder());
        return myTerms;
        
    }

}

