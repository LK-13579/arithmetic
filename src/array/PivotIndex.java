package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/24 9:47
 * @description
 *
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 *
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PivotIndex {

  public static void main(String[] args) {
    PivotIndex pivotIndex = new PivotIndex();
    int[] arr = {1, 2, 3};
    int i = pivotIndex.pivotIndex(arr);
    System.out.println(i);
  }

  /**
   * 采用二分递归的方式求解
   *
   * @param nums
   * @return
   */
  public int pivotIndex(int[] nums) {
    //标记中间位置
    int mid = nums.length / 2;
    return pivotIndexMid(nums, mid);
  }
  public int pivotIndexMid(int[] nums,int mid) {
    int leftCount = 0;
    int rightCount = 0;
    int m = 0;
    int n = mid+1;
    while (m < mid) {
      leftCount += nums[m++];
    }
    while (n < nums.length) {
      rightCount += nums[n++];
    }
    if (leftCount == rightCount) {
      return mid;
    } else if (leftCount > rightCount && mid >= 0) {
      mid--;
      mid =  pivotIndexMid(nums, mid);
    } else if (leftCount < rightCount && mid <= nums.length) {
      mid++;
      mid =  pivotIndexMid(nums, mid);
    } else {
      mid = -1;
    }
    return mid;
  }


  /**
   * 采用直接遍历的方式求解
   *
   * @param nums
   * @return
   */
  public int pivotIndex2(int[] nums) {
    //i即中心下标的位置
    int leftCount = 0;
    int rightCount = 0;
    int m = 0;
    for (int i = 0; i < nums.length; i++) {
      while (m < i) {
        leftCount += nums[m++];
      }
      for (int j = i + 1; j < nums.length; j++) {
        rightCount += nums[j];
//        if (rightCount > leftCount) {
//          break;
//        }
      }
      if (leftCount == rightCount) {
        return i;
      } else {
        leftCount = 0;
        rightCount = 0;
        m = 0;
        continue;
      }
    }
    return -1;
  }

}
