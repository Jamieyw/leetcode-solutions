/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1, s2 are lowercase English letters
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // We don't need to compare the 2 hashmaps (s1Count and s2Count) directly,
        // because we can keep track of one more variable: matchCount
        int matchCount = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matchCount++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matchCount == 26) {
                return true;
            }

            // Add the new character
            int newCharIndex = s2.charAt(r) - 'a';
            s2Count[newCharIndex]++;
            // Check if the new character is matched or mismatched
            if (s1Count[newCharIndex] == s2Count[newCharIndex]) {
                matchCount++;
            } else if (s1Count[newCharIndex] + 1 == s2Count[newCharIndex]) {
                matchCount--;
            }

            // Delete the old character
            int oldCharIndex = s2.charAt(l) - 'a';
            s2Count[oldCharIndex]--;
            // Check if the old character is matched or mismatched
            if (s1Count[oldCharIndex] == s2Count[oldCharIndex]) {
                matchCount++;
            } else if (s1Count[oldCharIndex] - 1 == s2Count[oldCharIndex]) {
                matchCount--;
            }

            l++;
        }
        return matchCount == 26;
    }
}
// @lc code=end

