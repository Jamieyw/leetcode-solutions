#
# @lc app=leetcode id=621 lang=python3
#
# [621] Task Scheduler
#

# @lc code=start
# class Solution:
#     def leastInterval(self, tasks: List[str], n: int) -> int:
#         count = Counter(tasks)
#         maxHeap = [-cnt for cnt in count.values()]
#         heapq.heapify(maxHeap)

#         time = 0
#         q = deque() # pairs of [-cnt, idleTime]

#         while maxHeap or q:
#             time += 1
            
#             if maxHeap:
#                 cnt = 1 + heapq.heappop(maxHeap)
#                 if cnt:
#                     q.append([cnt, time + n])
            
#             if q and q[0][1] == time:
#                 heapq.heappush(maxHeap, q.popleft()[0])
        
#         return time

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = [0] * 26
        for task in tasks:
            count[ord(task) - ord('A')] += 1

        count.sort()
        maxFreq = count[25]
        idleSlot = (maxFreq - 1) * n

        for i in range(24, -1, -1):
            # special case: count[i] == maxFrea -> (AB)_(AB)
            idleSlot -= min(maxFreq - 1, count[i])
        return max(0, idleSlot) + len(tasks)

# @lc code=end

