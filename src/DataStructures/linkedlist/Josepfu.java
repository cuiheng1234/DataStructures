package DataStructures.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);  //加入5个节点
        circleSingleLinkedList.showBoy();

        //测试小孩出圈顺序是否正确
        circleSingleLinkedList.countBoy(1,2,25);
    }
}

//创建一个环形单向链表
class CircleSingleLinkedList{
    private Boy firstBoy = null;
    //添加小孩节点，构建一个环形链表
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不能小于1");
            return;
        }
        Boy curBoy = null;
        for(int i=1; i<=nums; i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i == 1){
                firstBoy = boy;
                firstBoy.setNext(firstBoy); //构造环形
                curBoy = firstBoy;
            }else{
                curBoy.setNext(boy);
                boy.setNext(firstBoy);
                curBoy = boy;
            }
        }
    }
    public void showBoy(){
        if(firstBoy == null){
            System.out.println("没有小孩");
        }
        Boy curBoy = firstBoy;
        while (true){
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if(curBoy.getNext() == firstBoy){  //遍历结束
                break;
            }
            curBoy = curBoy.getNext();  //curBoy后移
        }

    }

    //根据用户的输入，计算小孩出圈的顺序

    /**
     *
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表述数几下
     * @param nums  表述最初有多少小孩
     */
    public void countBoy(int startNo, int countNum, int nums){
        if(firstBoy == null || startNo <1 ||startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针
        Boy helper = firstBoy;
        while (true){
            if(helper.getNext() == firstBoy){
                break;
            }
            helper = helper.getNext();
        }
        //报数前，先让first和help移动k-1次
        for(int j = 0; j<startNo-1;j++){
            firstBoy = firstBoy.getNext();
            helper = helper.getNext();
        }

        while(true){
            if(helper == firstBoy){  //说明圈中只有一个节点
                break;
            }
            for(int j = 0; j<countNum-1;j++){
                firstBoy = firstBoy.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", firstBoy.getNo());
            firstBoy = firstBoy.getNext();
            helper.setNext(firstBoy);
        }
        System.out.printf("最后一个小孩%d留着圈中\n", firstBoy.getNo());
    }



}


// 创建一个Boy类，表示一个节点
class Boy{
    private int  no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
