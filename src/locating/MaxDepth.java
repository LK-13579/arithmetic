package locating;


import common.TreeNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/11 15:01
 * @description
 */
public class MaxDepth {

  public static void main(String[] args) {

    TreeNode node = new TreeNode(3, new TreeNode(9, null, null),
        new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    MaxDepth depth = new MaxDepth();
    int i = depth.maxDepth(node);
    System.out.println(i);
  }




  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.getLeft());
    int rightDepth = maxDepth(root.getRight());
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
