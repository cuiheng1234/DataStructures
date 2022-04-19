package DataStructures.hashtable;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id：");
                    int id = scanner.nextInt();
                    System.out.println("输入名字：");
                    String name = scanner.next();

                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id:");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }


    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


//创建hashtable 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;  //表示有多少条链表

    //构造器

    public HashTab(int size){
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每一条链表
        for(int i=0; i<size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id得到该员工应该加入到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表，遍历hashtable
    public void list(){
        for(int i=0; i<size; i++){
           empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        //使用散列函数确定哪条链表
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null){
            System.out.printf("在第%d条链表中找到雇员:id = %d\n", (empLinkedListNO), id);
        }else{
            System.out.println("在哈希标总没有找到该雇员");
        }
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }
}



//创建一个EmpLinkedList，表示连表
class EmpLinkedList{
    private Emp head;

    //添加雇员到链表
    //假定添加到最后

    public void add(Emp emp){
        //如果是添加第一个雇员
        if(head==null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用各一个辅助的指针，帮助定位到最后。
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }

        //退出时，直接将emp加入链表
        curEmp.next = emp;
    }


    //遍历链表的雇员信息
    public void list(int no){
        if(head == null){
            System.out.printf("第%d链表为空\n", no);
            return;
        }
        System.out.printf("第%d链表的信息为:", no);
        Emp curEmp = head;  //辅助指针
        while (true){
            System.out.printf("=> id = %d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        //根据id查找员工
        //如果找到返回emp，没找到返回null
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}