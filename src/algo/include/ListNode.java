package include;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }
    public static ListNode arrToListNode(int[] arr){
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
}
