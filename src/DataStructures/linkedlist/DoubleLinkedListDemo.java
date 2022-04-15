package DataStructures.linkedlist;

public class DoubleLinkedListDemo  {
    public static void main(String[] args) {
        System.out.println("*******双向链表的测试********");
        HeroNode2 hero1 = new HeroNode2(1, "曹操", "魏王");
        HeroNode2 hero2 = new HeroNode2(2, "诸葛亮", "卧龙");
        HeroNode2 hero3 = new HeroNode2 (3, "孙尚香", "大美女");
        HeroNode2 hero4 = new HeroNode2 (4, "关羽", "青龙偃月刀");

        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        System.out.println("***********add************");
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();


        System.out.println("***********update************");
        //修改update
        HeroNode2 newHeroNode = new HeroNode2 (4, "杨幂", "大米米");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();

        System.out.println("***********delete************");
        doubleLinkedList.del(2);
        doubleLinkedList.list();

        System.out.println("***********insert************");
        HeroNode2 newHeroNodeInsert1 = new HeroNode2 (1, "迪丽热巴", "老婆");
        HeroNode2 newHeroNodeInsert2 = new HeroNode2 (5, "张天爱", "性感女神");
        HeroNode2 newHeroNodeInsert3 = new HeroNode2 (6, "刘岩", "大波波");
        doubleLinkedList.insert(newHeroNodeInsert1);
        doubleLinkedList.insert(newHeroNodeInsert2);
        doubleLinkedList.insert(newHeroNodeInsert3);
        doubleLinkedList.list();

    }
}

//创建一个双向链表的类
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //insert
    public void insert(HeroNode2 heroNode){
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.no>heroNode.no){
                break;
            }else if(temp.no == heroNode.no){
                flag = true;  //编号存在
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入！\n", heroNode.no);
        }else{
            if(temp.next==null){
                temp.next = heroNode;
                heroNode.pre = temp;
            }else{
                temp.pre.next = heroNode;
                heroNode.pre = temp.pre;
                heroNode.next = temp;
                temp.pre = heroNode;
            }

        }
    }


    public void del(int no){

        if(head.next == null){
            System.out.println("链表为空，无法删除" );
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
//            temp.next = temp.next.next;  //单链表删除
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
            temp.pre.next = temp.next;
        }else{
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }


    //修改节点信息
    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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


    //添加节点到双向链表的最后
    public void add(HeroNode2 heroNode){
        //因为head 节点不能动，因此需要一个辅助变量
        HeroNode2 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    //遍历双向链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;  //指向下一个节点
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
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
