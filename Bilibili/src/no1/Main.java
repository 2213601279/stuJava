package no1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/13/19:24
 * @Description: 三尺秋水尘不染
 */
/*
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,1,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]
 ]
*/

public class Main {

    static String[] str;
    static int[][] nums ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {
            //    System.out.println(line.toCharArray());
            //     System.out.println(line.toString().replace("[","").replace("]",""));
            str = line.trim().replace("[", "").replace("]", "").split(",");
           for (int i = 0; line==null;i++){
               for (int j = 0; j < str.length; j++) {
                   nums[j][i] = Integer.parseInt(str[i]);

               }
               }

           }
//            System.out.println(str[2]);
            System.out.println(str[2]);//lie
            System.out.println(str.length);//13

        }
//        for (int i = 0;i<str.length;i++){
//            for (int j = 0;j<str.length;j++){
//                System.out.println(nums[i][j]);;
//            }
//        }



//        for (int i=0;i<str.length;i++){
//            for (int j = 0;j<str.length;j++){
//                System.out.println(nums[i][j]);;
//            }
//        }

            public static int dfs(int[][] nums,int i,int j) {
                if (nums == null && nums.length == 0) {
                    return 0;
                }
                if(!inArea(nums, i, j)){
                    return 0;
                }if (nums[i][j]==1){
                    return 2;
                }return 1
                        +dfs(nums, i+1, j)
                        +dfs(nums, i, j+1)
                        +dfs(nums, i-1, j)
                        +dfs(nums, i, j-1);
            }

         public static boolean inArea(int[][] nums,int i,int j){
            return i < nums.length&&i>=0&&j<nums[0].length&&j>=0;
         }
}






