package other.sort;

import common.ListNode;
import java.util.HashMap;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/9 14:00
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3] 输出：[1,2,3,4] 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0] 输出：[-1,0,3,4,5] 示例 3：
 * <p>
 * 输入：head = [] 输出：[]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-list 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(4);
    l1.next = node2;
    node2.next = node3;
    //-------------------
    ListNode l2 = new ListNode(1);
    ListNode node4 = new ListNode(3);
    ListNode node5 = new ListNode(4);
    l2.next = node4;
    node4.next = node5;
    ListNode node = mergeTwoLists(l1, l2);
    System.out.println(node);
//    System.out.println(head);
//    SortList list = new SortList();
//    ListNode listNode = list.sortList(head);
//    ListNode listNode = new ListNode(0);
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    ListNode prveNode = new ListNode(-1);
//    ListNode prev = prveNode;
//    while (l1 != null && l2 != null) {
//      if (l1.getVal() < l2.getVal()) {
//        prev.next = l1;
//        l1 = l1.next;
//      } else {
//        prev.next = l2;
//        l2 = l2.next;
//      }
//      prev = prev.next;
//    }
//    ListNode l = l1 == null ? l2 : l1;
//    prev.next = l;
//    return prveNode.next;

    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    if (l1.getVal() < l2.getVal()) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else  {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  public ListNode sortList(ListNode head) {

    //1、遍历使用数组存储
    HashMap<Integer, ListNode> map = new HashMap<>();
    Integer tmp = 0;
    while (head != null) {
      map.put(tmp, head);
      if (head.next != null) {
        head = head.next;
        tmp++;
      } else {
        break;
      }
    }
//    List<List<ListNode>> list = Arrays.asList(map.values().stream().collect(Collectors.toList()));
//    for (ListNode node : list) {
//      System.out.println(node);
//    }

    return null;
    //2、使用归并排序
  }

  public void mergeSort(int[] arr, int start, int end) {
    if (start == end) {
      return;
    }
    //计算一个数组当中的中间节点
    int mid = (start + end) / 2;
    //递归左边
    mergeSort(arr, start, mid);
    //递归右边
    mergeSort(arr, end, mid + 1);
    merge(arr, start, mid, end);
  }

  private void merge(int[] arr, int start, int mid, int end) {

  }
}
