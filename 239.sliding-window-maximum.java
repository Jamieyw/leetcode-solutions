/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // In this deque, all elements are maintained in decreasing order.
        // If the previous element is less than or equal to the current one, we remove the previous element.
        Deque<Integer> dq = new LinkedList<>();

        int left = 0;
        int right = 0;
        while (right < n) {
            // Step 1: Look into the window and update the deque
            // Step 1.1: Add the new right index to the deque and remove any elements that are smaller or equal to nums[right]
            while (!dq.isEmpty() && nums[right] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(right);

            // Step 1.2: If the element at dq.getFirst() is out of the current window, remove it
            if (dq.getFirst() == left - 1) {
                dq.removeFirst();
            }

            // Step 2: Update the result array and pointers
            // Once the window is fully within the array, add the maximum element to the result array and move the left pointer
            if (right >= k - 1) {
                res[left] = nums[dq.getFirst()];
                left++;
            }
            right++;
        }

        return res;
    }
}
// @lc code=end

