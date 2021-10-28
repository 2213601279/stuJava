package midSort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/09/21:09
 * @Description: 三尺秋水尘不染
 */
/*对于有序数组，可以使用二分查找的方法查找元素。

        但是这道题中，数组本身不是有序的，进行旋转后只保证了数组的局部是有序的，这还能进行二分查找吗？答案是可以的。

        可以发现的是，我们将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的。拿示例来看，我们从 6 这个位置分开以后数组变成了 [4, 5, 6] 和 [7, 0, 1, 2] 两个部分，其中左边 [4, 5, 6] 这个部分的数组是有序的，其他也是如此。

        这启示我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：

        如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [\textit{nums}[l],\textit{nums}[mid])[nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
        如果 [mid, r] 是有序数组，且 target 的大小满足 (\textit{nums}[mid+1],\textit{nums}[r]](nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。

 */
public class Main {
//画个图
    public int search(int[] num,int target){
        //结束条件
        if(num == null || num.length == 0){
            return -1;
        }
        //初始化变量
        int start =0, end = num.length - 1;
        int mid;

        while(start < end){
            //计算长度防止溢出

            mid = -(start-end)+start+1;

            if(num[mid] == target){
                return mid;
            }

            if(num[start] <= num[mid]){
                if(target >= num[start]&&target < num[mid]){
                    end =mid-1;
                }else{
                    start =mid+1;
                }
                }else{
                    if(target<=num[end]&&target>num[mid]){
                        start = mid+1;
                    }else{
                        end = mid-1;
                    }
                }

        }
        return -1;
    }
}
