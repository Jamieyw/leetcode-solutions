/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0;

        // Use an array int[26] to store the frequency of uppercase English letters in the window will be faster
        Map<Character, Integer> charFreq = new HashMap<>();

        // Keep track of the max count of a character in the window
        int maxCount = 0;

        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            charFreq.put(currChar, charFreq.getOrDefault(currChar, 0) + 1);

            // Update maxCount
            maxCount = Math.max(maxCount, charFreq.get(currChar));

            // If window size - maxCount > k, we need to shrink the window: 
            // remove the leftmost character from the window

            // Because we move the right pointer one step at a time, the left pointer will only move one step at a time too
            // No need to use a while loop here
            if ((r - l + 1) - maxCount > k) {
                // We don't need to update maxCount here because the maxCount will remain the same,
                // we only need to update it when it increases and overpasses the previous maxCount
                char outGoingChar = s.charAt(l);
                charFreq.put(outGoingChar, charFreq.get(outGoingChar) - 1);
                l++;
            }

            // Update res while the window is valid
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
// @lc code=end

