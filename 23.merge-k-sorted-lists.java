/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(merge2Lists(l1, l2));
            }
            // Convert mergedLists (a List<ListNode>) into an array of ListNode[].
            //  toArray(new ListNode[0]) dynamically creates an array of exactly the right size based on mergedLists’s length.
            // The new ListNode[0] ensures type correctness.
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (l1 != null) {
            point.next = l1;
        }
        if (l2 != null){
            point.next = l2;
        }
        return dummy.next;
    }
}
// @lc code=end

