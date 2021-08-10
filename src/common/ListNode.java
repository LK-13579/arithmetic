package common;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/5 17:37
 * @description
 */

public class ListNode {

  int val;
  public ListNode next;

  private ListNode merge(ListNode l1, ListNode l2) {
    if(l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    if(l1.val < l2.val){
      l1.next = merge(l1.next, l2);
      return l1;
    }else{
      l2.next = merge(l1, l2.next);
      return l2;
    }
  }

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }
}
