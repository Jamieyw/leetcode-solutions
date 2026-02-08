#
# @lc app=leetcode id=605 lang=python3
#
# [605] Can Place Flowers
#

# @lc code=start
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        count = 0
        i = 0
        while i < len(flowerbed):
            if flowerbed[i] == 0:
                empty_left_plot = (i == 0) or (flowerbed[i - 1] == 0)
                empty_right_plot = (i == len(flowerbed) - 1) or (flowerbed[i + 1] == 0)
                if empty_left_plot and empty_right_plot:
                    count += 1
                    # Instead of flowerbed[i] = 1, we skip the next index because we know we can't plant there.
                    i += 2
                else:
                    i += 1
            else:
                # If current spot is a 1, the next spot MUST be empty, so we can skip ahead 2 spots.
                i += 2

            if count >= n:
                return True
        return count >= n
        
# @lc code=end

