package locating;


import common.TreeNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/11 15:01
 * @description
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
