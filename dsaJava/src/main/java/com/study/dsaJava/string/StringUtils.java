package com.study.dsaJava.string;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {

	public static boolean isPalindrome(String str) {
		char[] chaeArray= str.toCharArray();
		
		int start=0;
		int end=str.length()-1;
		while(start<end) {
			if (chaeArray[start] != chaeArray[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
		
	}
   public static boolean isSubsequence(String str, String seq) {
      int i = 0; // traverse str "abcde"
      int j = 0; // traverse seq "aec"

      while (i < str.length() && j < seq.length()) {
         if (str.charAt(i) == seq.charAt(j)) {
            j++;
         }
         i++;
      }
      return j == seq.length();
   }

   public static String removeVowels(String str) {
    //  Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
      Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
      StringBuilder sb = new StringBuilder();

      char[] chars = str.toCharArray();
      for (Character ch : chars) {
         if (!vowels.contains(ch)) { // c b j k O(1)
            sb.append(ch);
         }
      }
      return sb.toString();
   }

   public static int firstNonRepeatingCharacter(String str) {
      Map<Character, Integer> characterFrequencyMap = new HashMap<>();
      char[] chars = str.toCharArray(); // aba
      for (char ch : chars) {
         characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
      }

      for (int i = 0; i < chars.length; i++) {
         char ch = chars[i];
         if (characterFrequencyMap.get(ch) == 1) {
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(firstNonRepeatingCharacter("abafbabe"));
   }
}