package no2;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/12/20:53
 * @Description: 三尺秋水尘不染
 */
//用例:
//我ABC汉DEF,6
//我abc爱def于晨静hij,15

public class cutString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String original = "我ABC汉DEF";
        String original = new String();
        int count = 0;
            System.out.println("字符串");
            original = sc.nextLine();
            System.out.println("数字");
            count = sc.nextInt();
        int temp = count;
        String o = original.replaceAll("[^\\x00-\\xff]", "*+");
        int length = o.length();
        StringBuilder sb = new StringBuilder(original);
        if(count > length){
            return;
        }
        for (int i = 0; i < count; i++) {
            if(o.charAt(i)=='*'){
                temp -=1;
            }
        }

        System.out.println(sb.substring(0,temp));


    }
}

