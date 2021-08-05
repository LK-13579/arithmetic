package matching;

import common.ListNode;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/5 17:36
 * @description 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos
 * 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1 输出：返回索引为 1 的链表节点 解释：链表中有一个环，其尾部连接到第二个节点。 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0 输出：返回索引为 0 的链表节点 解释：链表中有一个环，其尾部连接到第一个节点。 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1 输出：返回 null 解释：链表中没有环。  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 104] 内 -105 <= Node.val <= 105 pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCycle {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(3);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(0);
    ListNode listNode4 = new ListNode(-4);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = null;
    DetectCycle detectCycle = new DetectCycle();
    ListNode listNode = detectCycle.detectCycle(listNode1);
    System.out.println(listNode.getVal());


  }

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    if (head.next == head || head.next.next == head) {
      return head;
    }
    HashMap<ListNode, ListNode> map = new HashMap<>();
    //定义两个快慢指针,当链表的数量大于3的时候
    ListNode point = head;
    ListNode fastPoint = head;
    while (point.next != null && fastPoint.next.next != null) {
      //判断map当中是否有该key，移动一次就记录到set当中
      if (!map.containsKey(point)) {
        map.put(point, fastPoint);
        point = point.next;
        fastPoint = fastPoint.next.next;
        if (fastPoint.next== null || fastPoint.next.next==null) {
          return null;
        }
      } else {
        return point;
      }
    }
    return null;
  }
}
