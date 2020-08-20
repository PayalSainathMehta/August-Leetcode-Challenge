
//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
public class ReorderList {
   public void reorderList(ListNode head) {
        if(head == null) return;
        // find middle element - reverse it then merge
        
        //finding middle element of 1->2->3->4->5->6
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //now slow = 4
        //reverse from 4 so we have 1->2->3->4 and 6->5->4
        ListNode prev = null, curr = slow, temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        //prev is 6
        //now we merge
        ListNode first = head, second = prev;
        while(second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;
            
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
