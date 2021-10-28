package DiGui;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/26/16:58
 * @Description: 三尺秋水尘不染
 */
public class mergeTwoLists {


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }else if(l2 == null){
                return l1;
            }
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else{
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }

        }

    public static void main(String[] args) {

    }
    }



  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
