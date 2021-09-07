package tree;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/7 10:25
 * @description
 *
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *  
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/opLdQZ
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTarget {

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(334);
    TreeNode treeNode2 = new TreeNode(277);
    TreeNode treeNode3 = new TreeNode(507);
    TreeNode treeNode4 = new TreeNode(285);
    TreeNode treeNode5 = new TreeNode(678);
//    TreeNode treeNode6 = new TreeNode(9);
//    TreeNode treeNode7 = new TreeNode(11);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.right = treeNode4;
    treeNode3.right = treeNode5;
//    treeNode2.left = treeNode4;
//    treeNode2.right = treeNode5;
//    treeNode3.left = treeNode6;
//    treeNode3.left = treeNode4;
//    treeNode3.right = treeNode5;
    FindTarget findTarget = new FindTarget();
    List<Integer> list = new ArrayList<>();
    int count = 1014;
    boolean target = findTarget.findTarget(treeNode1, count);
    System.out.println(target);
  }

  public boolean findTarget(TreeNode root, int k) {
    int count = 0;
    count = iter(root, count);
    int[] dp = new int[count];
    iterArray(root, 0, dp);

      for (int i = 0; i < dp.length - 1; i++) {
        for (int j = dp.length - 1; j > i; j--) {
          int data = dp[i] + dp[j];
          if (data<k)break;
          if (data == k) {
            return true;
          }
        }
      }
    return false;
  }

  public int iterArray(TreeNode root,int count, int[] dp) {
    if (root==null)return 0;
    if (root.left != null) {
      count = iterArray(root.left, count,dp);
    }
    dp[count++] = root.val;
    if (root.right != null) {
      count = iterArray(root.right, count, dp);
    }
    return count;
  }

  public int iter(TreeNode root, int count) {
    if (root==null)return 0;
    if (root.left != null) {
      count = iter(root.left, count);
    }
    count += 1;
    if (root.right != null) {
      count = iter(root.right, count);
    }
    return count;
  }


  public boolean findTarget2(TreeNode root, int k) {
//    //根节点大于k,直接从左子树搜寻
//    if (root.val > k) {
//      findTarget(root.left, k);
//    }
    //标记当前节点
//    boolean result = false;
    TreeNode prev = root;
    while (prev != null) {
      int i = k - prev.val;
      TreeNode result = iterTree(root, i);
      if (result == null || result.val == prev.val) {
        if (prev.val >= i && prev.left!=null) {
          prev = prev.left;
        } else  {
          prev = prev.right;
        }
      } else {
        return true;
      }
    }
    return false;
  }

  public TreeNode iterTree(TreeNode prev, int k) {
    if (prev == null) {
      return null;
    }
    if (prev.val == k) {
      return prev;
    }
     return prev.val > k ? iterTree(prev.left, k) : iterTree(prev.right, k);
  }


}
