package list;

import common.ListNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/19 17:10
 * @description
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {

  public static void main(String[] args) {
    RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = null;
    ListNode node = removeNthFromEnd.removeNthFromEnd(listNode1, 2);
  }

  /**
   * 只需要遍历一遍
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = head;
    ListNode second = dummy;
    for (int i = 0; i < n; ++i) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    ListNode ans = dummy.next;
    return ans;
  }


  public ListNode removeNthFromEnd3(ListNode head, int n) {
    ListNode node = head;
    ListNode prev = head;
    //总长度
    int i = 1;
    while (prev.next != null) {
      i++;
      prev = prev.next;
    }
    int j = 1;
    while (j + n < i) {
      head = head.next;
      j++;
    }
    if (n == i) {
      node = node.next;
    } else {
      head.next = head.next.next;
    }
    return node;
  }

  public ListNode removeNthFromEnd2(ListNode head, int n) {
    if (n==0) {
      return head;
    }
    //当前是最后一个
    if (head.next == null) {
      n -= 1;
      return head;
    }
    head = head.next;
    removeNthFromEnd(head, n);
    return head;
  }
}
