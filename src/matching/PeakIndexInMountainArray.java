package matching;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/16 18:13
 * @description
 *
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/B1IidL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PeakIndexInMountainArray {

  public static void main(String[] args) {
    PeakIndexInMountainArray mountainArray = new PeakIndexInMountainArray();
    int[] arr = {0,2,1,0};
    int i = mountainArray.peakIndexInMountainArray(arr);
    System.out.println(i);
  }

  public int peakIndexInMountainArray(int[] arr) {
    return mountain(arr, 0, arr.length);

  }

  private int mountain(int[] arr, int left, int right) {
    if (left >= right) {
      return arr[left] >= arr[right] ? left : right;
    }
    int mid = (left + right) / 2;
    if (mid>left && arr[mid] < arr[mid - 1]) {
      return mountain(arr, left, mid - 1);
    } else if (mid  < right && arr[mid] < arr[mid + 1]) {
      return mountain(arr, mid + 1, right);
    } else {
      return mid;
    }
  }
}
