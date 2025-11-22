/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Approach: Bucket Sort
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        // List<Integer>[] freq = new List[nums.length + 1] creates an array of List references, but each element in the array is initially null.
        // To use these List references, you need to instantiate each element with a new ArrayList object.

        // Initialize each element of the freq array with a new ArrayList
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet()) {
            freq[count.get(num)].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int num : freq[i]) {
                res[index++] = num;
            }
        }

        return res;
    }
}
// @lc code=end

