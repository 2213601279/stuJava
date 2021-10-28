package ByteDance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/30/9:19
 * @Description: 三尺秋水尘不染
 */

//反转链表的要三次调用
    //使用栈的话就一次就好了

public class subToBIgSum {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.add(1);
        node.add(2);
        node.add(3);
        ListNode node1 = new ListNode();
        node1.add(8);
        node1.add(1);
        node1.add(2);
        node1.add(4);
        node.printList();node1.printList();
        System.out.println();

        ListNode ans = new subToBIgSum().subToBIgSum(node1,node);

        ans.printList();

    }
    public ListNode subToBIgSum(ListNode l1,ListNode l2) {
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        //逆序的将l1,l2放入
        while(l1 != null){
            list1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            list2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 10;
        ListNode ans = new ListNode();
        int cur;
        while (!list1.isEmpty() || !list2.isEmpty() || flag != 0){
        int a = list1.isEmpty()? 0 : list1.pop();
        int b = list2.isEmpty()? 0 : list2.pop();
        //算当前的位相jian的结果
            if(a >= b){
                cur = a-b;
            }else{
                cur = a - b + flag;
                a = list1.isEmpty()? 0 : list1.pop();
                a = a-1;
                if(a != 0){
                    list1.push(a);
                }
            }
            //把答案拼接一下
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;

    }
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null||head.next ==null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode head;
    int size;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    //没有东西
    protected void add() {
        add(val);
    }

    //没有东西
    protected void add(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {//有东西
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }
        size++;
    }

    public void printList(){
        ListNode curNode = head;
        //循环遍历到尾结点
        while (curNode != null){
            System.out.print(curNode.val);
            curNode = curNode.next;
        }

        System.out.println();
    }
}
