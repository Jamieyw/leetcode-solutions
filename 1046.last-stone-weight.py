#
# @lc app=leetcode id=1046 lang=python3
#
# [1046] Last Stone Weight
#

# @lc code=start
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-stone for stone in stones]
        heapq.heapify(stones)

        while (len(stones) > 1):
            stone1 = heapq.heappop(stones)
            stone2 = heapq.heappop(stones)
            if (stone1 != stone2):
                heapq.heappush(stones, stone1 - stone2)
        
        return -heapq.heappop(stones) if stones else 0
        
# @lc code=end

