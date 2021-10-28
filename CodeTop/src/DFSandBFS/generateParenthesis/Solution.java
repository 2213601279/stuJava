package DFSandBFS.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/24/10:34
 * @Description: 三尺秋水尘不染
 */

//括号匹配

public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs("",0,0,n,res);
        return res;
    }
    public static void dfs(String curStr, int left, int right, int n, List<String> res) {
        //不一样了和以前的dfs
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }
}
