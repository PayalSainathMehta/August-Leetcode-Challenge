class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class ClosestValue {
	public int closestValue(TreeNode root, double target) {
		if(root == null)
			return -1;
		int val, closest = root.val; //store root.val
		while(root != null) {
			val = root.val; //store current
			closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest; //compare
			root = target < root.val ? root.left : root.right; //move
		}
		return closest;
	}
}
