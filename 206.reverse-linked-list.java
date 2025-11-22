/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // Approach 1: Iterative (Space complexity : O(1))
        ListNode curr = head;
        // Since a node does not have reference to its previous node, we must store its previous element beforehand.
        ListNode prev = null;

        while (curr != null) {  // (1 ← 2)(prev) ←  3(curr)  → (4 → Ø)(nextTemp)
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;

        
        // // Approach 2: Recursive (Space complexity: O(n))
        
        // // base case
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // // recursive case: n1 → … → nk → nk+1 ← … ← nm
        // ListNode newHead = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return newHead;
    }
}
// @lc code=end

