package DFSandBFS.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//  Created with IntelliJ IDEA.
//
//  @Author: 张驰
//  @Date: 2021/09/27/9:15
//  @Description: 三尺秋水尘不染
// /
/*
给定一棵二叉树的根节点root ，请找出该二叉树中每一层的最大值。

        示例1：

        输入: root = [1,3,2,5,3,null,9]
        输出: [1,3,9]
        解释:
        1
        / \
        3   2
        / \   \
        5   3   9
        示例2：

        输入: root = [1,2,3]
        输出: [1,3]
        解释:
        1
        / \
        2   3
        示例3：

        输入: root = [1]
        输出: [1]
        示例4：

        输入: root = [1,null,2]
        输出: [1,2]
        解释:
                  1
                   \
                    2
        示例5：

        输入: root = []
        输出: []


 */

public class largestValues {
   
     // Definition for a binary tree node.
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
     
    class Solution{
        public List<Integer> largestValues(TreeNode root) {
            //需要打印结果
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return new ArrayList<>();
            }
            //队列是为了  添加  Tree Node
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            //将根节点加入deque
            deque.offer(root);
            int index = 0;

            while(!deque.isEmpty()){
                //size  为  当前的动态队列的大小
                int size = deque.size();
                //维护 最大值  在每次遍历的时候
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    max = Math.max(max, node.val);

                    //添加下一层的节点
                    if( node.left != null){
                        deque.offer(node.left);
                    }
                    if(node.right != null){
                        deque.offer(node.right);
                    }
                }
                ans.add(max);
            }
            return  ans;
        }


    }

    
}
