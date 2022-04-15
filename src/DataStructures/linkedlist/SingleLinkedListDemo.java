package DataStructures.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "曹操", "魏王");
        HeroNode hero2 = new HeroNode(2, "诸葛亮", "卧龙");
        HeroNode hero3 = new HeroNode(3, "孙尚香", "大美女");
        HeroNode hero4 = new HeroNode(4, "关羽", "青龙偃月刀");

        //创建一个链表
//        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        singleLinkedList1.add(hero1);
//        singleLinkedList1.add(hero2);
//        singleLinkedList1.add(hero3);
//        singleLinkedList1.add(hero4);

        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        //加入按照编号
        singleLinkedList2.insert(hero1);
        singleLinkedList2.insert(hero4);
        singleLinkedList2.insert(hero2);
        singleLinkedList2.insert(hero3);
//        singleLinkedList2.insert(hero3);
        //显示链表
        System.out.println("*****************************");
        singleLinkedList2.list();

        System.out.println("*****************************");

        // update
//        HeroNode newHeroNode = new HeroNode(3,"大乔","真美啊");
//
//        singleLinkedList2.list();
//        System.out.println("*****************************");
//        singleLinkedList2.update(newHeroNode);
//        singleLinkedList2.list();
//        System.out.println("*****************************");
        //删除一个节点
//        singleLinkedList2.del(2);
//        singleLinkedList2.list();

        //length
        System.out.print("链表的长度为：");
        System.out.println(getLength(singleLinkedList2.getHead()));

        System.out.println("*****************************");
        //倒数第K个节点
        HeroNode res = findLastIndexNode(singleLinkedList2.getHead(), 2);
        System.out.println("res=" + res);

        System.out.println("*****************************");
        reverseList(singleLinkedList2.getHead());
        singleLinkedList2.list();

//        System.out.println("*****************************");
//        reversePrint(singleLinkedList2.getHead());

        System.out.println("*****************************");
        HeroNode head = removeElements(singleLinkedList2.getHead(), 1);
//        System.out.println(singleLinkedList2.getHead());
        System.out.println(head);

    }
    public static HeroNode removeElements(HeroNode head, int no) {
        if(head.next == null){
            return head;
        }
        HeroNode cur = head.next;
        HeroNode pre = head;
        if(cur.no == no){
            pre.next = null;
            return head;
        }
        while(true){
            if((cur.next == null) && (cur.no == no)){
                pre.next =null;
                break;
            }else if(cur.no == no){
                pre.next = cur.next;
                break;

            }
            pre = pre.next;
            cur = cur.next;



        }
        return head;

    }


    //倒序打印单链表
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //打印栈中节点
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    //单链表反转
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next ==null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0,"", "");

        //遍历
        while(cur != null){
            next = cur.next; //暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }


    // 查找单链表的倒数第K个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if(head.next == null){
            return null;
        }
        //得到链表的长度
        int size = getLength(head);

        if(index <= 0 || index >size){
            return null;
        }

        HeroNode cur = head.next;
        for(int i=0; i<size-index; i++){
            cur = cur.next;
        }
        return cur;
    }
    /**
     *
     * @param head 链表的头节点
     */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}


//定义SingleLinkedList 管理英雄
class SingleLinkedList{
    //初始化一个头节点
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向列表
    public void add(HeroNode heroNode){
        //因为head 节点不能动，因此需要一个辅助变量
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //insert
    public void insert(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;  //编号存在
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入！\n", heroNode.no);
        }else{
            //插入到链表中，temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{//没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }

    }

    //delete
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    //显示列表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
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
//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //指向下一个节点

    //构造方法
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
//        this.next = next;
    }
    //为了显示方便，重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}