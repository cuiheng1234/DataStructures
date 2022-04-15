package DataStructures.leetcode;



public class Delete {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5= new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(listNode1);
        singleLinkedList.add(listNode2);
        singleLinkedList.add(listNode3);
        singleLinkedList.add(listNode4);
        singleLinkedList.add(listNode5);
        singleLinkedList.add(listNode6);
        singleLinkedList.add(listNode7);

        singleLinkedList.list();
        System.out.println("**********************************");


        ListNode rehead = singleLinkedList.removeElements(singleLinkedList.getHead(), 6);
        System.out.println(rehead);
        System.out.println("**********************************");
        singleLinkedList.list();


    }
}



class SingleLinkedList{
    ListNode head = new ListNode(0);

    public ListNode getHead() {
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
         if(head == null){
             return head.next;
         }
        ListNode cur = head.next;
        ListNode pre = head;

        while(true){
            if((cur.next == null) && (cur.val == val)){
                pre.next =null;
                break;
            }else if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;

            }
            pre = pre.next;
            cur = cur.next;



        }
        return head.next;

    }



    public void add(ListNode heroNode){
    //因为head 节点不能动，因此需要一个辅助变量
    ListNode temp = head;
    while(true){
        if(temp.next == null){
            break;
        }
        temp = temp.next;
    }
    temp.next = heroNode;
    }


    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        ListNode temp = head;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

}
class ListNode{
    int val;ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}