package tree;

import common.TreeNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/23 17:40
 * @description
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumBST {

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(10);
    TreeNode treeNode2 = new TreeNode(5);
    TreeNode treeNode3 = new TreeNode(15);
    TreeNode treeNode4 = new TreeNode(3);
    TreeNode treeNode5 = new TreeNode(7);
    TreeNode treeNode6 = new TreeNode(18);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    treeNode3.right = treeNode6;
    RangeSumBST rangeSumBST = new RangeSumBST();
    int i = rangeSumBST.rangeSumBST(treeNode1, 7, 15);
    System.out.println(i);


  }

  public int rangeSumBST(TreeNode root, int low, int high) {
    int count = 0;
    return rangeSumBST(root, low, high, count);
  }

  public int rangeSumBST(TreeNode root, int low, int high,int count) {
    count = root != null && high >= root.val && root.val >= low ? count += root.val : count;
    if (root.left != null) {
      count = rangeSumBST(root.left, low, high, count);
    }
    if (root.right != null) {
      count = rangeSumBST(root.right, low, high, count);
    }
    return count;
  }

}
