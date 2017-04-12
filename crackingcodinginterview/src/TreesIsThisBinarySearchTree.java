public class TreesIsThisBinarySearchTree {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    public boolean checkBST(Node root) {
        return checkTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data > min && root.data < max) {
            return checkTree(root.left, min, root.data) && checkTree(root.right, root.data, max);
        } else {
            return false;
        }
    }

}
