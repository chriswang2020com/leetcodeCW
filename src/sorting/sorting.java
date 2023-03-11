package sorting;

import java.util.Arrays;

/**
 * ClassName: sorting Package sorting Description Author zwang2654
 *
 * @Create 3/10/2023 6:12 PM
 * @Version 1.0
 */
public class sorting {
  public void main(String[] args){
    int[] arr = {5,3,8,9,4,2,33,69,2,100};
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void insertionSort(int[] arr){
    for (int i = 0; i < arr.length -1; ++i){
      int end = i;
      int item = arr[end+1];
      while (item < arr[end]){
        --end;
      }
      arr[end+1] = item;

    }
  }
}
