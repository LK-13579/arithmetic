package tree;

import common.TreeNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/6 10:40
 * @description 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5 / \ 4   5 / \   \ 1   1   5 输出:
 * <p>
 * 2 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1 / \ 4   5 / \   \ 4   4   5 输出:
 * <p>
 * 2 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestUnivaluePath {

  private static int max = 0;


  public static void main(String[] args) {
//    TreeNode node1 = new TreeNode(1);
//    TreeNode node2 = new TreeNode(4);
//    TreeNode node3 = new TreeNode(5);
//    TreeNode node4 = new TreeNode(4);
//    TreeNode node5 = new TreeNode(4);
//    TreeNode node6 = new TreeNode(5);
//    node1.left = node2;
//    node1.right = node3;
//    node2.left = node4;
//    node2.right = node5;
//    node3.right = node6;
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(2);
    TreeNode treeNode4 = new TreeNode(2);
    TreeNode treeNode5 = new TreeNode(2);
    TreeNode treeNode6 = new TreeNode(2);
    TreeNode treeNode7 = new TreeNode(2);
    TreeNode treeNode8 = new TreeNode(2);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    treeNode3.left = treeNode6;
    treeNode3.right = treeNode7;
    treeNode4.left = treeNode8;

    LongestUnivaluePath path = new LongestUnivaluePath();
    max = path.longestUnivaluePath(treeNode1);
    System.out.println(max);
  }

  /**
   * 从子树开始求解
   *
   * @param root
   * @return
   */
  public int longestUnivaluePath(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int i = longestUnivaluePath(root.left);
    if (root.left != null && root.val == root.left.val) {
      i++;
    }
    int i1 = longestUnivaluePath(root.right);
    if (root.right != null && root.val == root.right.val) {
      i1++;
    }
    if (root.left != null && root.right != null && root.val == root.left.val && root.val== root.right.val) {
      i++;
      i1++;
    }
//    max = Math.max(0, i + i1);
    return Math.max(i, i1);
  }

}
