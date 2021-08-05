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
