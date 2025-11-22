/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.HashMap;
import java.util.Stack;

// 11.24.2024
class Solution {
    private Map<Character, Character> closeToOpen;

    public Solution() {
        closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            // 1. closing bracket
            if (closeToOpen.containsKey(c)) {
                if (!bracketStack.isEmpty() && bracketStack.peek() == closeToOpen.get(c)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            } else { // 2. opening bracket
                bracketStack.push(c);
            }
        }
        return bracketStack.isEmpty();
    }
}

// class Solution {
//     private HashMap<Character, Character> mapping;
    
//     public Solution() {
//         mapping = new HashMap<>();
//         mapping.put(')', '(');
//         mapping.put('}', '{');
//         mapping.put(']', '[');
//     }

//     public boolean isValid(String s) {
//         Stack<Character> parenthesesStack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char currChar = s.charAt(i);

//             // If current character is a closing bracket
//             if (mapping.containsKey(currChar)) {
//                 if (parenthesesStack.isEmpty()) {
//                     return false;
//                 }
//                 char topParenthese = parenthesesStack.pop();
//                 if (topParenthese != mapping.get(currChar)) {
//                     return false;
//                 } 
//             } else {
//                 parenthesesStack.push(currChar);
//             }
//         }
//         return parenthesesStack.isEmpty();
//     }
// }
// @lc code=end

