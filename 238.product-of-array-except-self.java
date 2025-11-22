/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // Calculate the product of all elements to the left of the current element i
            // and store it in res[i] -> prefix product
            res[i] = res[i - 1] * nums[i - 1];
        }

        int curr_sufix_product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= curr_sufix_product;
            curr_sufix_product *= nums[i];
        }

        return res;
    }
}
// @lc code=end

