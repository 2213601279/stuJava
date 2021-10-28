package List;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/17/11:21
 * @Description: 三尺秋水尘不染
 */
/*给定一个单链表 L 的头节点 head ，单链表 L 表示为：

        L0→ L1→ … → Ln-1→ Ln
        请将其重新排列后变为：

        L0→ Ln→ L1→ Ln-1 →L2→ Ln-2 → …

        不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 */
public class reorderList  {
    public static void main(String[] args) {

        System.out.println(3.0/0);
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
