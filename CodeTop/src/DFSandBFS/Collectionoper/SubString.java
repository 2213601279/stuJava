package DFSandBFS.Collectionoper;

import com.sun.deploy.cache.BaseLocalApplicationProperties;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/27/18:43
 * @Description: 三尺秋水尘不染
 */
public class SubString {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
//        null->3->2->1
//            1->2->3->null
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reserve(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

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
        reserve(node1).printList();
        ListNode node2 = reverseList(node);
        node2.printList();



    }
}

class ListNode {

    private static int size;

    ListNode head;

    ListNode next;

    int val;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    //select
    public int get(int index) {
        return node(index).val;
    }

    private ListNode node(int index) {
        rangeCheck(index);
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private boolean rangeCheck(int index) {
        if (index > ListNode.size() || index < 0) {
            return false;
        }
        return true;

        }
    private static int size() {
        return size;
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




