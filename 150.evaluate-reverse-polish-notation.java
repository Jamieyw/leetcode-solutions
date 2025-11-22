/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operandStack = new Stack<>();
        for (String token : tokens) {
            try {
                // Try to parse as number
                operandStack.push(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                // Handle operators
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int newOperand;

                if (token.equals("+")) {
                    newOperand = operand1 + operand2;
                } else if (token.equals("-")) {
                    newOperand = operand1 - operand2;
                } else if (token.equals("*")) {
                    newOperand = operand1 * operand2;
                } else {  // truncate towards 0 with division
                    // In Java, integer division truncates towards zero.
                    // For example, -7 / 3 will result in -2.
                    newOperand = operand1 / operand2;
                }
                operandStack.push(newOperand);
            }
        }
        return operandStack.pop();
    }

    // Another syntax:
    // public int evalRPN(String[] tokens) {
    //     Stack<Integer> stack = new Stack<>();

    //     for (String token : tokens) {
    //         if (!"+-*/".contains(token)) {
    //             stack.push(Integer.valueOf(token));
    //             continue;
    //         }

    //         int number2 = stack.pop();
    //         int number1 = stack.pop();

    //         int result = 0;

    //         switch (token) {
    //             case "+":
    //                 result = number1 + number2;
    //                 break;
    //             case "-":
    //                 result = number1 - number2;
    //                 break;
    //             case "*":
    //                 result = number1 * number2;
    //                 break;
    //             case "/":
    //                 result = number1 / number2;
    //                 break;
    //         }

    //         stack.push(result);
    //     }

    //     return stack.pop();
    // }
}
// @lc code=end

