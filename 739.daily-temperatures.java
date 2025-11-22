/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

// import java.util.Deque;
// import java.util.ArrayDeque;
// import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // // Approach 1: Monotonic stack (using stack pair)
        // int n = temperatures.length;
        // int[] ans = new int[n];
        // Stack<int[]> stack = new Stack<>();  // pair: [temp, index]

        // for (int i = 0; i < n; i++) {
        //     int temp = temperatures[i];
        //     while (!stack.empty() && temp > stack.peek()[0]) {
        //        int[] pair = stack.pop();
        //        ans[pair[1]] = i - pair[1];
        //     }
        //     stack.push(new int[]{temp, i});
        // }

        // return ans;


        // // Approach 2: Monotonic stack (using stack index)
        // int n = temperatures.length;
        // int[] ans = new int[n];
        // Deque<Integer> stack = new ArrayDeque<Integer>();

        // for (int currDay = 0; currDay < n; currDay++) {
        //     // Pop until the current day's temperature is not
        //     // warmer than the temperature at the top of the stack
        //     while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
        //         int prevDay = stack.pop();
        //         ans[prevDay] = currDay - prevDay;
        //     }
        //     stack.push(currDay);
        // }
        
        // return ans;


        // Approach 3: Array (Optimized Space: using ans' info)
        int n = temperatures.length;
        int hottest = 0;  // this process does not work for a day that does not have a warmer day in the future
        int[] ans = new int[n];

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currTemp = temperatures[currDay];

            if (currTemp >= hottest) {
                hottest = currTemp;
                continue;  // no need to look further
                // Prevent index out of bounds for the last day in the following code: temperatures[currDay + days]
            }

            int days = 1;
            while (temperatures[currDay + days] <= currTemp) {
                // Use information from answer to search for the next warmer day
                days += ans[currDay + days];
            }
            ans[currDay] = days;
        }

        return ans;
    }
}
// @lc code=end

