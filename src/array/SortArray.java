package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/14 13:46
 * @description 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1] 输出：[1,2,3,5] 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0] 输出：[0,0,1,1,2,5]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArray {

  public static void main(String[] args) {
    int[] nums = {5, 2, 3, 1};
    SortArray sortArray = new SortArray();
    int[] ints = sortArray.sortArray(nums);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  public int[] sortArray(int[] nums) {
    //先划分数组
    int[] tmp = new int[nums.length];
    return sort(nums, 0, nums.length -1);
  }

  public int[] sort(int[] nums, int left, int right) {
    int mid = (left + right) / 2;
    //判断边界
    if (right > left) {
      //首先计算中间位置的数值，之后左递归
      sort(nums, left, mid);
      sort(nums, mid + 1, right);
      return merge(nums, left, mid, right);
    }
    return null;
  }

  private int[] merge(int[] nums, int left, int mid, int right) {
    int[] tmp = new int[right - left + 1];

    int prev = 0;
    int i = left;
    int j = mid + 1;

    //控制最左边的数据
    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        tmp[prev++] = nums[i++];
      } else if (nums[i] > nums[j]) {
        tmp[prev++] = nums[j++];
      }
    }

    while (i <= mid) {
      tmp[prev++] = nums[i++];
    }

    while (j <= right) {
      tmp[prev++] = nums[j++];
    }

    for (int k = 0; k < tmp.length; k++) {
      nums[k + left] = tmp[k];
    }

    return nums;
  }

//  private int[] merge(int[] leftArr, int[] rightArr) {
//
//  }

}
