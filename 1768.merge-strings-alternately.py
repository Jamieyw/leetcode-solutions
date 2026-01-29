#
# @lc app=leetcode id=1768 lang=python3
#
# [1768] Merge Strings Alternately
#

# @lc code=start
class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = []
        n1, n2 = len(word1), len(word2)
        i = 0

        while i < n1 or i < n2:
            if i < n1:
                res.append(word1[i])
            if i < n2:
                res.append(word2[i])
            i += 1

        return "".join(res)
        
# @lc code=end

