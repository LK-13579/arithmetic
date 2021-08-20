package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/20 15:17
 * @description
 *
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPlaceFlowers {

  public static void main(String[] args) {
    int[] arr = {1,0,0,0,1,0,0};
    CanPlaceFlowers flowers = new CanPlaceFlowers();
    System.out.println(flowers.canPlaceFlowers(arr, 2));
  }


  /**
   * 核心：虚拟边界是0
   * @param flowerbed
   * @param n
   * @return
   */
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int j = 1;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        j++;
      } else {
        n -= (j - 1) / 2;
        j = 0;
      }
    }
    n -= j / 2;
    return n <= 0;
  }

  /**
   * 完成超时
   * @param flowerbed
   * @param n
   * @return
   */
  public boolean canPlaceFlowers2(int[] flowerbed, int n) {
    int i = 0;
    int j = 0;
    while (i < flowerbed.length) {
      if ((i == 0 && flowerbed[i] == 0) || (i == flowerbed.length - 2 && flowerbed[i] == 0)) {
        j = 2;
        continue;
      }
      if (flowerbed[i++] == 0) {
        j++;
        if (j == 3) {
          n--;
          j = 1;
        }
      } else {
        j = 0;
      }
    }
    return n <= 0;
  }

}
