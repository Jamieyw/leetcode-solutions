#
# @lc app=leetcode id=345 lang=python3
#
# [345] Reverse Vowels of a String
#

# @lc code=start
class Solution:
    def reverseVowels(self, s: str) -> str:
        # 1. Convert to list because strings are immutable
        chars = list(s)
        
        # 2. Define vowels in a set for O(1) lookup speed
        # Include both upper and lower case!
        vowels = set("aeiouAEIOU")
        
        # 3. Initialize Two Pointers
        left, right = 0, len(chars) - 1
        
        while left < right:
            # Move left pointer until a vowel is found
            while left < right and chars[left] not in vowels:
                left += 1
            
            # Move right pointer until a vowel is found
            while left < right and chars[right] not in vowels:
                right -= 1
            
            # 4. Swap the vowels
            chars[left], chars[right] = chars[right], chars[left]
            
            # 5. Move pointers inward to avoid infinite loop
            left += 1
            right -= 1
            
        # 6. Join the list back into a string (The "String Builder" way)
        return "".join(chars)
        
# @lc code=end

