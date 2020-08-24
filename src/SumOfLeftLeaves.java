
//  Definition for a binary tree node.

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfLeftLeaves {

    boolean isLeaf(TreeNode node){ //leaf condition
        return node != null && node.left == null && node.right == null;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) //simple base case
            return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root); //add first
        int total = 0;
        while(!stack.isEmpty()){ //keep checking
            TreeNode curr = stack.pop();
            if(isLeaf(curr.left)) //only check for left leaves
                total += curr.left.val; //add only if its a leaf and left.
            if(curr.left != null) //keep adding for traversing
                stack.push(curr.left);
            if(curr.right != null)//keep adding
                stack.push(curr.right);
        }
        return total;
    }
}