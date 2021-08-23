package tree;

import common.TreeNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/23 15:20
 * @description
 *
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 *
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 *
 * 也就是说，你需要重复此过程直到不能继续删除。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,2,null,2,4], target = 2
 * 输出：[1,null,3,null,4]
 * 解释：
 * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,3,3,3,2], target = 3
 * 输出：[1,3,null,null,2]
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,null,2,null,2], target = 2
 * 输出：[1]
 * 解释：每一步都删除一个绿色的叶子节点（值为 2）。
 * 示例 4：
 *
 * 输入：root = [1,1,1], target = 1
 * 输出：[]
 * 示例 5：
 *
 * 输入：root = [1,2,3], target = 1
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= target <= 1000
 * 每一棵树最多有 3000 个节点。
 * 每一个节点值的范围是 [1, 1000] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-leaves-with-a-given-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveLeafNodes {

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(3);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(3);
    TreeNode treeNode5 = new TreeNode(2);
    treeNode1.left = treeNode2;
    treeNode2.left = treeNode3;
    treeNode2.right = treeNode5;
    treeNode1.right = treeNode4;

    RemoveLeafNodes nodes = new RemoveLeafNodes();
    TreeNode treeNode = nodes.removeLeafNodes(treeNode1, 3);
    System.out.println(treeNode);
  }

  /**
   * 1.递归左遍历,判断叶子节点是否等于target,如果相等将该节点置空
   * 2.递归右遍历,判断叶子节点是否等于target
   * 3.当且仅当左右叶子节点都等于target的时候才对其父节点进行遍历
   * @param root
   * @param target
   * @return
   */
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return root;
    }
    TreeNode leftNode = removeLeafNodes(root.left, target);

    if (leftNode == null) {
      root.left = null;
    }
    TreeNode rightNode = removeLeafNodes(root.right, target);
    if (rightNode == null) {
      root.right = null;
    }
    return leftNode == null && rightNode == null && root.val == target ? null : root;
  }
}
