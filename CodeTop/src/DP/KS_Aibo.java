package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/11/16:19
 * @Description: 三尺秋水尘不染
 */
/*又到了吃午饭的时间，你和你的同伴刚刚研发出了最新的GSS-483型自动打饭机器人，现在你们正在对机器人进行功能测试。
        为了简化问题，我们假设午饭一共有N个菜，对于第i个菜，你和你的同伴对其定义了一个好吃程度（或难吃程度，如果是负数的话……）A[i]，
        由于一些技（经）术（费）限制，机器人一次只能接受一个指令：两个数L, R——表示机器人将会去打第L~R一共R-L+1个菜。
        本着不浪费的原则，你们决定机器人打上来的菜，含着泪也要都吃完，于是你们希望机器人打的菜的好吃程度之和最大
        然而，你善变的同伴希望对机器人进行多次测试（实际上可能是为了多吃到好吃的菜），他想知道机器人打M次菜能达到的最大的好吃程度之和
        当然，打过一次的菜是不能再打的，而且你也可以对机器人输入-1, -1，表示一个菜也不打
        输入描述：
        第一行：N, M

        第二行：A[1], A[2], ..., A[N]
        输出描述：
        一个数字S，表示M次打菜的最大好吃程度之和
        示例1
        输入：
        7 2
        1 2 3 -2 3 -10 3
        复制
        输出：
        10
        复制
        说明：
        [1 2 3 -2 3] -10 [3]
        示例2
        输入：
        7 4
        1 2 3 -2 3 -10 3
        复制
        输出：
        12
        复制
        说明：
        [1 2 3] -2 [3] -10 [3]

        第四次给机器人-1, -1的指令
        备注：
        N <= 10^5 = 100000

        |A[i]| <= 10^4 = 10000

        10%数据M = 1

        50%数据M <= 2

        80%数据M <= 100

        100%数据M <= 10^4 = 10000
        */
public class KS_Aibo {
    /*
    和leetcode188，买卖股票的最佳时机Ⅳ类似
    将菜价数组改为每一个位置都是前面所有数字的和就和股价一样
    一共能进行M次买卖

    1. 使用动态规划
    状态量有三种，菜的位置i，能打多少次菜M，是否打这个菜s（0或1）
    2. 状态转移方程：
    dp[i][M][0]=max(dp[i-1][M][0], dp[i-1][M][1])
    解释：
        第i个菜不打能获得的最大值为
        上一个菜不打能获得的最大值
        上一个菜打能获得的最大值
        其中较大的一个
    dp[i][M][1]=max(dp[i][M][1]+A[i], dp[i][M-1][0]+A[i])
    解释：
        第i个菜打能获得的最大值为
        上一个菜也打获得的最大值加上这个菜的值
        上一个菜不打获得的最大值加上这个菜的值，但是上一个菜的M值要-1，因为这个菜要消耗一次打饭机会

    3. 初始值
    dp[0][M][0]=0
    dp[0][M][1]={    0    ,    M=0
                     A[0] ,    M>0}
    4. 简化
    简化状态转移方程：
    dp_i_0[M]=max(dp_i_0[M], dp_i_1[M])
    dp_i_1[M]=max(dp_i_1[M]+A[i], dp_i_0[M-1]+A[i])

    简化M的值：
    对于任意N个菜，只要M > N/2，就能确保打到所有正数的菜
    比如N=2,M只要1
    N=3，M只要2
    N=4，M只要2

    简化A数组
    连续的几个正值或者负值可以将其合并为1个值，
    比如1，1，-1，-1，2，3
    可以简化为2，-2，5
    */
            public static void main(String[] args){
                //        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
                //        int[] mn = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                //        int N = mn[0];
                //        int M = mn[1];
                //        long[] ints = Arrays.stream(sc.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int M = sc.nextInt();
                int[] ints = new int[N];
                int len = 0;
                ints[0] = sc.nextInt();
                for(int i = 1; i < N; i++){
                    ints[i] = sc.nextInt();
                    if(ints[i] * ints[len] >= 0){
                        ints[len] += ints[i];
                    }else{
                        len++;
                        ints[len] = ints[i];
                    }
                }
                ints = Arrays.copyOfRange(ints, 0, len + 1);
                int m = 0;
                int sum = 0;
                for(int i = 0; i < ints.length; i++){
                    if(ints[i] > 0){
                        m++;
                        sum += ints[i];
                    }
                }
                if(m <= M){
                    System.out.println(sum);
                }else{
                    //            long[][] dp = new long[M + 1][ints.length + 1];
                    ////            System.out.println(dp.length + " " + dp[0].length);
                    //            for(int i = 1; i < dp.length; i++){
                    //                long max = 0;
                    //                for(int j = i; j < dp[0].length; j++){
                    //                    //这里用max来表示dp[i-1][t]的最大值
                    //                    max = Math.max(max, dp[i - 1][j - 1]);
                    //                    dp[i][j] = Math.max(dp[i][j - 1], max) + ints[j - 1];
                    //                }
                    //            }
                    //            long ans = 0;
                    //            for(int i = 1; i < dp[0].length; i++){
                    //                ans = Math.max(ans, dp[M][i]);
                    //            }
                    //            System.out.println(ans);
                    //System.out.println(Arrays.toString(ints));
                    long res = 0;
                    int n = ints.length;
                    long[] dp = new long[n + 1];
                    long[] maxArray = new long[n + 1];
                    for(int i = 1; i <= M; i++){
                        res = Long.MIN_VALUE;
                        for(int j = i; j < dp.length; j++){
                            dp[j] = Math.max(dp[j - 1], maxArray[j - 1]) + ints[j - 1];
                            if(res < dp[j]) res = dp[j];
                            maxArray[j - 1] = res;
                        }
                        //System.out.println("  " + Arrays.toString(dp));
                    }

                    System.out.println(res);
                }
            }
        }


/*改写成cpp就能过
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    int N, M;
    cin>>N;
    cin>>M;
    vector<int> A;
    int sum = 0;
    while (N) {
        --N;
        int temp;
        cin >> temp;
        if ((sum >= 0 && temp >= 0) || (sum <= 0 && temp <= 0)) {
            sum += temp;
        } else {
        // 否则，加入A，重新累计
            A.push_back(sum);// 直接在A数组修改就可以
            sum = temp;
        }
    }
    N = A.size();

    // 若M > (N + 1) / 2，直接将所有正数累加输出
    if (M > (N + 1) / 2) {
        int result = 0;
        for (int a : A) {
            result += (a > 0 ? a : 0);
        }
        cout << result;
        return 0;
    }

        vector<int> dp_i_0(M + 1, 0);
        vector<int> dp_i_1(M + 1, 0);
        for (int m = 1; m <= M; ++m) {
            dp_i_1[m] = A[0];
        }

        for (int i = 1; i < N; ++i) {
            for (int m = 1; m <= M; ++m) {
                dp_i_0[m] = max(dp_i_0[m], dp_i_1[m]);
                dp_i_1[m] = max(dp_i_1[m] + A[i], dp_i_0[m - 1] + A[i]);
            }
        }

        cout << max(dp_i_0[M], dp_i_1[M]);

    return 0;
}
*/

