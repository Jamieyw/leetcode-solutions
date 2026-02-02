#
# @lc app=leetcode id=1071 lang=python3
#
# [1071] Greatest Common Divisor of Strings
#

# @lc code=start
class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if str1 + str2 != str2 + str1:
            return ""
        # If a number $d$ is a divisor of both a and b, then d must also divide the result of (a - b).
        # By extension, if d divides a and b, it must also divide the remainder of a divided by b (which is just subtracting b from a multiple times).
        def get_int_gcd(a: int, b: int) -> int:
            while b:
                a, b = b, a % b
            return a
        
        gcd_len = get_int_gcd(len(str1), len(str2))
        return str1[:gcd_len]
        
# @lc code=end

