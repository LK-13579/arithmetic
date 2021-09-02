package other.locating;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/2 14:13
 * @description
 *
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 *
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 *
 * 输入：n = 2, pick = 2
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GuessNumber {

  public static void main(String[] args) {
//    other.locating.GuessNumber guessNumber = new GuessNumber();
    GuessNumber guessNumber = new GuessNumber();
    int i = guessNumber.guessNumber(1,2126753390);
    System.out.println(i);
  }

  public int guessNumber(int head, int n) {
    System.out.println(head);
    System.out.println(n);
    long i1 = (long) head + (long) n;
    int i = (int) (i1 / 2);
    int guess = guess(i);
    if (guess == -1) {
      return guessNumber(head, i -= 1);
    } else if (guess == 1) {
      return guessNumber(i += 1, n);
    }
    return i;
  }


  /**
   * 采用递归二分,1-n之间
   * @param n
   * @return
   */
//  public int guessNumber2(int n) {
//    //取中间值
//    int guess = guess(n);
//    if (guess == -1) {
//      int i = n / 2;
//      return guessNumber(n -= 1);
//    } else if (guess == 1) {
//      return guessNumber(n += 1);
//    }
//    return n;
//  }

  private int guess(int n) {
    int pick = 1702766719;
    if (pick > n) {
      return 1;
    }
    if (pick < n) {
      return -1;
    }
    return 0;
  }


}
