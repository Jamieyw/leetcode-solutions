/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
import java.lang.Math;

class Solution {
    public int maxArea(int[] height) {
        // Two Pointers Method
        int l = 0;
        int r = height.length - 1;

        int max_area = 0;

        while (l < r) {
            int curr_area = (r - l) * Math.min(height[l], height[r]);
            max_area = Math.max(max_area, curr_area);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max_area;
    }
}
// @lc code=end

