package tree;

import common.TreeNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/26 11:20
 * @description 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3] 输出：25 解释： 从根到叶子节点路径 1->2 代表数字 12 从根到叶子节点路径 1->3 代表数字 13 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,9,0,5,1] 输出：1026 解释： 从根到叶子节点路径 4->9->5 代表数字 495 从根到叶子节点路径 4->9->1 代表数字 491 从根到叶子节点路径
 * 4->0 代表数字 40 因此，数字总和 = 495 + 491 + 40 = 1026
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3Etpl5 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumNumbers {

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(0);
    TreeNode node2 = new TreeNode(1);
    TreeNode node3 = new TreeNode(0);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(1);
    node1.left = node2;
//    node1.right = node3;
//    node2.left = node4;
//    node2.right = node5;
    SumNumbers sumNumbers = new SumNumbers();
    int i = sumNumbers.sumNumbers(node1);
    System.out.println(i);

  }

  public int sumNumbers(TreeNode root) {
    int head = root.val;
    int count = 0;
    return sumNumbers(root, head, count);
  }

  public int sumNumbers(TreeNode root, int head, int count) {
    if (root == null) {
      return count;
    }
    //该节点是叶子节点
    if (root.left == null && root.right == null) {
      return count += head;
    }
    if (root.left != null) {
      count = sumNumbers(root.left, head * 10 + root.left.val, count);
    }
    if (root.right != null) {
      count = sumNumbers(root.right, head*10+root.right.val, count);
    }
    return count;
  }

}
