package sorting;

import java.util.*;

/**
 * ClassName: sorting Package sorting Description Author zwang2654
 *
 * @Create 3/10/2023 6:12 PM
 * @Version 1.0
 */
public class sorting {
  public static void main(String[] args){
    int[] arr = {10,8,9,7,6,5,4,3,2,1};
    heapSort(arr);
    System.out.println("堆排" +Arrays.toString(arr));
  }

  static void quickSort(int[] arr){
    quickSort(arr, 0, arr.length - 1);
  }

  static void quickSort(int[] arr, int left, int right){
    if (left > right) return;
    int l = left, r = right , pivot = arr[left];
    while(l < r){
      while (l < r && arr[r] >= pivot) r--;
      while (l < r && arr[l] <= pivot) l++;
      swap(arr, l, r);
    }
    swap(arr, l, left);
    quickSort(arr, left, l-1);
    quickSort(arr, l+1, right);
  }

  private static void swap(int[] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void heapSort(int[] array) {
    // 创建一个最小堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // 将数组元素依次加入最小堆
    for (int num : array) {
      minHeap.offer(num);
    }

    // 依次从最小堆中取出最小值，覆盖原数组元素
    for (int i = 0; i < array.length; i++) {
      array[i] = minHeap.poll();
    }
  }

  /**
   * 插入排序 has time complexity O(N^2),best O(N), space complexity O(1)
   * 学习网站：https://blog.csdn.net/weixin_50886514/article/details/119045154?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167845083516800182175508%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167845083516800182175508&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-119045154-null-null.142^v73^control,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=%E6%8E%92%E5%BA%8F&spm=1018.2226.3001.4187
   * @param arr
   */
  public static void insertionSort(int[] arr){
    for (int i = 0; i < arr.length -1; i++){
      int end = i; // 0
      int item = arr[end+1];// 1, 3
      // 单趟排序
      while (end >= 0 && item < arr[end]  ){
        // PUSH NUMBER BACK
        arr[end+1] = arr[end];
        end--;
      }
      arr[end+1] = item;
    }
  }

  public static void shellSort(int[] arr){
    int gap = arr.length;
    while(gap>1){
      gap = gap/2;
      for (int i = 0; i<arr.length-gap; i++){
        int end = i;
        int tem = arr[end+gap];
        // 单趟排序，每个元素比较，tem小于end，取出end，end+gap位置改为end的数，end调为上一个元素
        // 直到大于为止，不动end+gap，改为tem值，即为正确
        while (end>=0 && tem<arr[end]){
          arr[end+gap] = arr[end];
          end -= gap;
        }
        arr[end+gap] = tem;
      }
    }
  }

   static void selectSort(int[] arr){
    int begin = 0;
    int end = arr.length-1;
    while (begin<end){
      int maxi = begin;
      int mini = begin;
      for (int i = begin; i<=end; i++){

        if (arr[i]<arr[mini]){
          mini = i;
        }
        if (arr[i]>arr[maxi]){
          maxi = i;
        }
      }

      System.out.println(Arrays.toString(arr));
      swap(arr,mini,begin);
      if (maxi == begin){
        maxi = mini;
      }
      swap(arr,maxi,end);
      ++begin;
      --end;

    }
  }


}


