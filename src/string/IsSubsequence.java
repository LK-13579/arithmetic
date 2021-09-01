package string;

import java.util.Stack;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/1 14:45
 * @description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc" 输出：true 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc" 输出：false
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubsequence {

  public static void main(String[] args) {
    String s = "";
    String t = "ahbgdc";
    IsSubsequence isSubsequence = new IsSubsequence();
    boolean subsequence = isSubsequence.isSubsequence(s, t);
  }

  public boolean isSubsequence(String s, String t) {
//    if (s.equals(""))return false;
    //s是子序列
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    //将字符串倒序入栈
    for (int i = chars.length - 1; i >= 0; i--) {
      stack.push(chars[i]);
    }

    char[] array = t.toCharArray();
    for (int i = 0; i < array.length; i++) {
      if (stack.isEmpty())break;
      if (array[i] == stack.peek()) {
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

}
