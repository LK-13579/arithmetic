package sort;

import java.util.Random;

/**
 * @author 刘康
 * @version 1.0
 * @date 2021/8/9 17:29
 * @description
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] arr = {3, 1, 4, 2, 0, 6, 5, 7};
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(arr);
  }

  public void sort(int[] arr) {
    int[] clone = new int[arr.length];
    sort(arr, clone, 0, arr.length - 1);
  }

  /**
   * 递归方法
   * @param arr 原数组
   * @param clone 辅助数组
   * @param start 开始指针
   * @param end 结束指针
   */
  public void sort(int[] arr, int[] clone, int start, int end) {
    if (start >= end) {
      return;
    }
    //计算中间值
    int mid = (start + end) / 2;
    sort(arr, clone, start, mid);
    sort(arr, clone, mid + 1, end);
    merge(arr, clone, start, mid, end);
  }

  /**
   * 合并的核心方法
   * @param arr 原数组
   * @param clone 辅助数组
   * @param start 开始指针
   * @param mid 中间指针
   * @param end 结束指针
   */
  private void merge(int[] arr, int[] clone, int start, int mid, int end) {
    //两个数组的开始边界
    int i = start;
    int j = mid + 1;
    //两个数组的结束边界
    int m = mid;
    int n = end;
    //新排序好数组的起始边界
    int k = 0;

    //两组开始比较,当start大于等于mid边界的时候停止,当mid+1大于结束边界时候停止
    while (i <= m && j <= n) {
      if (arr[i] >= arr[j]) {
        clone[k++] = arr[j++];
      } else {
        clone[k++] = arr[i++];
      }
    }

    //当其中一组还有剩下的元素的时候,将其全部放置到新数组后面
    while (i <= m) {
      clone[k++] = arr[i++];
    }
    while (j <= n) {
      clone[k++] = arr[j++];
    }
    //将排好序的数据更新到原数组
    for (i = 0; i < k; i++) {
      arr[start + i] = clone[i];
    }
  }
}
