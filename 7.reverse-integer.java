/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            // Check for overflow before multiplying by 10
            if (res > Integer.MAX_VALUE / 10 ||
                (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0; // Overflow detected for positive numbers
            }
            if (res < Integer.MIN_VALUE / 10 ||
                (res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                    return 0; // Overflow detected for negative numbers
            } 

            res = 10 * res + digit;
        }
        return res;
    }
}
// @lc code=end

