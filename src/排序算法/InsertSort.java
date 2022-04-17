package 排序算法;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
//      int[] arr = {101, 34, 119, 35, 89};
        insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入位置找到:insertIndex+1
            if(insertIndex +1 == i) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.printf("第轮%d插入后：%s\n" , i, Arrays.toString(arr));
            System.out.println();
        }
    }
}
