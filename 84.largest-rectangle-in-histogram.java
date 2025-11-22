/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            // When i == n, we have reached the end and need to calculate the max area for the remaining bars in the stack (in ascending order)
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {  // i == n must be in front of || to avoid ArrayIndexOutOfBoundsException
                int currHeight = heights[stack.pop()];
                int currWidth = stack.isEmpty() ? i : i - stack.peek() - 1;  // when i == n, currWidth = n - stack.peek() - 1 
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // public int largestRectangleArea(int[] heights) {
    //     int n = heights.length;
    //     int maxArea = 0;
    //     Stack<Integer> stack = new Stack<>();
    //     stack.push(-1);

    //     for (int i = 0; i < n; i++) {
    //         while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
    //             int currHeight = heights[stack.pop()];
    //             int currWidth = i - stack.peek() - 1;
    //             maxArea = Math.max(maxArea, currHeight * currWidth);
    //         }
    //         stack.push(i);
    //     }

    //     // The remaining bars are in ascending order
    //     while (stack.peek() != -1) {
    //         int currHeight = heights[stack.pop()];
    //         int currWidth = n - stack.peek() - 1;
    //         maxArea = Math.max(maxArea, currHeight * currWidth);
    //     }

    //     return maxArea;
    // }
}
// @lc code=end

