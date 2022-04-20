package DataStructures.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode node1 = new HeroNode(1, "曹操");
        HeroNode node2 = new HeroNode(2, "孙尚香");
        HeroNode node3 = new HeroNode(3, "大乔");
        HeroNode node4 = new HeroNode(4, "诸葛亮");
        HeroNode node5 = new HeroNode(5, "赵云");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(node1);

        //测试
        System.out.println("***************************");
        System.out.println("前序遍历:");
        binaryTree.preOrder();

        System.out.println("***************************");
        System.out.println("中序遍历：");
        binaryTree.infixOrder();

        System.out.println("***************************");
        System.out.println("后序遍历：");
        binaryTree.postOrder();

        System.out.println("***************************");
    }
}

//定义BinaryTree 二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
}


//先创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);   //先输出父节点
        //递归左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //编写中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
