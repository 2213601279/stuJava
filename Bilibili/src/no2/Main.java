package no2;

import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/13/19:51
 * @Description: 三尺秋水尘不染
 */
/*
3 3
1 2 3
4 5 6
7 8 9
-1 -1
 */
public class Main  {
    static int M = 0, N = 0;
    static int[] num  = new int[100];
    static int[][] arr ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end1 =0,end2 = 0;
        while(sc.hasNextInt()){
           M = sc.nextInt();
           N = sc.nextInt();
            arr = new int[M][N];
            for (int i = 0; i <M; i++) {
                for (int j = 0; j <N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            end1 = sc.nextInt();
            end2 = sc.nextInt();
            if(end1==-1&&end2==-1){
                break;
            }
        }
//检验
//        System.out.println("m"+M);
//        System.out.println("n"+N);
//        System.out.println("end1"+end1);
//        System.out.println("end2"+end2);
//        for (int i = 0; i <M; i++) {
//            for (int j = 0; j <N; j++) {
//            System.out.println(arr[i][j]);
//            }
//        }
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
//        Main.dfs(arr,M,N);
        System.out.println("方法1:");
        System.out.println(Main.spiralOrder( arr));
        System.out.println("方法2");
        System.out.println(Main.spiral2(arr));
    }
//、、按层模拟版本
       public static  List<Integer> spiralOrder (int[][] matrix){
           List<Integer> order = new ArrayList<Integer>();
//           、、终止条件
           if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
               return order;
           }
//           、、初始化参数
           int rows = matrix.length, columns = matrix[0].length;
           int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

           while (left <= right && top <= bottom) {
               for (int column = left; column <= right; column++) {
                   order.add(matrix[top][column]);
               }
               for (int row = top + 1; row <= bottom; row++) {
                   order.add(matrix[row][right]);
               }
               if (left < right && top < bottom) {
                   for (int column = right - 1; column > left; column--) {
                       order.add(matrix[bottom][column]);
                   }
                   for (int row = bottom; row > top; row--) {
                       order.add(matrix[row][left]);
                   }
               }
               left++;
               right--;
               top++;
               bottom--;
           }
           return order;
       }
    private static List<Integer> spiral2(int[][] matrix) {

        LinkedList<Integer> result = new LinkedList<>();

        if(matrix==null||matrix.length==0||matrix[0].length==0) return result;
        int left = 0;        int right = matrix[0].length - 1;
        int top = 0;        int bottom = matrix.length - 1;

        int numEle = matrix.length * matrix[0].length;

        while (numEle >= 1) {
//            left - right ->   上界缩小
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
//            top缩小
            top++;
//            top - bottom |    右界缩小
//                         v
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }

            right--;
            //  right - left bottom缩小
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;

            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }

    }

