package other.locating;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/7/2 11:15
 * @description
 *
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 *
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 *
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 *
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 *
 * 输入：text = "abcdef"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxRepOpt {

  public static void main(String[] args) {
    String str = "mcmc_2010-0";
    System.out.println(Integer.valueOf(str.substring(9)));
//    MaxRepOpt maxRepOpt = new MaxRepOpt();
//    System.out.println(maxRepOpt.maxRepOpt1(str));
  }

  public int maxRepOpt1(String text) {
    //hash表
    int[] a = new int[text.length()];
    //标记最大下标
    int max = 0;
    for (int i = 0; i <= text.length() -1 ; i++) {
      //sign作为指针,根据i的情况进行移动
      int sign = i + 1;
      do {
        //如果不相等,那么赋值i元素
        if (sign == text.length() || text.charAt(i) != text.charAt(sign)) {
          a[i] = sign - i;
          //标记出现最大连串的下标
          if (a[i] > a[max]) {
            max = i;
          }
          break;
        }
        //如果i与下一个元素相等,则指针往后移动一位
        if (text.charAt(i) == text.charAt(sign)) {
          sign++;
        }
      } while (true);
      i = sign -1 ;
    }
    //得到了一个已经划分好的数组,因为可以随意交换一次
    System.out.println(a.toString());
    //最大值,因为还可以进行交换,所以从max左右进行搜寻
    int result = a[max];
    //最多出现的字符是什么c
    char c = text.charAt(max);
    //
    if (text.charAt(max + result + 2) != c) {
      return result;
    }

    //从max起止查找,
    for (int i = max; i < a.length; i++) {
      //从max往前找,如果max下一个元素大于1,
      if (a[max + 1] > 1) {
        return a[max] + 1;
      }
    }
    return result;

  }

}
