package linkList;


import include.ListNode;
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                fast = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
public class detectCycle142 {
    public static void main(String[] args){
        ListNode head = ListNode.arrToListNode(new int[]{3,2,0,-4,1,2,3,4,5});
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = head.next.next;
        System.out.println(new Solution().detectCycle(head).val);
    }
}
