/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Keys in a hash table must be immutable, so we can't use int[] directly as a key. 
        // Instead, we'll convert int[] to a String to ensure immutability.
        Map<String, List> map = new HashMap<>();
        int[] cnt = new int[26];

        for (String str : strs) {
            Arrays.fill(cnt, 0);
            for (char c : str.toCharArray()) {
                cnt[c - 'a']++;
            }

            // Convert int[] cnt to a String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt.length; i++) {
                sb.append('#');
                sb.append(cnt[i]);
            }
            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
// @lc code=end

