/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n, col = mid % n;
            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) right = mid - 1;
            else if (target > matrix[row][col]) left = mid + 1;
        }

        return false;
    }
}
// @lc code=end

