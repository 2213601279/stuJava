package DP;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/11/15:54
 * @Description: 三尺秋水尘不染
 */
/*描述
        前几个月放映的头号玩家简直火得不能再火了，作为一个探索终极AI的研究人员，月神自然去看了此神剧。
        由于太过兴奋，晚上月神做了一个奇怪的梦，月神梦见自己掉入了一个被施放了魔法的深渊，月神想要爬上此深渊。

        已知深渊有N层台阶构成（1 <= N <= 1000)，并且每次月神仅可往上爬2的整数次幂个台阶(1、2、4、....)，请你编程告诉月神，月神有多少种方法爬出深渊
        输入描述：
        输入共有M行，(1<=M<=1000)

        第一行输入一个数M表示有多少组测试数据，

        接着有M行，每一行都输入一个N表示深渊的台阶数
        输出描述：
        输出可能的爬出深渊的方式
        示例1
        输入：
        4
        1
        2
        3
        4
        复制
        输出：
        1
        2
        3
        6
*/
public class climbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] num = new int[n];
        BigInteger[] stair = new BigInteger[MAX_VALUE];


    }
}
