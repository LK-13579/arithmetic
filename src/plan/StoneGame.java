package plan;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/6/16 10:47
 * @description 石子游戏 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子piles[i]/
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回true，当李赢得比赛时返回false。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[5,3,4,5] 输出：true 解释： 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。 如果李拿走前 3
 * 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。 这表明，取前 5
 * 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/stone-game 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGame {

  public static void main(String[] args) {
    int[] arr = {5, 4, 4, 8, 6, 4};
    boolean result = stoneGame(arr, 0, 0);
    System.out.println(result);
  }


  /**
   * @param arr  石头
   * @param sumA 压力历克斯的石头总数
   * @param sumB 李的石头总数
   * @return boolean
   */
  public static boolean stoneGame(int[] arr, int sumA, int sumB) {
    boolean result = true;
    if (arr.length < 1) {
      if (sumA < sumB) {
        result = false;
      }else{
        result = true;
      }
    }
    //判断数据是奇数还是偶数
    if (arr.length > 0) {
      if (arr.length % 2 == 0) {
        //为偶数,A先取
        if (arr[0] >= arr[arr.length - 1]) {
          sumA += arr[0];
          //移除a[0]
          int[] arr2 = new int[arr.length - 1];
          for (int i = 0; i < arr.length - 1; i++) {
            arr2[i] = arr[i + 1];
          }
          result = stoneGame(arr2, sumA, sumB);
        } else {
          sumA += arr[arr.length - 1];
          int[] arr2 = new int[arr.length - 1];
          for (int i = 0; i < arr.length - 1; i++) {
            arr2[i] = arr[i];
          }
          result = stoneGame(arr2, sumA, sumB);
        }
      } else {
        //为奇数,B取
        if (arr[0] >= arr[arr.length - 1]) {
          sumB += arr[0];
          int[] arr2 = new int[arr.length - 1];
          for (int i = 0; i < arr.length - 1; i++) {
            arr2[i] = arr[i + 1];
          }
          result = stoneGame(arr2, sumA, sumB);
        } else {
          sumB += arr[arr.length - 1];
          int[] arr2 = new int[arr.length - 1];
          for (int i = 0; i < arr.length - 1; i++) {
            arr2[i] = arr[i];
          }
          result = stoneGame(arr2, sumA, sumB);
        }
      }
    }
    return result;
  }

}
