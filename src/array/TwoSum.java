package array;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/9/26 14:05
 * @description 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <=
 * numbers.length 。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 *   示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9 输出：[1,2] 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 示例
 * 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6 输出：[1,3] 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1 输出：[1,2]  
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104 -1000 <= numbers[i] <= 1000 numbers 按 非递减顺序 排列 -1000 <= target <=
 * 1000 仅存在一个有效答案
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
//    int[] arr = {1, 3, 4, 4};
//    int[] arr = {2,3,4};
    int[] arr = {2,7,11,15};

    int[] ints = twoSum.twoSum(arr, 9);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  /**
   * 双指针,一趟,最快
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (sum == target) {
        return new int[]{low + 1, high + 1};
      } else if (sum < target) {
        ++low;
      } else {
        --high;
      }
    }
    return new int[]{-1, -1};
  }



  public int[] twoSum3(int[] numbers, int target) {
    int[] result = new int[2];

    for (int i = 0; i < numbers.length; i++) {
      int i1 = target - numbers[i];
      int mid = (i + numbers.length - 1) / 2;
      //刚好中间值就是该值
      if (numbers[mid] == i1 && i != mid) {
        result[0] = ++i;
        result[1] = ++mid;
      } else if (numbers[mid] > i1) {
        //向左寻找
        while (mid > i && numbers[mid] >= i1) {
          if (numbers[mid] == i1) {
            result[0] = ++i;
            result[1] = ++mid;
            break;
          }
          mid--;
        }
      } else {
        while (mid < numbers.length && numbers[mid] <= i1) {
          if (numbers[mid] == i1 && mid != i) {
            result[0] = ++i;
            result[1] = ++mid;
            break;
          }
          mid++;
        }
      }

    }
    return result;
  }

  /**
   * 两层循环遍历
   *
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum2(int[] numbers, int target) {
    int[] result = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      int i1 = target - numbers[i];
      int j = i + 1;
      while (j < numbers.length) {
        if (numbers[j] == i1) {
          result[0] = ++i;
          result[1] = ++j;
          break;
        } else if (numbers[j] < i1) {
          j++;
        } else if (numbers[j] > i1) {
          break;
        }
      }
    }
    return result;
//    int mid = numbers.length / 2;
//    mid = twoSum(numbers, target, mid);
  }

  public int twoSum(int[] numbers, int target, int mid) {
    //当中间值大于target的时候,直接二分
    if (numbers[mid] > target) {
      return twoSum(numbers, target, (mid - 1) / 2);
    } else {
      return mid;
    }
  }


}
