package list;

import common.ListNode;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/25 16:43
 * @description
 *
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitListToParts {

  public static void main(String[] args) {
//    System.out.println(6 / 5);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    ListNode node8 = new ListNode(8);
    ListNode node9 = new ListNode(9);
    ListNode node10 = new ListNode(10);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = node9;
    node9.next = node10;
    SplitListToParts splitListToParts = new SplitListToParts();
    ListNode[] listNodes = splitListToParts.splitListToParts(node1,3);
    for (int i = 0; i < listNodes.length; i++) {
      System.out.println(listNodes[i].getVal());
    }
//    System.out.println();

  }


  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] listNodes = new ListNode[k];
    //将链表转换成数组存储
    ListNode[] list = new ListNode[10];

    ListNode node = head;
    int length = 0;
    while (head != null) {
      list[length++] = head;
      ListNode next = head.next;
      head.next = null;
      head = next;
    }
    if (length <= k) {
      for (int i = 0; i < k; i++) {
        if (list[i] != null) {
          listNodes[i] = list[i];
        } else {
          listNodes[i] = new ListNode(0);
        }
      }
    } else {
      //平均分成没分的个数
      int m = length / k;
      int n = length % k;
      int z1 = 0;
      for (int i = 0; i < list.length; i += m) {
        int z = 0;
        ListNode node1 = new ListNode(0);
        ListNode node2 = node1;
        while (z < m) {
          node1.next = list[i + z];
          node1 = node1.next;
          z++;
        }
        if (n > 0) {
          node1.next = list[i + z];
          n--;
          i++;
//          node1 = node1.next;
        }
        listNodes[z1++] = node2.next;
      }
    }
    return listNodes;
  }

  private ListNode[] iter(ListNode node, ListNode[] listNodes,int i) {
    if (node != null) {
      listNodes[i++] = node;
      ListNode node1 = node.next;
      node.next = null;
      iter(node1, listNodes, i);
    }
    return listNodes;
  }

}
