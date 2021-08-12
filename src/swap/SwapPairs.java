package swap;

import common.ListNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/11 16:17
 * @description
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *  
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next =node2;node2.next= node3;
    node3.next = node4;
    node4.next = null;
    SwapPairs pairs = new SwapPairs();
    ListNode listNode = pairs.swapPairs(node1);
    System.out.println(listNode);

  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //交换后返回的头节点
    ListNode listNode = swapPairs(head.next.next);
    //与前一个交换,node用于暂存节点
    ListNode node = new ListNode(-1);
    ListNode prev = node;
    prev.next = head.next;
    prev = prev.next;
    prev.next = head;
    prev = prev.next;
    prev.next = listNode;
    return node.next;

  }
}
