package other.plan;

import java.text.DecimalFormat;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/10 10:44
 * @description 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 *  
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667] 示例 2:
 * <p>
 * 输入: 2 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 11
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DicesProbability {

  public static void main(String[] args) {
    DicesProbability probability = new DicesProbability();
    double[] doubles = probability.dicesProbability(2);
    for (int i = 0; i < doubles.length; i++) {
      System.out.println(doubles[i]);
    }
  }


  /**
   * 1.因为两者的取值会相互影响,所以这个可以用动态规划来实现; 2.首先确定物品与背包;物品每个骰子的点数;背包每个骰子合的概率;因为每个骰子可以重复组合,所以是个完全背包
   * 3.确定dp数组以及下标的含义,dp[i]标识第i和的概率 4.确定递推公式dp[i][j] = dp[i-1]*dp[j]+dp[i-2]*dp[j+1]+...+dp[1]*dp[i-1]
   * 当且仅当i=1的时候停止;n*6+1>i>1有效 5.确定遍历顺序,由于需要dp[i]需要前dp[i-1]~dp[1]的值,所以顺序遍历
   *
   * @param n
   * @return
   */
  public double[] dicesProbability(int n) {
    double[] dp = new double[n * 6 + 1];
    //初始化数据
    dp[1] = 0.16667;
    dp[n] = Math.pow(dp[1], n);
    dp[n] = Double.parseDouble(String.format("%.5f", dp[n]));
    //计算中间的位置mid = n+dp.length除于2,那么第n+mid就是最大位置
    int mid = (n + dp.length) / 2;
    int rate = 2;
    if (n > 2) {
      rate = n;
    }
    for (int i = n+1; i < mid + n; i++) {
      dp[i] = dp[n] * rate;
      if (n > 2) {
        rate = rate + n;
      } else {
        rate = rate + 1;
      }
    }
    for (int j = dp.length -1 ; j > mid; j--) {
      dp[j] = dp[n++];
    }

    return dp;

  }

}
