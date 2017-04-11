package leetcode.Strings;

import java.util.HashSet;

/*
 * https://leetcode.com/problems/longest-palindrome/#/description
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * 
 * Input:      Output:
  "abccccdd"     7
 */
public class LongestPalindromeLength {
	public int longestPalindrome(String s) {
		if(s==null || s.length()==0) return 0;
		HashSet<Character> hs = new HashSet<Character>();
		int count = 0;
		for(int i=0; i<s.length(); i++){
			if(hs.contains(s.charAt(i))){
				hs.remove(s.charAt(i));
				count++;
			}else{
				hs.add(s.charAt(i));
			}
		}
		if(!hs.isEmpty()) return count*2+1;
		return count*2;
	}
}
