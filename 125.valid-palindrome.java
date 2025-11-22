/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char left_char_lowercase = Character.toLowerCase(s.charAt(left));
            char right_char_lowercase = Character.toLowerCase(s.charAt(right));
            
            // skip non-alphanumeric characters
            if (!isAlphaNum(left_char_lowercase)) {
                left++;
                continue;
            }
            if (!isAlphaNum(right_char_lowercase)) {
                right--;
                continue;
            }

            if (left_char_lowercase != right_char_lowercase) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z' ||
                c >= '0' && c <= '9');
    }
}
// @lc code=end

