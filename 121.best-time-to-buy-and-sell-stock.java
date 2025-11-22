/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
import java.lang.Integer;

class Solution {
    public int maxProfit(int[] prices) {
        // Approach 1: Dynamic Programming
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE; // In case prices is empty

        for (int price : prices) {
            int curr_profit = price - minPrice;
            if (curr_profit > maxProfit) {
                maxProfit = curr_profit;
            }
            
            if (price < minPrice) {
                minPrice = price;
            }
        }
        return maxProfit;

        // // Approach 2: Two Pointers
        // int maxProfit = 0;
        // int l = 0;
        // int r = 1;

        // while (r < prices.length) {
        //     if (prices[l] < prices[r]) {
        //         maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
        //     } else {
        //         l = r;
        //     }
        //     r++;
        // }
        // return maxProfit;
    }
}
// @lc code=end

