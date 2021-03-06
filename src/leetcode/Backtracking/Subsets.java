package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets (no duplicates).
 * Subsets : https://leetcode.com/problems/subsets/
 * https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    //Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	/* Values of i 
	 * 0 -> recursion -> 1 -> recursion -> 2
	 *                                     |-> (backtrack)1 -> recursion -> 2
	 * 1 -> recursion -> 2
	 * 2
	 */
	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int[] nums, int start){
		list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	public static void main(String[] args){
		Subsets s = new Subsets();
		int[] nums = {1,2,3};
		List<List<Integer>> result = s.subsets(nums);
		for(List<Integer> r : result){
			System.out.println(r.toString());
		}		
	}
}
