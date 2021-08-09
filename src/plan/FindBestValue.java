package plan;

import java.util.Arrays;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/6 15:17
 * @description 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近 
 * target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10 输出：3 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。 示例
 * 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10 输出：5 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803 输出：11361
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBestValue {

  public static void main(String[] args) {
    int[] arr = {60864,25176,27249,21296,20204};
    FindBestValue demo = new FindBestValue();
    int result = demo.findBestValue(arr, 56803);
    System.out.println(result);
  }


  public int findBestValue(int[] arr, int target) {
    if (arr.length <= 0) {
      return 0;
    }
    //1.根据target与数组大小计算平均值
    int middle = target / arr.length;
    int arrMax = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > arrMax) {
        arrMax = arr[i];
      }
    }
    //2.根据平均值替换大于该值的数并计算总值
    int sumTarget = 0;
//    int difference;
    int abs = 0;
    //3.往上将平均值逐渐递增,没递增一次计算该值与target的差值的绝对值
    for (int j = middle; middle <= arrMax; middle++) {
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] > middle) {
          sumTarget += middle;
        } else {
          sumTarget += arr[i];
        }
      }
      int difference = Math.abs(target - sumTarget);
      //4.总值与target相等的时候停止;平均值大于数据最大值时候停止;
      if (difference == 0) {
        return middle;
      } else if (abs !=0 && abs <= difference) {
        return middle - 1;
      } else if (middle == arrMax) {
        return middle;
      } else {
        sumTarget = 0;
        abs = difference;
        continue;
      }
    }
    return middle;
  }


  public int findBestValue2(int[] arr, int target) {
    if (arr.length <= 0) {
      return 0;
    }
    //1.根据target与数组大小计算平均值
    int middle = target / arr.length;
    int arrMax = 0;
    Arrays.sort(arr);
    arrMax = arr[arr.length - 1];
//    for (int i = 0; i < arr.length; i++) {
//      if (arr[i] > arrMax) {
//        arrMax = arr[i];
//      }
//    }
    //2.根据平均值替换大于该值的数并计算总值
    int sumTarget = 0;
//    int difference;
    int abs = 0;
    //3.往上将平均值逐渐递增,没递增一次计算该值与target的差值的绝对值
    for (int j = middle; middle <= arrMax; middle++) {
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] > middle) {
          sumTarget += middle;
        } else {
          sumTarget += arr[i];
        }
      }
      int difference = Math.abs(target - sumTarget);
      //4.总值与target相等的时候停止;平均值大于数据最大值时候停止;
      if (difference == 0) {
        return middle;
      } else if (abs !=0 && abs <= difference) {
        return middle - 1;
      } else if (middle == arrMax) {
        return middle;
      } else {
        sumTarget = 0;
        abs = difference;
        continue;
      }
    }
    return middle;
  }
}
