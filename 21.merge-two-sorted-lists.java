/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Approach 2: Iteration (Space Complexity: O(1))
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (list1 != null && list2 != null) { // End when either list1 or list2 is null
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else { // list1.val >= list2.val
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // At least one of l1 and l2 can still have nodes at this point, so connect the non-null list to the end of the merged list.
        prev.next = list1 == null ? list2 : list1;

        return preHead.next;

        // // Approach 1: Recursion (Space Complexity: O(n + m))
        // if (list1 == null) {
        //     return list2;
        // } else if (list2 == null) {
        //     return list1;
        // } else if (list1.val < list2.val) {
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // } else { // list1.val >= list2.val
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }
    }
}
// @lc code=end

