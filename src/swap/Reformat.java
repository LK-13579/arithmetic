package swap;

import java.util.Arrays;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/13 16:58
 * @description 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2" 输出："0a1b2c" 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b"
 * 也是满足题目要求的答案。 示例 2：
 * <p>
 * 输入：s = "leetcode" 输出："" 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。 示例 3：
 * <p>
 * 输入：s = "1229857369" 输出："" 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。 示例 4：
 * <p>
 * 输入：s = "covid2019" 输出："c2o0v1i9d" 示例 5：
 * <p>
 * 输入：s = "ab123" 输出："1a2b3"
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reformat-the-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reformat {

  public static void main(String[] args) {
    String str = "ab";
    Reformat reformat = new Reformat();
    String reformat1 = reformat.reformat2(str);
    System.out.println(reformat1);
  }

  public String reformat2(String s) {
    if (s == null) {
      return "";
    }
    char[] chars = s.toCharArray();
    //num1用于存储字符串的字母个数,num2用于存储数字的个数
    int num1 = 0;
    int num2 = 0;
    for (char c : chars) {
      if (c - 'a' >= 0) {
        num1 += 1;
      } else {
        num2 += 1;
      }
    }
    if (Math.abs(num1 - num2) > 1) {
      return "";
    }
    //字母的指针,当字母的数量大于数字的数量的时候,那么这个时候字母必须在偶数位,并且第一个是字母;反之数字数字要是第一个
    int m = 0;
    int n = 0;
    if (num1 > num2) {
      n = 1;
    }else{
      m = 1;
    }
    char[] ch = new char[s.length()];
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] - 'a' >= 0) {
        ch[m] = chars[i];
        m += 2;
      } else {
        ch[n] = chars[i];
        n += 2;
      }
    }
    return new String(ch);
  }

  public String reformat(String s) {
    if (s == null) {
      return "";
    }
    char[] chars = s.toCharArray();
//    Arrays.sort(chars, chars.length, 0);
    for (int i = 0; i < chars.length; i += 2) {
      //该值是字母
      if (chars[i] - 'a' >= 0) {
        for (int j = i + 1; j < chars.length; j++) {
          //该值是数字,看位置,如果j就是i+1则直接退出
          if (chars[j] - 'a' < 0) {
            if (j == i + 1) {
              break;
            }
            char c = chars[i + 1];
            chars[i + 1] = chars[j];
            chars[j] = c;
            break;
          }
          //继续往前寻找,找不到直接返回空串
          if (j + 1 == chars.length) {
            return "";
          }
        }
      }
      //该值是数字
      if (chars[i] - 'a' < 0) {
        for (int j = i + 1; j < chars.length; j++) {
          if (chars[j] - 'a' >= 0) {
            //该值是字母,并且不是第i+1个,需要交换
            if (j == i + 1) {
              break;
            }
            char c = chars[i + 1];
            chars[i + 1] = chars[j];
            chars[j] = c;
            break;
          }
          if (j + 1 == chars.length) {
            return "";
          }
        }
      }
    }
    return new String(chars);
  }

}
