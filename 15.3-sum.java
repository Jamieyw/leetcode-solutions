/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip the same number
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Using two pointers to find the other two numbers that sum up to -nums[i]
            int target_sum = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int curr_sum = nums[l] + nums[r];
                if (curr_sum < target_sum) {
                    l++;
                    continue;
                }
                if (curr_sum > target_sum) {
                    r--;
                    continue;
                }
                // When curr_sum == target_sum
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                // Skip the same number for the 2nd num (and thus the 3rd num)
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

