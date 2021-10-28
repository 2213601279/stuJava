package test;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/08/14:19
 * @Description: 三尺秋水尘不染
 */


public class Main {
    static int max ,start,left;
    static HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();

    public static int lengthOfLongestSubstring(String s){
        if (s.length() == 0){
            return 0;
        }
        for (int i = 0;i < s.length(); i++){
            if(hashMap.containsKey(s.charAt(i))){
                left = Math.max(left,hashMap.get(s.charAt(i)));
            }
            hashMap.put(s.charAt(i),i);
            max = Math.max(max,i-left);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder(s);
        String str1 =  sb.substring(1,s.length()-1);

//        String s1 = bufferedReader.readLine();
//        StringBuilder sb1 = new StringBuilder(s);
//        String str2 =  sb.substring(1,s.length()-1);
        System.out.println(str1);
        System.out.println(lengthOfLongestSubstring(str1));





    }


}