/*
 * @lc app=leetcode id=1823 lang=java
 *
 * [1823] Find the Winner of the Circular Game
 */

// @lc code=start
class Solution {
    // Iterative Solution <- Resursive Solution 2
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return res + 1;
    }

    // // Resursive Solution 1
    // public int findTheWinner(int n, int k) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     // people are numbered from 1 to n
    //     return (findTheWinner(n - 1, k) + k - 1) % n + 1;
    // }

    // // Resursive Solution 2
    // public int findTheWinner(int n, int k) {
    //     // people are numbered from 1 to n
    //     return winnerHelper(n, k) + 1;
    // }
        
    // // Helper function where people are numbered from 0 to n-1
    // private int winnerHelper(int n, int k) {
    //     if (n == 1) {
    //         return 1;
    //     }
    //     // We want to find the relationship: f(n, k) = ?f(n-1, k)
    //     // We just need to eliminate one person and find the relationship.
    //     return (winnerHelper(n - 1, k) + k) % n;
    // }
}
// @lc code=end

