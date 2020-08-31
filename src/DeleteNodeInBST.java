public class DeleteNodeInBST {

    public int successor(TreeNode node){
        node = node.right;
        while(node.left != null)
            node = node.left;
        return node.val;
    }

    public int predecessor(TreeNode node){
        node = node.left;
        while(node.right != null)
            node = node.right;
        return node.val;
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null)
            return null;
        /*
        3 cases here - can be equal, can be less, can be greater
        */
        if(key > root.val)
            root.right = deleteNode(root.right, key);
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else{ // equal but now 3 more cases, is a leaf, has left subtree, has right subtree
            if(root.right == null && root.left == null)
                root = null;
            else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
