package SortCollection;

import java.util.Arrays;
import java.util.Random;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/17/9:21
 * @Description: 三尺秋水尘不染
 */
/*## [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)
        难度中等1285

        给定整数数组 `nums` 和整数 `k`，请返回数组中第 `**k**` 个最大的元素。

        请注意，你需要找的是数组排序后的第 `k` 个最大的元素，而不是第 `k` 个不同的元素。



        **示例 1:**

        ```
        输入: [3,2,1,5,6,4] 和 k = 2
        输出: 5
        ```

        **示例 2:**

        ```
        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
        输出: 4
        ```

 */


public class findKthLargest {

    static int k;
    public static void main(String[] args) {
         int[] arr =  {3,2,3,1,2,4,5,5,6};
        System.out.println(Arrays.toString(quicksort(arr)));
    }
//    5.掉方法
    public static int[] quicksort(int[] arr){
        RandomQuickSort(arr,0,arr.length);
        return arr;
    }

//4.使用随机选择主元并递归
public static void RandomQuickSort(int[] arr,int left,int right){

        int pos = RandomPartition(arr,left,right);

        RandomQuickSort(arr,left,pos-1);
        RandomQuickSort(arr,pos+1,right);
}

//3.调用并随机选择主元
    public static int RandomPartition(int[] arr,int left ,int right){
        int i = new Random().nextInt(right-left+1)+1;
//        swap(arr,i,right);
        swap(arr,right,i);
        return partition(arr,left,right);
    }
//        2.划分（核
//        心部分）
        public static int partition(int[] arr,int left,int right){
        int pivot = arr[right];
        int i =left - 1;
        for (int j = 0; j < right-1; j++) {
            if(arr[j] < pivot){
                i +=1;
                swap(arr,i,j);
                }
            }
        swap(arr,i+1,right);
        return i + 1;
        }


    //    1.swap
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
