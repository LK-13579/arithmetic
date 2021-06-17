package sort;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/6/17 11:41
 * @description 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {

  public static void main(String[] args) {
    int[] nums = {1,0,2,2,1,0};
    sortColor2(nums);
  }

  /**
   * 排序
   * @param nums 数组
   */
  public static void sortColors(int[] nums) {
    int tmp = 0;
    for (int i = nums.length; i > 0 ; i--) {
      for (int j = 0; j <i -1; j++) {
        //交换
        if (nums[j] > nums[j + 1]) {
          tmp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = tmp;
        }
      }
    }
    System.out.println(nums);
  }

  /**
   * 双指针模式
   * @param nums 数组
   */
  public static void sortColor(int[] nums) {
    //标记头尾
    int head = 0;
    int tail = nums.length -1;
    //零时存储
    int tmp = 0;

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] == 2 && i < tail) {
        tmp = nums[i];
        nums[i] = nums[tail];
        nums[tail] = tmp;
        tail--;
      }
      while (nums[i] == 0 && i != head) {
        tmp = nums[i];
        nums[i] = nums[head];
        nums[head] = tmp;
        head++;
      }
    }
    System.out.println(nums);
  }

  public static void sortColor2(int[] nums) {
    int num0 = 0, num1 = 0, num2 = 0;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == 0) {
        nums[num2++] = 2;
        nums[num1++] = 1;
        nums[num0++] = 0;
      }else if(nums[i] == 1) {
        nums[num2++] = 2;
        nums[num1++] = 1;
      }else {
        nums[num2++] = 2;
      }
    }
    System.out.println(nums);
  }

  private static void swap(int i, int j) {
    int tmp;
    tmp = i;
    i = j;
    j = tmp;
  }
}
