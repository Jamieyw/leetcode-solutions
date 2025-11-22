/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtracking(
        List<String> ans,
        StringBuilder currString,
        int leftCount,
        int rightCount,
        int n
    ) {
        if (currString.length() == 2 * n) {
            ans.add(currString.toString());
            return;  // stops immediately after reaching the base case
        }

        // Only add open paranthesis if leftCount < n
        if (leftCount < n) {
            currString.append("(");
            backtracking(ans, currString, leftCount + 1, rightCount, n);
            // After each recursive call, the last character added is removed (backtracked) to explore other possible combinations.
            // This is necessary because currString is a shared object among recursive calls, 
            // and we need to revert its state to what it was before the current recursive call to ensure correctness.
            currString.deleteCharAt(currString.length() - 1);
        }

        // Only add closing paranthesis if rightCount < leftCount
        if (rightCount < leftCount) {
            currString.append(")");
            backtracking(ans, currString, leftCount, rightCount + 1, n);
            currString.deleteCharAt(currString.length() - 1);  // delete ")" in the stack
        }
    }
}
// @lc code=end

