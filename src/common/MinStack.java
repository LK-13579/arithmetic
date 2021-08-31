package common;

import java.util.Stack;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/31 15:57
 * @description
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(null);
    minStack.push(0);
    minStack.push(-3);
    int min = minStack.min();
    minStack.pop();
    minStack.top();
    int min1 = minStack.min();
  }

  /**
   * 栈针
   */
  public int stackPrev = -1;
  public int min = -1;
  public Integer[] arr = new Integer[16];

  public MinStack() {
  }

  public void push(Integer x) {
    stackPrev++;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null && x != null) {
        arr[i] = x;
        min = -1;
//        if (min == -1 || arr[i] < arr[min]) {
//          min = i;
//        }
        break;
      }
    }
  }

  public void pop() {
    arr[stackPrev--] = null;
    min = -1;
  }

  public int top() {
    return arr[stackPrev];
  }

  public int min() {
    for (int i = 0; i < arr.length; i++) {
      if (min == -1 || (arr[i] != null && arr[i] < arr[min])) {
        min = i;
      }
    }
    return arr[min];
  }

}
