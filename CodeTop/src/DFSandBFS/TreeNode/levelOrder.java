package DFSandBFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/26/17:09
 * @Description: 三尺秋水尘不染
 */
//二叉树的层序便利

public class levelOrder {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            //终止条件
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        //结果集
        List<List<Integer>> ans = new ArrayList();
        //层
        int index = 0;

        dfs(index,ans,root);
        return  ans;
        }
        /*
         * @Method: dfs
         * @Description: 三尺秋水尘不染
         *  * @param index
         * @param ans
         * @param root
         * @paramType:
         [int, java.util.List<java.util.List<java.lang.Integer>>, DFSandBFS.TreeNode.levelOrder.TreeNode]
         * @return：void
         * @Author: HaRiJi
         * @Date: 2021/9/26
         */
        public void dfs(int index, List<List<Integer>>ans, TreeNode root){
            //终止条件 输出的数组大小要小于 当前索引的大小+1
            if(ans.size() < index + 1 ){
               ans.add(new ArrayList<Integer>()) ;
            }
            //第零层的更节电直接加入
            ans.get(index).add(root.val);

            if(!(root.left == null)){
                dfs(index+1,ans,root.left);
            }
            if(root.right != null){
                dfs(index+1,ans,root.right);
            }
        }
    }
}
