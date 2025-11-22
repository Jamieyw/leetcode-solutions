/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// // Approach 1: Recursive Inorder Traversal
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         List<Integer> inOrderNodes = new ArrayList<>();
//         dfs(root, inOrderNodes);
//         return inOrderNodes.get(k - 1);
//     }

//     private void dfs(TreeNode root, List<Integer> arr) {
//         if (root == null) {
//             return;
//         }
//         dfs(root.left, arr);
//         arr.add(root.val);
//         dfs(root.right, arr);
//     }
// }

// Approach 2: Iterative Inorder Traversal
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            
            curr = curr.right;
        }

        return -1;
    }
}
// @lc code=end

