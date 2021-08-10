package sort;

import common.ListNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/9 14:00
 * @description
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    ListNode node2 = new ListNode(1);
    ListNode node3 = new ListNode(3);
    head.next = node2;
    node2.next = node3;
    System.out.println(head);
    SortList list = new SortList();
    ListNode listNode = list.sortList(head);
//    ListNode listNode = new ListNode(0);
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
    if (start == end) {return;}
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
