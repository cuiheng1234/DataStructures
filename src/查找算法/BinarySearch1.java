package 查找算法;

public class BinarySearch1 {
    public static void main(String[] args) {
        int[] arr = {12, 16, 19, 23, 54};

        int result = BinarySearch.binarySearch(arr,0, 5, 16);
        int result1 = binarySearch1(arr, 16);

        System.out.println(result);
        System.out.println(result1);
    }

    public static int binarySearch1(int[] arr, int target){
        int max = arr.length-1;
        int min = 0;
        int mid = (min + max )/2;
        while(true){
            if(target>arr[mid]){
                min = mid+1;
            }else if(target<arr[mid]){
                max = mid-1;
            }else{   //找到了元素
                return mid;
            }

            //没有找到
            if(max < min){
                return -1;
            }
            //重新计算中间的索引值
            mid = (min+max)/2;
        }
    }
}
