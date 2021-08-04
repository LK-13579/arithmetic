package sort;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/4 15:41
 * @description
 *
 * 给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 *
 * arr 中 第一个 元素必须为 1 。
 * 任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 * 你可以执行以下 2 种操作任意次：
 *
 * 减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
 * 重新排列 arr 中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,2,1,2,1]
 * 输出：2
 * 解释：
 * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
 * arr 中最大元素为 2 。
 * 示例 2：
 *
 * 输入：arr = [100,1,1000]
 * 输出：3
 * 解释：
 * 一个可行的方案如下：
 * 1. 重新排列 arr 得到 [1,100,1000] 。
 * 2. 将第二个元素减小为 2 。
 * 3. 将第三个元素减小为 3 。
 * 现在 arr = [1,2,3] ，满足所有条件。
 * arr 中最大元素为 3 。
 * 示例 3：
 *
 * 输入：arr = [1,2,3,4,5]
 * 输出：5
 * 解释：数组已经满足所有条件，最大元素为 5 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxElement {

  public static void main(String[] args) {
    int[] arr = {2,2,1,2,1};
    MaxElement maxElement = new MaxElement();
    int result = maxElement.maximumElementAfterDecrementingAndRearranging2(arr);
    System.out.println(result);
  }

  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    int result = 1;
    for (int i = 0; i < arr.length; i++) {
      //标记最小值,题目要求第一个值必须为1
      int min = i;
      //如果第i个与第i+1个绝对值大于1，从第,i+1个开始寻找,找到最小值,然后计算绝对值
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          //记录下标
          min = j;
        }
      }
      //该元素是第一个,交换
      if (i == 0) {
        arr[min] = arr[i];
        arr[0] = 1;
        continue;
      }
      //该元素是第i个
      if (i > 0) {
        //计算这个与前一个的值是否>=1
        if (Math.abs(arr[i] - arr[i - 1]) <= 1) {
          //如果是赋值给result
//          result = arr[i];
        } else if (Math.abs(arr[min] - arr[i - 1]) <= 1) {
          //如果不是,判断最小值与i-1的绝对值是否>=1,
          int tmp = 0;
          tmp = arr[i];
          arr[i] = arr[min];
          arr[min] = tmp;
//          result = arr[i];
        } else {
          //如果不满足，则赋值前一个值+1
          arr[i] = arr[i - 1] + 1;
//          result = arr[i];
        }
        if (arr[i] > result) {
          result = arr[i];
        }
      }

    }
    return result;
  }


  public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
    int result = 1;
    for (int i = 0; i < arr.length; i++) {
      //该元素是第一个,交换
      if (i == 0) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[j] < arr[min]) {
            //记录下标
            min = j;
          }
        }
        arr[min] = arr[i];
        arr[0] = 1;
        continue;
      }
      //该元素是第i个
      if (i > 0) {
        //计算这个与前一个的值是否>=1
        if (Math.abs(arr[i] - arr[i - 1]) <= 1) {
          //如果是赋值给result
//          result = arr[i];
        } else {
          //标记最小值,题目要求第一个值必须为1
          int min = i;
          //如果第i个与第i+1个绝对值大于1，从第,i+1个开始寻找,找到最小值,然后计算绝对值
          for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
              //记录下标
              min = j;
            }
          }
          if (Math.abs(arr[min] - arr[i - 1]) <= 1) {
            //如果不是,判断最小值与i-1的绝对值是否>=1,
            int tmp = 0;
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
          } else {
            arr[i] = arr[i - 1] + 1;
          }
        }
        if (arr[i] > result) {
          result = arr[i];
        }
      }

    }
    return result;
  }
}
