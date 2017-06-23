public class BinaryTree {
    private class Node
    {
        int element;
        Node left, right;
        
        Node (int val)
        {
            element = val;
            left = null; right = null;
        }
        
        Node (int val, Node leftChild, Node rightChild)
        {
            element = val;
            left = leftChild; right = rightChild;
        }
    }
    Node root = null;
}