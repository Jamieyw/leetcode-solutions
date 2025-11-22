/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // key: character
        // value: index of the character in the string s
        Map<Character, Integer> mp = new HashMap<>();

        int leftP = 0;
        int maxLength = 0;

        for (int rightP = 0; rightP < s.length(); rightP++) {
            if (mp.containsKey(s.charAt(rightP))) {
                // If the current character has been seen before, move the left pointer to the right of the last occurrence of the current character.
                // However, we need to ensure that the left pointer only moves forward. Therefore, we compare the current position of leftP
                // with the position right after the last occurrence of the current character and pick the larger one.
                leftP = Math.max(mp.get(s.charAt(rightP)) + 1, leftP);
            }
            mp.put(s.charAt(rightP), rightP);
            maxLength = Math.max(maxLength, rightP - leftP + 1);
        }

        return maxLength;
    }


    // // brute force
    // public int lengthOfLongestSubstring(String s) {
    //     int maxLength = 0;
    //     int n = s.length();

    //     // enumerate all the substrings of s
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             if (checkRepetition(s, i, j)) {
    //                 maxLength = Math.max(maxLength, j - i + 1);
    //             }
    //         }
    //     }

    //     return maxLength;
    // }

    // /**
    //  * Checks if the substring of the given string `s` from index `a` to index `b` contains any repeating characters.
    //  * Returns true if no characters are repeated within the specified range.
    //  *
    //  * @param s the string to check
    //  * @param a the start index of the substring (inclusive)
    //  * @param b the end index of the substring (inclusive)
    //  * @return true if the substring has no repeating characters, false otherwise
    //  */
    // private boolean checkRepetition(String s, int a, int b) {
    //     Set<Character> chars = new HashSet<>();

    //     for (int i = a; i <= b; i++) {
    //         char c = s.charAt(i);
    //         if (chars.contains(c)) {
    //             return false;
    //         }
    //         chars.add(c);
    //     }

    //     return true;
    // }
}
// @lc code=end

