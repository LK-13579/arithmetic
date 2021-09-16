package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/16 15:28
 * @description 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]],
 * ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [5,4,0,3,1,6,2] 输出: 4 解释: A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6,
 * A[6] = 2.
 * <p>
 * 其中一种最长的 S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class ArrayNesting {

  public static void main(String[] args) {
    ArrayNesting arrayNesting = new ArrayNesting();
    int[] nums = {0,2,1};
    int i = arrayNesting.arrayNesting(nums);
    System.out.println(i);

  }

  public int arrayNesting(int[] nums) {
    int sum = 0;
    int data = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != -1) {
        data = recursion(i, nums, 0, 0);
        sum = data > sum ? data : sum;
      }
    }
    return sum;
  }

  public int recursion(int prev,int[] nums, int tmp,int sum) {
    if (nums[prev]==-1)return 0;
    tmp = prev;
    prev = nums[prev];
    nums[tmp] = -1;

    sum = recursion(prev, nums, tmp, sum);
    return sum += 1;
  }

  public int arrayNesting2(int[] nums) {
    HashSet set = new HashSet();
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      set = nesting(i, nums, set);
      if (set.size() > result) {
        result = set.size();
      }
      set.clear();
    }
    return result;
  }

  public HashSet nesting(int prev, int[] nums, HashSet set) {
    set.add(prev);
    if (set.contains(nums[prev])) {
      return set;
    }
    nesting(nums[prev], nums, set);
    return set;
  }
}
