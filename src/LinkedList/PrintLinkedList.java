package LinkedList;

public class PrintLinkedList {
    ListNode getNew(int val){
        ListNode newnode = new ListNode(val);
        return newnode;
    }

    ListNode insert(ListNode head, int val){
        if(head==null)
        {
            head= getNew(val);
            return head;
        }

        ListNode newnode = getNew(val);
        newnode.next = head;
        head = newnode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;

        PrintLinkedList obj = new PrintLinkedList();
        for(int i=1;i<=5;i++){
            head = obj.insert(head, i);
        }

        obj.printList(head);

    }

    private void printList(ListNode head) {
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
