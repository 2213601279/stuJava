package EasyTitle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/26/14:56
 * @Description: 三尺秋水尘不染
 */
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();

        for (int i = 0; i < length; i++) {
            //特殊条件
            if(nums[i] > 0){
                break;
            }
            //去重和前一个一样吗???
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //左右移动指针
            int left = i+1,right = length-1;
            while(left < right){
                int sum = nums[i]+ nums[left] +nums[right];
                if(sum ==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //避免重复
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right++;
                    left++;
                    right--;
                }
                else if(sum < 0){ left++;}
                else if(sum > 0){ right--;}
            }
        }
        

    return  ans;
    }

    public static void main(String[] args) {
       int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}

