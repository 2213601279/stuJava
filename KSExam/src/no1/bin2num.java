package no1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/11/18:14
 * @Description: 三尺秋水尘不染
 */
public class bin2num {
    //模拟十进制转二进制实现:
    public static void main(String[] args) {
        int num = 9;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int temp =num;
        while (num != 0){
            int i = temp % 2;
            num = num /2 ;
            temp = num;
            sb.append(i);
    }
        String s =sb.toString();
        char[] a =s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            if(a[i] == '1'){
                count++;
            }
        }
        System.out.println(count);
}

}
