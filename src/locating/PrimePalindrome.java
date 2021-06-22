package locating;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/6/22 10:46
 * @description
 *
 *
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrimePalindrome {

  public static void main(String[] args) {
    //输入一个数
    int n = 1;
//    int j = primePalindrome(n);
    System.out.println(2 * 100000000);
  }

  /**
   * 
   * @param n 常数
   * @return int
   */
  public static int primePalindrome(int n) {
    for (int j = n; j < 2 * 100000000; j++) {
      //判断一个数是素数
      if (n <= 2) {
        return 2;
      }
      //求开方
      int sqrt = (int) Math.sqrt(j) + 1;
      //从i到sqrt循环,判断是否能有数被n整除
      for (int i = 2; i <= sqrt; i++) {
        if (i >= sqrt) {
          //该数是素数,判断这个数是不是回数
          int around = isAround(j);
          if (around == 0) {
            break;
          }
          return j;
        }
        if (j % i == 0) {
          break;
        }
      }
    }
    return n;
  }

  /**
   * 判断是否是回数
   * @param n 常数
   * @return int
   */
  public static int isAround(Integer n) {
    String s = n.toString();
    String s1 = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      s1 += String.valueOf(s.charAt(i));
    }
    if (s1.equals(s)) {
      return n;
    } else {
      return 0;
    }
  }
}
