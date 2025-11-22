/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
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

// // Approach 1: Recursive DFS
// class Solution {
//     private boolean validate(TreeNode node, Integer low, Integer high) {
//         if (node == null) {
//             return true;
//         }
//         if ((low != null && low >= node.val) || (high != null && high <= node.val)) {
//             return false;
//         }
//         return (validate(node.left, low, node.val) && validate(node.right, node.val, high));
//     }

//     public boolean isValidBST(TreeNode root) {
//         return validate(root, null, null);   
//     }
// }


// // Approach 2: Iterative DFS (Preorder)
// class Solution {
//     private Deque<TreeNode> stack = new LinkedList<>();
//     private Deque<Integer> lowerLimits = new LinkedList<>();
//     private Deque<Integer> upperLimits = new LinkedList<>();

//     private void update(TreeNode node, Integer low, Integer high) {
//         stack.add(node);
//         lowerLimits.add(low);
//         upperLimits.add(high);
//     }

//     public boolean isValidBST(TreeNode root) {
//         // Adding a null to a Deque in Java won't throw an error or make the stack empty
//         // It will actually add null as a legitimate element in the collection.
//         update(root, null, null);

//         while (!stack.isEmpty()) {
//             TreeNode curr = stack.poll();
//             Integer low = lowerLimits.poll();
//             Integer high = upperLimits.poll();

//             if (curr == null) {
//                 continue;
//             }

//             if ((low != null && low >= curr.val) || (high != null && high <= curr.val)) {
//                 return false;
//             }

//             // FILO -> root - left - right (Preorder)
//             update(curr.right, curr.val, high);
//             update(curr.left, low, curr.val);
//         }
//         return true;
//     }
// }


// // Approach 3: Recursive Inorder Traversal
// // Step 1: Compute inorder traversal list inorder.
// // Step 2: Check if each element in inorder is smaller than the next one.
// class Solution {
//     // We use Integer instead of int as it supports a null value.
//     private Integer prev;

//     public boolean isValidBST(TreeNode root) {
//         prev = null;
//         return inorder(root);
//     }

//     private boolean inorder(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
//         // Check left subtree
//         if (!inorder(root.left)) {
//             return false;
//         }
//         // Check current node: it should be greater than prev
//         if (prev != null && root.val <= prev) {
//             return false;
//         }
//         prev = root.val;
//         // Check right subtree
//         return inorder(root.right);
//     }
// }


// Approach 4: Iterative Inorder Traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            // Go left as far as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process current node
            curr = stack.pop();
            if (prev != null && curr.val <= prev) {
                return false;
            }
            prev = curr.val;
    
            // Move to right subtree
            curr = curr.right;
        }

        return true;
    }
}

// @lc code=end

