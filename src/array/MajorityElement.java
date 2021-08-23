package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/23 14:14
 * @description
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

  public static void main(String[] args) {
    int[] arr = {3, 2, 3};
    MajorityElement element = new MajorityElement();
    List<Integer> integers = element.majorityElement(arr);

  }

  public List<Integer> majorityElement(int[] nums) {
    //数据中出现的大于i的元素
    int j = nums.length / 3;
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i]))continue;
      Integer numCount = map.get(nums[i]);
      Integer value = numCount == null ? map.put(nums[i], 1) : map.put(nums[i], numCount += 1);
      if (map.get(nums[i]) > j) {
        set.add(nums[i]);
      }
    }
    return new ArrayList<>(set);
  }
}
