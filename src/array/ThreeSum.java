package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/17 13:52
 * @description
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1fGaJU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    int[] arr = {0,0,0,0,0};
    List<List<Integer>> lists = threeSum.threeSum(arr);
    for (List list: lists) {
      System.out.println(list);
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
//    int[][] arr = new int[nums.length][3];
//    int prev = 0;
    if (nums.length<3)return list;
    Arrays.sort(nums);
//    int b = 0;
//    int c = 0;
//    int sum = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int fix = nums[i];
      int b = i + 1;
      int c = nums.length - 1;
      while (b < c) {
        int sum = fix + nums[b] + nums[c];
        if (sum < 0) {
          b++;
          continue;
        } else if (sum > 0) {
          c--;
          continue;
        } else {
          ArrayList<Integer> list1 = new ArrayList<>();
          list1.add(fix);
          list1.add(nums[b]);
          list1.add(nums[c]);
          list.add(list1);
          while (b<nums.length - 1 && nums[b] == nums[++b] && nums[c] == nums[--c]) {
            continue;
          }
        }
      }
      while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
        i += 1;
      }
    }
    return list;
  }

}
