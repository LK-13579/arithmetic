package other.plan;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/2 16:17
 * @description
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *  
 *
 * 限制：
 *
 * 1 <= n < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountDigitOne {

  public static void main(String[] args) {
    CountDigitOne countDigitOne = new CountDigitOne();
    Integer n = 1410065408;//234
    int i = countDigitOne.countDigitOne(n);
    System.out.println(i);
  }

  public int countDigitOne(int n) {
    long a = 1;
    long b = 10;
    int count = 0;

    while (n >= a) {
      //商
      long x = n / b;
      //余数
      long y = n % b;
      if (y >= a * 2) {
        count += (x + 1) * a;
      } else if (y >= a) {
        count += y + 1 + (x - 1) * a;
      } else {
        count += x * a;
      }
      a = b;
      b = b * 10;
    }
    return count;

  }


  public int countDigitOne2(int n) {
    //判断n的长度
    //当n为个位数的时候,只有一个
    //当n为十位数的时候,为n*1+10,再加上个位数1
    //当n为百位数的时候,为n*20(十分位满的情况)+100,十位数为n*1+10,个位数为1
    int count = 1;
    //乘积
    int m = 10;
    int j = 1;
    String str = String.valueOf(n);
    if (str.length()==1)return 1;
    for (int i = str.length() - 2; i >= 0; i--) {
      //判断为1的情况
      if ((str.charAt(i) - '0') == 1 && i==0) {
        if (str.charAt(i + 1) - '0' >= 1) {
          int k = str.charAt(i + 1) - '0' + j + 1;
          count += k;
        } else {
          count += 1;
        }
      } else {
        int i1 = (str.charAt(i) - '0') * j + m;
        count += i1;
      }
      j = 9 * j + m + j;
      m *= 10;
    }
    return count;
  }


}
