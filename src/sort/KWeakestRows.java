package sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/6/28 11:20
 * @description 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,1,0,0,0], [1,1,1,1,0], [1,0,0,0,0], [1,1,0,0,0], [1,1,1,1,1]], k = 3 输出：[2,0,3] 解释：
 * 每行中的军人数目： 行 0 -> 2 行 1 -> 4 行 2 -> 1 行 3 -> 2 行 4 -> 5 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KWeakestRows {

  public static void main(String[] args) {
    int[][] a = {{1,0}, {1,0}, {1,0}, {1, 1}};
    kWeakestRows(a, 1);
  }

  public static int[] kWeakestRows(int[][] a, int k) {
    int[] p = new int[a.length];
    int min = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        //判断j是不是最后一个,如果是则战力为j总长度
        if (j + 1 >= a[i].length) {
          p[i] = j + 1;
        }
        //判断j为0的点,战力为j
        if (a[i][j] == 0) {
          p[i] = j;
          break;
        }
      }
    }

    int index = 0 ;
    //从0开始算,如果有0则第一个既是最弱的
    int lixiangzhi = 0;
    int[] target2 = new int[k];
    while(index != k) {
      for(int i = 0 ; i < p.length ; i++) {
        if(p[i] == lixiangzhi  ) {
          target2[index++] = i;
        }
        if(index == k) {
          break;
        }
      }
      lixiangzhi++;
    };
    return target2;
  }
}
