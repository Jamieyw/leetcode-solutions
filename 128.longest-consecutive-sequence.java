/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest_length = 0; // nums can be empty
        for (int num : numSet) {
            // if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int curr_length = 1;
                while (numSet.contains(num + curr_length)) {
                    curr_length++;
                }
                longest_length = Math.max(longest_length, curr_length);
            }
        }
        return longest_length;
    }
}
// @lc code=end

