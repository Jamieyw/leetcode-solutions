/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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

// Approach 2: Iteration
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        // groupPrev is the node before the group
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            // groupNext is the node after the group
            ListNode groupNext = kth.next;

            // reverse the group
            ListNode prev = kth.next;  // prev is the node after the unreversed group
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}

//  // Approach 1: Recursion
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode curr = head;
//         int count = 0;

//         while (curr != null && count < k) {
//             curr = curr.next;
//             count++;
//         }

//         if (count == k) {
//             curr = reverseKGroup(curr, k);
//             // reverse the current k-group
//             while (count-- > 0) {
//                 // Move the current first element (head) to the end of the unreversed list
//                 ListNode nextNode = head.next;
//                 head.next = curr;
//                 curr = head;
//                 head = nextNode;
//             }
//             head = curr;
//         }
//         return head;
//     }
// }
// @lc code=end

