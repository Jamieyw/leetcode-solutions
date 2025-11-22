/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    private Map<String, List<Pair<Integer, String>>> keyTimeMap;

    public TimeMap() {
        keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList<>());
        }
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        // If the given 'timestamp' is earlier than the first timestamp for the 'key', return an empty string.
        if (timestamp < keyTimeMap.get(key).get(0).getKey()) {
            return "";
        }

        // Using binary search on the list of pairs
        int left = 0;
        int right = keyTimeMap.get(key).size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                result = keyTimeMap.get(key).get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

