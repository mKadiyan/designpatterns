package algorithm.prob;
//Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree
// It also handles cases even when n1 and n2 are not there in Tree
 
/* Class containing left and right child of current 
 node and key value*/
class Node {
 
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = right = null;
        
    }
}
 
public class BinaryTree {
 
    //Root of the Binary Tree
    Node root;
 
    Node findLCAUtil(boolean v1, boolean v2, int n1, int n2) {
        return findLCAUtil(root, v1, v2, n1, n2);
    }
    // This function returns pointer to LCA of two given values n1 and n2.
    // v1 is set as true by this function if n1 is found
   // v2 is set as true by this function if n2 is found
   Node findLCAUtil(Node node, boolean v1, boolean v2, int n1, int n2) {
        // Base case
        if (node == null) {
            return null;
        }
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.data == n1) {
            v1 = true;
            return node;
        }
        if (node.data == n2) {
            v2 = true;
            return node;
        }
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCAUtil(node.left, v1, v2, n1, n2);
        Node right_lca = findLCAUtil(node.right, v1, v2, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null) {
            return node;
        }
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    // Returns true if key k is present in tree rooted with root
    boolean find(Node node, int k) {
        // Base Case
        if (root == null) {
            return false;
        }
 
        // If key is present at root, or in left subtree or right subtree,
        // return true;
        if (node.data == k || find(node.left, k) || find(node.right, k)) {
            return true;
        }
 
        // Else return false
        return false;
    }
 
    // This function returns LCA of n1 and n2 only if both n1 and n2 are present
    // in tree, otherwise returns NULL;
    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }
 
    Node findLCA(Node node, int n1, int n2) {
        // Initialize n1 and n2 as not visited
        boolean v1 = false, v2 = false;
 
        // Find lca of n1 and n2 using the technique discussed above
        Node lca = findLCAUtil(v1, v2, n1, n2);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1)) {
            return lca;
        }
 
        // Else return NULL
        return null;
    }
    /* Driver program to test above functions */
 
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        Node lca = tree.findLCA(4, 5);
        if (lca != null) {
            System.out.println("LCA(4, 5) = " + lca.data);
        } else {
            System.out.println("Keys are not present");
        }
        lca = tree.findLCA(4, 7);
        if (lca != null) {
            System.out.println("LCA(4, 10) = " + lca.data);
        } else {
            System.out.println("Keys are not present");
        }
 
    }
}