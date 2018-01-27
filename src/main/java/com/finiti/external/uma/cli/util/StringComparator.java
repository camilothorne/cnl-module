package com.finiti.external.uma.cli.util;

import java.util.Comparator;

/**
 * Custom string comparator: sort (1) by length,
 * and then (2) by lexicographic order
 * 
 * @author Camilo Thorne
 *
 */
public class StringComparator implements Comparator<String> {

	@Override
    public int compare(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            // sort by length
        	return s1.length()-s2.length(); //overflow impossible since lengths are non-negative
        }
        // sort by lexicographic order
        return s1.compareTo(s2);
    }

}
