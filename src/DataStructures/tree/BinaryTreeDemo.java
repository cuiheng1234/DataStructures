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


        //前序遍历查找
        System.out.println("前序遍历查找   前：");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了，信息为 no=%d  name=%s", resNode.getNo(), resNode.getName());
        }else{
            System.out.printf("没有找到 no = %d的英雄", 5);
        }
        System.out.println();
        System.out.println("***************************");

        //中遍历查找
        System.out.println("中序遍历查找  中：");
        HeroNode resNode1 = binaryTree.infixOrderSearch(5);
        if(resNode1 != null){
            System.out.printf("找到了，信息为 no=%d  name=%s", resNode1.getNo(), resNode1.getName());
        }else{
            System.out.printf("没有找到 no = %d的英雄", 5);
        }

        System.out.println();
        System.out.println("***************************");
        //中遍历查找
        System.out.println("后序遍历查找  中：");
        HeroNode resNode2 = binaryTree.postOrderSearch(5);
        if(resNode2 != null){
            System.out.printf("找到了，信息为 no=%d  name=%s", resNode2.getNo(), resNode2.getName());
        }else{
            System.out.printf("没有找到 no = %d的英雄", 5);
        }
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

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if(root !=null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
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

    //前序遍历查找

    /**
     *
     * @param no 查找的编号
     * @return  如何查到就返回该node，找不到就返回null
     */
    public HeroNode preOrderSearch(int no){
        //先比较当前节点是不是
        System.out.println("进入前序遍历");
        if(this.no == no){
            return this;
        }
        //1.判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){  //说明左子树上我们找到了
            return resNode;
        }
        //1.左递归前序查找，找到节点则返回。否则继续判断，当前节点的右子节点是狗为空，如果不为空，则继续向右递归前序查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){

        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //如果找到，则返回，如果没找到。就和当前节点比较，如果是则返回当前节点
        System.out.println("进入中序查找");
        if(this.no == no){
            return this;
        }
        //否则，则继续进行右递归的中序查找
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后续遍历查找
    public HeroNode postOrderSearch(int no){
        //判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){  //说明在左子树找到了
            return resNode;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        //如果左右子树都没有找到，就比较当前节点是不是
        System.out.println("进入后序查找");
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}
