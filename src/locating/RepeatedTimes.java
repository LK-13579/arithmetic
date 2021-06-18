package locating;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/6/18 11:08
 * @description
 *
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中<b>有一个</b>元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedTimes {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3};
    int i = repeatedNTimes(nums);
    System.out.println(i);
  }

  public static int repeatedNTimes(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int data = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      boolean add = set.add(num);
      if (!add) {
        data = num;
        break;
      }
    }
    return data;
  }

  /**
   * 未读清楚题意
   * @param nums 数组
   * @return int
   */
  public static int repeatedNTimesBack(int[] nums) {
    int a = 0;
    int[][] arr = new int[nums.length][nums.length - 1];
    String[] strings = new String[nums.length];
    //遍历原数组
    for (int i = 0; i < nums.length - 1; i++) {
      //获取数组的值
      int num = nums[i];
      //遍历二维数组中是否含有该数
      for (int j = 0; j <strings.length - 1; j++) {
        String str = strings[j];
        //包含该数并且数组不为空,添加到尾部
        if (str != null && !str.equals("")) {
          str.concat(",").concat(String.valueOf(num));
          strings[j] = str;
          if (strings[j].length() > a) {
            a = j;
          }
        } else {
          strings[j] = String.valueOf(num);
          if (strings[j].length() > a) {
            a = j;
          }
        }
        if (strings[j + 1] == null) {
          break;
        }
      }
    }
    return strings[a].split(",").length;
  }
}
