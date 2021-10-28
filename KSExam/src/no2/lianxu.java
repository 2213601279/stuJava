package no2;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/11/18:51
 * @Description: 三尺秋水尘不染
 */
public class lianxu {
    

    public static void main(String[] args) {
        
        int[] data = {6,8,9,5,3,2};
        sort(data);
        int count0 = 0;
        for(int i = 0;i<data.length;i++){
            if(data[i] == 0){
                i++;
                count0++;
            }else if((data[i+1]-data[i] != 1)&& (data[i+1]-data[i] != count0)){
                System.out.println(0);;
            }else{
                System.out.println(1);;
            }
            System.out.println(data[i]);
        }



    }

}
