package DFSandBFS;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/10/10:15
 * @Description: 三尺秋水尘不染
 */
/*
46. 全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。


示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 */

public class AllSort {
    /*
     * @Method: permute
     * @Description: 三尺秋水尘不染
     *  * @param num
     * @paramType:
     [int[]]
     * @return：java.util.List<java.util.List<java.lang.Integer>>
     * @Author: HaRiJi
     * @Date: 2021/9/20
     */
    //状态变量阶段数：
    public List<List<Integer>> permute(int[] num){
        int len = num.length;
        List<List<Integer>> res = new ArrayList<>() ;
        if(len == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];

        dfs(num,len,0,path,used,res);
        return res;

    }
/*
 * @Method: dfs
 * @Description: 三尺秋水尘不染
 *  * @param num
 * @param len
 * @param depth
 * @param path
 * @param used
 * @param res
 * @paramType:
 [int[], int, int, java.util.Deque<java.lang.Integer>, boolean[], java.util.List<java.util.List<java.lang.Integer>>]
 * @return：void
 * @Author: HaRiJi
 * @Date: 2021/9/20
 */
    private void dfs(int[] num, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len){
            //深入拷贝
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                path.addLast(num[i]);
                used[i] =true;
                dfs(num, len, depth + 1, path, used, res);
                //回溯
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = (sc.nextLine().split(","));
//jdk8的lambda表达式
        int[] nums = Arrays.stream(num).mapToInt(Integer::parseInt).toArray();

       AllSort solution = new AllSort();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
