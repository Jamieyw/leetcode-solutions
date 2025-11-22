/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    // Right-to-Left Pass
    public int romanToInt(String s) {
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = values.get(lastSymbol);
        int sum = lastValue;

        for (int i = s.length() - 2; i >= 0; i--) {
            String currSymbol = s.substring(i, i + 1);
            int currValue = values.get(currSymbol);
            if (currValue >= lastValue) {
                sum += currValue;
            } else {
                sum -= currValue;
            }
            lastValue = currValue;
        }

        return sum;
    }
}
// @lc code=end

