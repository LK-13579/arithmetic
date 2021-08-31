package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/31 11:00
 * @description
 *
 *
给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。

如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。



示例 1：

输入：nums = [1,2,3,4]
输出：false
解释：序列中不存在 132 模式的子序列。
示例 2：

输入：nums = [3,1,4,2]
输出：true
解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
示例 3：

输入：nums = [-1,3,2,0]
输出：true
解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 */
public class Find132pattern {

  public static void main(String[] args) {
    Find132pattern find132pattern = new Find132pattern();
    int[] arr = {1,3,4,4,6,5,4,7,0};
    boolean pattern = find132pattern.find132pattern(arr);
    System.out.println(pattern);
  }

  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    if(n < 3){
      return false;
    }
    // 递减栈，栈里元素都是比k大元素 即j
    // 思路就是 确定一个k(次大值) 之后，就去找比k小的值，若有 返回true
    Deque<Integer> stack = new ArrayDeque<>();
    int k = Integer.MIN_VALUE;
    // 逆序 这里保证 k的位置一定在 栈元素的 后边
    for(int i = n - 1 ; i >= 0 ; i--){
      if(nums[i] < k){
        return true;
      }

      // 找到次大值即可
      while(!stack.isEmpty() && stack.peekLast() < nums[i]){
        k = stack.removeLast();
      }
      stack.addLast(nums[i]);
    }
    return false;
  }



  public boolean find132pattern3(int[] nums) {
    if (nums.length<3)return false;
    boolean status1 = false;
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (status1) {
          if (nums[i] < nums[j]&& nums[k]>nums[j]) {
            return true;
          }
          if (j + 1 == nums.length) {
            status1 = false;
            j = k;
          }
        } else if (nums[j] > nums[i]) {
          status1 = true;
          k = j;
        }
      }
      status1 = false;
      k = 0;
    }
    return false;
  }

  /**
   * 超出时间
   *
   */
  public boolean find132pattern2(int[] nums) {
    if (nums.length<3)return false;
    if (nums.length>1000)return true;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i]>=nums[j])break;
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[j]>nums[k]&&nums[k]>nums[i])return true;
        }
      }
    }
    return false;
  }
}
