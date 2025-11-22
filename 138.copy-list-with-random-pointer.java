/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.Map;
import java.util.HashMap;

// Approach 3: Iterative with O(1) Space
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a new weaved list of original and copied node.
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Link the random pointers of the new nodes created.
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        // Step 3: Unweave the linked list to get back the original linked list and the cloned list.
        Node ptr_old_list = head;  // ptr is short for pointer
        Node ptr_new_list = head.next;
        Node new_head = head.next;
        while(ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        
        return new_head;
    }
}


// // Approach 2: HashMap (One Pass)
// class Solution {
//     Map<Node, Node> visited = new HashMap<>();

//     public Node getClonedNode(Node node) {
//         if (node == null) {
//             return null;
//         } else {
//             if (this.visited.containsKey(node)) {
//                 return this.visited.get(node);
//             } else {
//                 this.visited.put(node, new Node(node.val, null, null));
//                 return this.visited.get(node);
//             }
//         }
//     }

//     public Node copyRandomList(Node head) {
//         if (head == null) {
//             return null;
//         }

//         Node oldNode = head;
//         Node newNode = new Node(oldNode.val);
//         this.visited.put(oldNode, newNode);

//         while (oldNode != null) {
//             newNode.next = this.getClonedNode(oldNode.next);
//             newNode.random = this.getClonedNode(oldNode.random);

//             oldNode = oldNode.next;
//             newNode = newNode.next;
//         }

//         return this.visited.get(head);
//     }
// }


// // Approach 1: HashMap (Two Pass)
// class Solution {
//     public Node copyRandomList(Node head) {
        // Map<Node, Node> oldToCopy = new HashMap<>();
        // oldToCopy.put(null, null);

        // Node curr = head;
        // while (curr != null) {
        //     Node copy = new Node(curr.val);
        //     oldToCopy.put(curr, copy);
        //     curr = curr.next;
        // }

        // curr = head;
        // while (curr != null) {
        //     Node copy = oldToCopy.get(curr);
        //     copy.next = oldToCopy.get(curr.next);
        //     copy.random = oldToCopy.get(curr.random);
        //     curr = curr.next;
        // }

        // return oldToCopy.get(head);
//     }
// }
// @lc code=end

