/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int cnt = 0;
        while (true) {

            if (cnt >= strs[0].length()) {
                break;
            }

            char currChar = strs[0].charAt(cnt);
            for (String str : strs) {
                if (cnt >= str.length() || str.charAt(cnt) != currChar) {
                    return strs[0].substring(0, cnt);
                }
            }

            cnt += 1;
        }
        return strs[0].substring(0, cnt);
    }
}
// @lc code=end

