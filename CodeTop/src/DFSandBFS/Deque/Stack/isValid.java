package DFSandBFS.Deque.Stack;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/27/15:55
 * @Description: 三尺秋水尘不染
 */
/*
20. 有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。


        示例 1：

        输入：s = "()"
        输出：true
        示例 2：

        输入：s = "()[]{}"
        输出：true
        示例 3：

        输入：s = "(]"
        输出：false
        示例 4：

        输入：s = "([)]"
        输出：false
        示例 5：

        输入：s = "{[]}"
        输出：true

 */
public class isValid {
//    public static boolean isValid(String s){
//        HashMap<Character, Character> map = new HashMap<Character, Character>();
//        map.put(')','(');
//        map.put(']','[');
//        map.put('}','{');
//
//        int length = s.length();
//
//        if(length%2 == 1){
//            return false;
//        }
//
//        ArrayDeque<Character> deque = new ArrayDeque<>();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            if(map.containsKey(c)){
//                if(deque.isEmpty() || deque.peek() != map.get(i)){
//                    return false;
//                }
//                deque.pop();
//            }else{
//                deque.push(c);
//            }
//        }
//        return deque.isEmpty();
//    }
public static boolean isValid(String s) {
    int n = s.length();
    if (n % 2 == 1) {
        return false;
    }

    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    Deque<Character> stack = new LinkedList<Character>();

    for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        if (pairs.containsKey(ch)) {
            if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                return false;
            }
            stack.pop();
        } else {
            stack.push(ch);
        }
    }
    return stack.isEmpty();
}


    public static void main(String[] args) {
//            String s =  "()[]{}";
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
