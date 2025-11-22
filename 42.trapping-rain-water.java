/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        int trapped_water = 0;

        int left_pointer = 0;
        int right_pointer = height.length - 1;        
        
        int left_max = height[left_pointer];
        int right_max = height[right_pointer];


        while (left_pointer < right_pointer) {
            if (left_max < right_max) {
                left_pointer += 1;
                left_max = Math.max(left_max, height[left_pointer]);
                trapped_water += left_max - height[left_pointer];
            } else { // left_max >= right_max
                right_pointer -= 1;
                right_max = Math.max(right_max, height[right_pointer]);
                trapped_water += right_max - height[right_pointer];
            }
        }

        return trapped_water;
    }
}
// @lc code=end

