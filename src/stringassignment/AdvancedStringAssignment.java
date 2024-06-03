package stringassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdvancedStringAssignment {
  
	 public static Map<Character, Integer> charFrequency(String str) {
	        Map<Character, Integer> frequencyMap = new HashMap<>();
	        str = str.replaceAll("\\s+", ""); // Remove whitespace
	        for (char c : str.toCharArray()) {
	            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
	        }
	        return frequencyMap;
	    }

	 public static boolean isPalindrome(String str) {
	        str = str.replaceAll("\\s+", "").toLowerCase(); // Remove whitespace and convert to lowercase
	        int i = 0;
	        int j = str.length() - 1;
	        while (i < j) {
	            if (str.charAt(i++) != str.charAt(j--)) {
	                return false;
	            }
	        }
	        return true;
	    }

	 public static boolean areAnagrams(String str1, String str2) {
	        str1 = str1.replaceAll("\\s+", "").toLowerCase(); // Remove whitespace and convert to lowercase
	        str2 = str2.replaceAll("\\s+", "").toLowerCase(); // Remove whitespace and convert to lowercase
	        if (str1.length() != str2.length()) {
	            return false;
	        }
	        char[] s1Array = str1.toCharArray();
	        char[] s2Array = str2.toCharArray();
	        Arrays.sort(s1Array);
	        Arrays.sort(s2Array);
	        return Arrays.equals(s1Array, s2Array);
	    }
	 
	 
	
	  public static String longestUniqueSubstring(String str) {
	        String longestSubstring = "";
	        String currentSubstring = "";
	        Set<Character> set = new HashSet<>();
	        int start = 0;
	        for (int end = 0; end < str.length(); end++) {
	            char c = str.charAt(end);
	            if (!set.contains(c)) {
	                set.add(c);
	                currentSubstring = str.substring(start, end + 1);
	                if (currentSubstring.length() > longestSubstring.length()) {
	                    longestSubstring = currentSubstring;
	                }
	            } else {
	                while (str.charAt(start) != c) {
	                    set.remove(str.charAt(start));
	                    start++;
	                }
	                start++;
	            }
	        }
	        return longestSubstring;
	    }
	  
	  public static String compressString(String str)
	  {
		  if(str == null || str.isEmpty())
		  {
			  return str;
		  }
		  
		  StringBuilder compressed = new StringBuilder();
		  int count =1;
		  for(int i =1; i<=str.length();i++)
		  {
			  if(i == str.length() || str.charAt( i - 1)!= str.charAt(i))
			  {
				  compressed.append(str.charAt(i - 1));
				  compressed.append(count);
				  count = 1;
			  }
			  else {
				  count++;
			  }
		  }
		  return str.length() <= compressed.length() ? str : compressed.toString();
	  }
	  
	  public static List<String> findPermutations(String str)
	  {
		  List<String> permutations = new ArrayList<>();
		  permutationString(str, "", permutations);
		  return permutations;
	  }
	    private static void permutationString(String str, String current, List<String> permutations)
	    {
	    	if(str.length() == 0)
	    	{
	    		permutations.add(current);
	    		return;
	    	}
	    	for(int i=0; i<str.length(); i++)
	    	{
	    		char ch = str.charAt(i);
	    		String remaining = str.substring(0, i) + str.substring(i + 1);
	    		permutationString(remaining, current + ch, permutations);
	    	}
	    }
	  
	  public static String removeDuplicates(String str) {
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            if (result.indexOf(String.valueOf(c)) == -1) 
	            { // character not already present
	                result.append(c);
	            }
	        }
	        return result.toString();
	    }
	  
	  public static String reverseWords(String str) {
	        String[] words = str.split("\\s+"); // Split the string into words
	        StringBuilder reversed = new StringBuilder();
	        for (int i = words.length - 1; i >= 0; i--) 
	        {
	            reversed.append(words[i]).append(" "); // Append words in reverse order
	        }
	        return reversed.toString().trim(); // Remove starting and ending whitespace
	    }

		public static void main(String[] args) {
			System.out.println("Character Frequency :");
   			String testString = "ppaabcckcccaaa";
    		System.out.println(charFrequency(testString));
    		
    	    System.out.println("\nCheck Palindrome :");
    		String testString1 = "ABA";
    		System.out.println(isPalindrome(testString1));
    		
    		System.out.println("\nCheck Anagram :");
    		System.out.println( areAnagrams("Race", "Care"));
    		
    	    System.out.println("\nLongest Substring Without Repeating Characters :");
    	    String testString4 = "biggest";
    	    System.out.println(longestUniqueSubstring(testString4));
    	    
    	    System.out.println("\nString Compression :");
    	    System.out.println(compressString("aabcccccaaa"));
    	    
    	    System.out.println("\nFind All Permutations of a String : ");
    	    String str = "pqr";
    	    List<String> permutations = findPermutations(str);
    	    System.out.println(permutations);
    	    
    	    System.out.println("\nRemove Duplicate  Characters:");
    	     String testString3 ="propability";
            System.out.println(removeDuplicates(testString3));

            System.out.println("\nReverse Words in a String:");
            String testString2 = "Hello World";
            System.out.println(reverseWords(testString2));
		}
}