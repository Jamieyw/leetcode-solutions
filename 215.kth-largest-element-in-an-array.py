#
# @lc app=leetcode id=215 lang=python3
#
# [215] Kth Largest Element in an Array
#

# @lc code=start
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         # The heapq.nlargest() method returns a list containing the 
#         # n largest elements from the iterable, sorted in descending order.
#         return heapq.nlargest(k, nums)[-1]

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def quickSelect(nums, k):
            pivot = random.choice(nums)
            left, mid, right = [], [], []

            for num in nums:
                if num > pivot:
                    right.append(num)
                elif num < pivot:
                    left.append(num)
                else:
                    mid.append(num)
            
            if k <= len(right):
                return quickSelect(right, k)
            elif k > len(right) + len(mid):
                return quickSelect(left, k - len(right) - len(mid))
            else:
                return pivot
            
        return quickSelect(nums, k)
        
# @lc code=end

