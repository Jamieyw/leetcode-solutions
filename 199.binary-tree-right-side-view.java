/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

// Approach 2: Recursive DFS
class Solution {
    List<Integer> rightSide = new LinkedList<>();

    // The idea is simple: to traverse the tree level by level, starting each time from the rightmost child.
    private void helper(TreeNode node, int level) {
        if (level == rightSide.size()) {
            rightSide.add(node.val);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
        if (node.left != null) {
            helper(node.left, level + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return rightSide;
        }
        helper(root, 0);
        return rightSide;
    }
}


// // Approach 1: BFS
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> res = new LinkedList<>();
//         Queue<TreeNode> queue = new LinkedList<>();

//         if (root == null) {
//             return res;
//         }

//         queue.add(root);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
//                 if (i == size - 1) {
//                     res.add(curr.val);
//                 }
//                 if (curr.left != null) {
//                     queue.add(curr.left);
//                 }
//                 if (curr.right != null) {
//                     queue.add(curr.right);
//                 }
//             }
//         }
//         return res;
//     }
// }
// @lc code=end

