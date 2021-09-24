package other.locating;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/24 17:56
 * @description
 *
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrailingZeroes {

  public static void main(String[] args) {
    TrailingZeroes trailingZeroes = new TrailingZeroes();
    int i = trailingZeroes.trailingZeroes(5);
    System.out.println(i);
  }

  public int trailingZeroes(int n) {
    if (n == 1) {
      return 1;
    }
    return n * trailingZeroes(n - 1);
  }

}
