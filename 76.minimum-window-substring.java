/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.Map;
import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int[] subIndex = new int[]{-1, -1};
        int have = 0, need = tCount.size();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt((right));
            // update window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // update have only when the count of c in window is equal to the count of c in t
            // If the count of c in window is larger than the count of c in t, we don't need to update have,
            // because we already have enough c in window, no need to count it again.
            if (tCount.containsKey(c) && window.get(c).equals(tCount.get(c))) {
                have++;
            }

            // When have == need, we have found a valid window 
            // Now, we try to move the 'left' pointer to find a smaller valid window.
            while (have == need) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    subIndex[0] = left;
                    subIndex[1] = right;
                }

                // Move the 'left' pointer to shrink the window.
                char leftChar = s.charAt(left);
                left++;
                window.put(leftChar, window.get(leftChar) - 1);

                // Update 'have' if the count of 'leftChar' in the window falls below its count in t string.
                if (tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
            }
        }

        return subIndex[0] == -1 ? "" : s.substring(subIndex[0], subIndex[1] + 1);
    }
}
// @lc code=end

