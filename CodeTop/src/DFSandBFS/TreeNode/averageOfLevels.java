package DFSandBFS.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

         

        示例 1：

        输入：
        3
        / \
        9  20
        /  \
        15   7
        输出：[3, 14.5, 11]
        解释：
        第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


  */


public class averageOfLevels {
  
     // Definition for a binary tree node.
      public class TreeNode {
          double val;
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
        public List<Double> averageOfLevels(TreeNode root) {
            HashMap<Integer, Double> sum = new HashMap<>();
            HashMap<Integer, Double> count = new HashMap<>();

            dfs(root,0,sum,count);
            List<Double> average = new ArrayList<>();
            average.set(1,1.2);
            average.set(2,2.2);
            for (int i = 0; i < sum.size(); i++) {
                average.add(sum.get(i)/count.get(i));
                System.out.println(average);
            }
            return average;
        }
        public void dfs(TreeNode root,int index,HashMap<Integer, Double> sum,HashMap<Integer, Double> count){
            //zhongzhi

            if (root == null){
                return;
            }
            //ceng

            if(index < count.size()){
                sum.put(index,root.val+sum.get(index));
                count.put(index, count.get(index) + 1);
            }else{

            }
        }
    }
}


