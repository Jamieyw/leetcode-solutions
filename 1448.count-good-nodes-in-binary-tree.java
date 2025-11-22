/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
 */

// @lc code=start

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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

// The traversal order doesn't matter in this problem.

// Approach 3: BFS
class Pair {
    TreeNode node;
    int maxSoFar;

    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (curr.node.val >= curr.maxSoFar) {
                numGoodNodes++;
            }
            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
            }
            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
            }
        }

        return numGoodNodes;
    }
}

// // Approach 2: Iterative DFS
// class Pair {
//     public TreeNode node;
//     public int maxSoFar;

//     public Pair(TreeNode node, int maxSoFar) {
//         this.node = node;
//         this.maxSoFar = maxSoFar;
//     }
// }
// class Solution {
//     public int goodNodes(TreeNode root) {
//         int numGoodNodes = 0;
//         Stack<Pair> stack = new Stack<>();
//         stack.push(new Pair(root, Integer.MIN_VALUE));

//         while (!stack.isEmpty()) {
//             Pair curr = stack.pop();
//             if (curr.node.val >= curr.maxSoFar) {
//                 numGoodNodes++;
//             }
//             if (curr.node.left != null) {
//                 stack.push(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
//             }
//             if (curr.node.right != null) {
//                 stack.push(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
//             }
//         }

//         return numGoodNodes;
//     }
// }

// // Approach 1: Recursive DFS
// class Solution {
//     public int goodNodes(TreeNode root) {
//         return dfs(root, root.val);
//     }

//     private int dfs(TreeNode node, int maxVal) {
//         if (node == null) {
//             return 0;
//         }

//         int goodNodes = 0;
//         if (node.val >= maxVal) {
//             goodNodes++;
//             maxVal = node.val;
//         }
//         goodNodes += dfs(node.left, maxVal);
//         goodNodes += dfs(node.right, maxVal);
//         return goodNodes;
//     }
// }
// @lc code=end

