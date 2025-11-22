/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int midSpeed = (left + right) / 2;
            int totalTime = 0;
            for (int pile : piles) {
                totalTime += Math.ceil((double) pile / midSpeed);
            }

            // No need for == check because: 
            // We want ninimun valid speed while multiple speeds might work.
            if (totalTime <= h) {
                right = midSpeed;
            } else { // totalTime > h: current speed is too slow
                left = midSpeed + 1;
            }
        }

        return right;
    }
}
// @lc code=end

