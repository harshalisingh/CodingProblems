package leetcode.LinkedList;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicateLinkedList {
	//LeetCode
	public static ListNode removeDuplicates(ListNode head){
		ListNode current = head;
		while(current != null && current.next != null){
			if(current.val == current.next.val){
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}
