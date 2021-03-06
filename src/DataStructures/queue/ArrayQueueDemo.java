package DataStructures.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试一下
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据");
            System.out.println("g:从队列取数据");
            System.out.println("h:查看队列头的数据");
            key = scanner.next().charAt(0);
            switch(key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                    int result = arrayQueue.headQueue();
                    System.out.printf("队列的头为：%d\n", result);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序推出。。。");
    }
}


// 使用数组模拟队列 -编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;
    private  int front;
    private  int rear;
    private  int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //获取队列数据（出队列）
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常处理
            throw new RuntimeException("队列空，不能获取数据");
        }
        front++; //front后移
        return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i=0; i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，注意不是取数据
    public int headQueue(){
        if(isEmpty()){
//            System.out.println("队列空的，没有数据");
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front+1];
    }
}