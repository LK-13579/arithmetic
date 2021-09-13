package string;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/13 10:12
 * @description
 *
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 *
 * 子字符串 是字符串中的一个连续的字符序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 * 示例 2：
 *
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 * 示例 3：
 *
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-odd-number-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestOddNumber {

  public static void main(String[] args) {
    String str = "52";
    LargestOddNumber largestOddNumber = new LargestOddNumber();
    String s = largestOddNumber.largestOddNumber(str);
    System.out.println(s);
  }

  public String largestOddNumber(String num) {
    for (int i = num.length()-1; i >=0 ; i--) {
      char c = num.charAt(i);
      if (c % 2 == 1 ) {
        return num.substring(0,i).concat(String.valueOf(c));
      }
    }
    return "";
  }

}
