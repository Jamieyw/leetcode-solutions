/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Case 1: find target
            if (nums[mid] == target) {
                return mid;
            }
            // Comparing nums[mid] with target doesn't reveal if the target is on the left or right.
            // Therefore, compare nums[mid] with nums[left] to determine if the left or right subarray is sorted.

            // Case 2: subArray on mid's left is sorted
            else if (nums[mid] >= nums[left]) { // Handle the edge case where the subarray contains only one element.
                if (target >= nums[left] && target < nums[mid]) { // Case 1 has already considered target==nums[mid]
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Case 3: subarray on mid's right is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

