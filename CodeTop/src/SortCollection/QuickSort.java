package SortCollection;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/09/15:46
 * @Description: 三尺秋水尘不染
 */

/*
215. 数组中的第K个最大元素
        给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

        示例 1:

        输入: [3,2,1,5,6,4] 和 k = 2
        输出: 5
        示例 2:

        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
        输出: 4
*/
    
//快排3.0
public class QuickSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 0;int[] num = new int[100];

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            num[i] =n;
            i++;
        }

       new QuickSort().arrSort(num);

    }
    public int[] arrSort(int[] num){
        randomQuickSort(num,0,num.length);
        return num;
    }

    public void randomQuickSort(int[] num,int left ,int right){
        if(left < right){
            int pos = randomizedPartition(num,left,right);
            randomQuickSort(num, left, pos-1);
            randomQuickSort(num,pos+1,right);
        }
    }

    //随机选取主元
    public int randomizedPartition(int[] num,int left,int right){
       int i = new Random().nextInt(right-left+1)+1;
       swap(num,right,i);
       return partition(num,left,right);
    }

    //核心函数(默认轴的值在右边)
    public int partition(int[] num,int left,int right){
        int pivot = num[right];
        int i= left-1;
        for (int j = 1; j < right-1; j++){
            if(num[j] < pivot){
                i +=1;
                swap(num,i,j);
            }
        }
        swap(num,i+1,right);
        return i+1;
    }

    public void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp ;
    }
}
/*快排1.0class Solution{
//    public int[] merge(int[] a, int[] b) {
//        int[] res = new int[a.length + b.length];
//        int j = 0;
//        for(int i = 0; i < a.length; i++) {
//            res[j] = a[i];
//            j++;
//        }
//        for(int i = 0; i < b.length; i++) {
//            res[j] = b[i];
//            j++;
//        }
//        quickSort(res, 0, res.length - 1);
//        return res;
//    }
//    private static void quickSort(int[] a, int left, int right) {
//        int l = left, r = right;
//        if (left < right) {
//              最左边的主元
//            int key = a[left];
//           while(l < r){//当l == r时，就是调整完成时
//            //从后往前找第一个小于val的数字
//            while (l < r && num[r] > val){
//                r --;
//            }
//            if(l < r){//找到了数字
//                num[l++] = num[r];
//            }
//            //从前往后找第一个大于val的数字
//            while (l < r && num[l] < val){
//                l ++;
//            }
//            if(l < r){//找到了数字
//                num[r--] = num[l];
//            }
//}
//        //l==r,基准数放进去
//        num[l] = val;
//        quickSort(num,i,l-1);
//        quickSort(num,l+1,j);
//        }
   }
*/