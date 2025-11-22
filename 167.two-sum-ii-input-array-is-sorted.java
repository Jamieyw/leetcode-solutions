/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // For sorted array numbers:
        // HashMap method: O(n) time, O(n) space
        // Two pointers method: O(n) time, O(1) space
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int curr_sum = numbers[left] + numbers[right];
            if (curr_sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (curr_sum < target) {
                left++;
            } else { // curr_sum > target
                right--;
            }
        }
        return new int[0];
    }
}
// @lc code=end

