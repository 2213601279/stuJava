package no1;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numRows int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> generate (int numRows) {
        // write code here
        if(numRows <= 0){

            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.add(list1);
        if(numRows == 1){
            return list;
        }
//        2
        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(1);
        list.add(list2);

        if(numRows == 2){
            return list;
        }
        for (int i = 3; i < numRows+1; i++) {
            ArrayList<Integer> list3 =  list.get(i-1-1);
            ArrayList<Integer> list4 = new ArrayList<>();
            list4.add(1);
            for (int j = 2; j < i; j++) {
                int num1 = list3.get(j-1);
                int num2 = list3.get(j-1-1);
                list4.add(num1 + num2);
            }
            list4.add(1);
            list.add(list4);
        }


    return list;
    }
//    public List<List<Integer>> generate(int numRows) {
//        if (numRows <= 0) {
//            //直接返回一个空的 List
//            return new ArrayList<>();
//        }
//
//        //result 用来表示最终结果，这个 result 中就包含了若干行
//        List<List<Integer>> result = new ArrayList<>();
//        //处理第一行，就是固定的一个 1
//        List<Integer> firstLine = new ArrayList<>();
//        firstLine.add(1);
//        result.add(firstLine);
//        if (numRows ==1) {
//            //参数为 1  的试试，返回结果：
//            //[
//            //  [1]
//            //]
//            return result;
//        }
//        //处理第 2 行，就是固定的两个 1
//        List<Integer> secondLine = new ArrayList<>();
//        secondLine.add(1);
//        secondLine.add(1);
//        result.add(secondLine);
//        if (numRows == 2) {
//            return result;
//        }
//        //3. 处理后续第 i 行的情况，
//        //a) 每一行的第一个元素和最后一个元素都是 1
//        //b) 每一行的列数都是和行数相同
//        //c) i,j => i-1, j-1 + i-1, j
//        for (int row = 3; row <= numRows; row++) {
//            //当前行是 row ,上一行就是 row-1;
//            //此处的 row 是从 1 开始计算的，而 List 下标是从 0 开始算的，还需要再减 1
//            //不建议写成 row - 2
//            List<Integer> prevLine = result.get(row-1-1);
//            List<Integer> currentLine = new ArrayList<>();
//            currentLine.add(1);//第一列
//            //处理中间的这列
//            for (int col = 2; col <= row-1; col++) {
//                //这个循环中需要依赖上一行的数据
//                //获取到上一行的两个对应元素
//                int num1 = prevLine.get(col - 1);//获取到i-1行。j列元素(row-1,col）.只不过需要把 col 转成下标，还需要减 1
//                int num2 = prevLine.get(col - 1 - 1);//获取到 row-1,col-1, 也需要把 col 转成下标，也需要再减 1
//                currentLine.add(num1+num2);
//            }
//            currentLine.add(1);//最后一列
//            //把当前行，放到最终的结果中
//            result.add(currentLine);
//        }
//        return result;
//
//    }
//

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        System.out.println(new Solution().generate(numRows));
    }
}