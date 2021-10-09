package array;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/10/9 15:19
 * @description
 *
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * 示例:
 *
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 *
 * 1 <= array1.length, array2.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSwapValues {

//  public static void main(String[] args) {
//    LocalDate now = LocalDate.now();
//    LocalDate localDate = now.minusDays(180);
//    System.out.println(localDate);
//
//  }

  public static void main(String[] args) {
    int[] arr1 = {1,2,3};
    int[] arr2 = {4, 5, 6};
    FindSwapValues findSwapValues = new FindSwapValues();
    int[] swapValues = findSwapValues.findSwapValues(arr1, arr2);
    for (int i = 0; i < swapValues.length; i++) {
      System.out.println(swapValues[i]);
    }
  }

  public int[] findSwapValues(int[] array1, int[] array2) {
    //1.计算两个数组的和只差,排序
    //2.从头遍历开始寻找,两者之差为1计算的结果并且两者都不想等,那么就可以进行交换
    int arr1 = 0;
    int arr2 = 0;
    for (int i = 0; i < array1.length; i++) {
      arr1 += array1[i];
    }
    for (int i = 0; i < array2.length; i++) {
      arr2 += array2[i];
    }
    int gap = Math.abs(arr1 - arr2);
    int[] result = new int[2];
    Arrays.sort(array1);
    for (int i = 0; i < array1.length; i++) {
      //大于等于差值的时候直接过滤
      if (array1[i] >= gap) {
        continue;
      } else {
        for (int j = 0; j < array2.length; j++) {
          if (array2[j] == gap - array1[i]) {
            result[0] = array1[i];
            result[1] = array2[j];
          }
        }
      }
    }
    return result;
  }

}
