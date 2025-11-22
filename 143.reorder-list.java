/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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


 // Method 1 : Explicitly cut the list at slow.next (slow.next = null) to form two separate halves, then reverse the second half.
class Solution {
    public void reorderList(ListNode head) {
        // Step 1: find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        // Cut the second half from the first half. 
        // This is important to avoid forming an infinite loop when merging 1 → 2 → 3 → 4 ← 5
        // At some point, you still have that hidden pointer 3 → 4 in merged_list[1 → 5 → 2 → 4 → 3 → null], which was never nullified.
        slow.next = null;

        // Step 2: reverse the second half of the linked list (aka secondHead)
        ListNode curr = secondHead;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        ListNode newSecondHead = prev;

        // Step 3: merge two lists
        ListNode firstHead = head;
        while (newSecondHead != null) {
            ListNode leftFirst = firstHead.next;
            ListNode leftSecond = newSecondHead.next;
            firstHead.next = newSecondHead;
            newSecondHead.next = leftFirst;
            firstHead = leftFirst;
            newSecondHead = leftSecond;
        }
    }
}


// // Method 2: Start reversing from slow itself, which automatically splits the list (no explicit cut needed).
// class Solution {
//     public void reorderList(ListNode head) {
//         if (head == null) return;

//         // find the middle of linked list [Problem 876]
//         // in 1->2->3->4->5->6 find 4
//         ListNode slow = head, fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         // reverse the second part of the list [Problem 206]
//         // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
//         // reverse the second half in-place
//         ListNode prev = null, curr = slow, tmp;
//         while (curr != null) {
//             tmp = curr.next;

//             curr.next = prev;
//             prev = curr;
//             curr = tmp;
//         }

//         // merge two sorted linked lists [Problem 21]
//         // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
//         ListNode first = head, second = prev;
//         while (second.next != null) {
//             tmp = first.next;
//             first.next = second;
//             first = tmp;

//             tmp = second.next;
//             second.next = first;
//             second = tmp;
//         }
//     }
// }
// @lc code=end

