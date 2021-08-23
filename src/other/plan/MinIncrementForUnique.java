package other.plan;

import java.util.Arrays;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/16 15:16
 * @description
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinIncrementForUnique {

  public static void main(String[] args) {
    MinIncrementForUnique minIncrementForUnique = new MinIncrementForUnique();
    int[] arr = {2,2,2,2,0};
    int i = minIncrementForUnique.minIncrementForUnique3(arr);
    System.out.println(i);
  }

  public int minIncrementForUnique3(int[] nums) {
    Arrays.sort(nums);
//    int count = 0;
    int preNum = nums[0];
    int res = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] >= preNum + 1) {
        preNum = nums[i];
      } else {
        // A[i] < preNum + 1
        res += (preNum + 1 - nums[i]);
        preNum++;
      }
    }
    return res;
  }

  public int minIncrementForUnique2(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }
    int max = 0;
    int min = -1;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = i;
      }
      if (min == -1 || nums[i] < min) {
        min = nums[i];
      }
      count += nums[i];
    }
    int baseCount = 0;
    if (nums[max] > nums.length) {
      baseCount = nums[max] + (nums.length * (nums.length - 1)) / 2;
    } else {
      baseCount = nums.length + (nums.length * (nums.length - 1)) / 2;
    }
    if (min == 0) {
      baseCount = baseCount - nums.length;
    }
    return Math.abs(baseCount - count);
  }

  public int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j <nums.length ; j++) {
        while (nums[j] <= nums[i]) {
          nums[j]++;
          count++;
        }
        break;
      }
    }
    return count;
  }
}
