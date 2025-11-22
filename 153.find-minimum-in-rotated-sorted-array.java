/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    // public int findMin(int[] nums) {
    //     int left = 0;
    //     int right = nums.length - 1;
    //     int res = nums[0];

    //     while (left <= right) {
    //         // If the subarray is already sorted, update the result with the minimum value
    //         if (nums[left] < nums[right]) {
    //             res = Math.min(nums[left], res);
    //             break;
    //         }

    //         int mid = left + (right - left) / 2;
    //         res = Math.min(nums[mid], res);
    //         // Check if the left half is sorted
    //         if (nums[mid] >= nums[left]) { // '=' handles the edge case when there's only one element
    //             // Move to the right half
    //             left = mid + 1;
    //         } else {
    //             // Move to the left half
    //             right = mid - 1;
    //         }
    //     }

    //     return res;
    // }


    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // Binary Search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // The order of these two if statements is crucial:
            // - Arrays like [1, 3] are handled before the while loop.
            // - Arrays like [3, 1] are caught by the first if statement, preventing IndexOutOfBoundsException.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
// @lc code=end

