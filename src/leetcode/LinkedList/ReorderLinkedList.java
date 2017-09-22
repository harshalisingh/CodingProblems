package leetcode.LinkedList;

/**
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,    reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * You must do this in-place without altering the nodes' values.
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * https://leetcode.com/problems/reorder-list/description/
 * Step1: Cut the list to two halves, Step2: Reverse 2nd half, Step3: Merge Two Halves
 */
public class ReorderLinkedList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		// step 1. cut the list to two halves
		// prev will be the tail of 1st half
		// slow will be the head of 2nd half
		ListNode prev = null, slow = head, fast = head, l1 = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		//break the two halves
		prev.next = null;

		// step 2. reverse the 2nd half
		ListNode l2 = reverse(slow);

		// step 3. merge the two halves
		merge(l1, l2);
	}

	ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	void merge(ListNode l1, ListNode l2) {
		while (l1 != null) {
			ListNode n1 = l1.next, n2 = l2.next;
			l1.next = l2;

			if (n1 == null)
				break;

			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}
}
