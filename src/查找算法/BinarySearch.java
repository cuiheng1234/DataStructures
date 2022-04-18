package 查找算法;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};

//        int resIndex = binarySearch(arr, 0, arr.length-1, 1000);
//        System.out.println("resIndex:"+resIndex);

        List<Integer> resIndex = binarySearchAll(arr, 0, arr.length-1, 124);
        System.out.println("resIndex:"+resIndex);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal){

        if(left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midValue = arr[mid];

        if(findVal > midValue){  //向右递归
            return binarySearch(arr, mid+1, right, findVal);
        }else if(findVal < midValue){  //向左递归
            return binarySearch(arr, left, mid-1, findVal);
        }else{
            return mid;
        }

    }

    public static List<Integer> binarySearchAll(int[] arr, int left, int right, int findVal){

        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        int midValue = arr[mid];

        if(findVal > midValue){  //向右递归
            return binarySearchAll(arr, mid+1, right, findVal);
        }else if(findVal < midValue){  //向左递归
            return binarySearchAll(arr, left, mid-1, findVal);
        }else{
            List<Integer> list = new ArrayList<Integer>();
            //向左边扫描
            int temp = mid - 1;
            while(true){
                if(temp <0 || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);


            //向左边扫描
            temp = mid + 1;
            while(true){
                if(temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }

    }
}
