package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/26 17:16
 * @description
 *
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 *
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 *
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinKBitFlips {

  public static void main(String[] args) {
    MinKBitFlips minKBitFlips = new MinKBitFlips();
    int[] arr = {0,0,0,1,0,1,1,0};
    int i = minKBitFlips.minKBitFlips(arr, 3);
    System.out.println(i);

  }

  public int minKBitFlips(int[] nums, int k) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int prev = 0;
      if (nums[i]==1)continue;
      boolean reverse = reverse(nums, i, i + k, prev);
      if (reverse) {
        result += 1;
      } else {
        result = -1;
      }
      i = prev;
    }
    return result;
  }

  /**
   * 数组翻转特定的位置
   * @param nums
   * @param start
   * @param end
   * @return
   */
  private static boolean reverse(int[] nums, int start, int end,int prev) {
    if (end> nums.length)return false;
    for (int i = start; i < end; i++) {
      if (0 == nums[i]) {
        nums[i] = 1;
        if (i == end - 1 && prev == 0) {
          prev = i;
        }
      } else {
        nums[i] = 0;
        if (prev == 0) {
          prev = i-1;
        }
      }
    }
    return true;
  }

}
