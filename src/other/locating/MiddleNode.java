package other.locating;

import common.ListNode;
import java.util.HashMap;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/9 11:37
 * @description
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MiddleNode {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);

    node1.next = node2;
    node2.next = node3;
    MiddleNode node = new MiddleNode();
    ListNode listNode = node.middleNode(node1);
    System.out.println(listNode.getVal());
//    System.out.println(3/2);
  }

  public ListNode middleNode(ListNode head) {
    if(head.next == null) {return head;}
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode startNode = head;
    Integer start = 0;
    do {
      map.put(start, startNode);
      startNode = startNode.next;
      start++;
    } while (startNode != null);
    Integer result = start / 2;
    return map.get(result);

//    ListNode result = head;
//    int count = 1;
//    while (result.next != null) {
//      count++;
//      if (result.next.next != null) {
//        result = result.next;
//        continue;
//      }
//      int i = count / 2 + 1;
//    }

  }
}
