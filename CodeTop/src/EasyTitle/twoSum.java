package EasyTitle;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/26/14:55
 * @Description: 三尺秋水尘不染
 */
public class twoSum {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0 ; i < nums.length; i++){
                if(map.containsKey(target - nums[i]) ){
                    return new int[] {map.get(target - nums[i]),i};
                }
                map.put(nums[i],i);
            }
            return new int[0];
        }
    }

