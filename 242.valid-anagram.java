/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

// Method 1: Using Hash Table if the inputs contain unicode characters
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         Map<Character, Integer> hashtable = new HashMap<>();

//         if (s.length() != t.length()) {
//             return false;
//         }

//         for (int i = 0; i < s.length(); i++) {
//             hashtable.put(s.charAt(i), hashtable.getOrDefault(s.charAt(i), 0) + 1);
//             hashtable.put(t.charAt(i), hashtable.getOrDefault(t.charAt(i), 0) - 1);
//         }

//         for (char key : hashtable.keySet()) {
//             if (hashtable.get(key) != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

// Method 2: Using Array
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

