package DataStructures.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        //测试中序线索二叉树的功能
        HeroNode node1 = new HeroNode(1, "迪丽热巴");
        HeroNode node2 = new HeroNode(3, "杨幂");
        HeroNode node3 = new HeroNode(6, "景甜");
        HeroNode node4 = new HeroNode(8, "Rita");
        HeroNode node5 = new HeroNode(10, "陈乔恩");
        HeroNode node6 = new HeroNode(14, "海瑟薇");

        //二叉树，后面我们要递归创建，现在简单手动处理
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(node1);
        threadedBinaryTree.threadedNodes();

        //测试：以10号节点测试
        HeroNode leftNode = node5.getLeft();
        System.out.println("10号节点的前驱节点是："+ leftNode);

        HeroNode rightNode = node4.getRight();
        System.out.println("8号节点的后继节点是："+ rightNode);

        System.out.println("使用线索化的方式遍历线索化二叉树");
        threadedBinaryTree.threadedList();


    }
}
//定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadedBinaryTree{
    private HeroNode root;

    //为了实现线索化，需要创建一个指向当前节点的前驱节点的引用
    private HeroNode pre = null;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    //重载
    public void threadedNodes(){
        this.threadedNodes(root);
    }


    //遍历线索化二叉树的方法
    public void threadedList(){
        //定义一个变量，存储当前便利的节点，从root开始
        HeroNode node = root;
        while(node != null){
            //循环的找到leftType == 1 的节点，第一个找到的就是8节点
            //后面随着遍历而变化，因为当leftType == 1 时，说明该节点是按照线索化处理后的有效节点
            while(node .getLeftType() == 0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);

            //如果当前节点的右指针指向的是后继节点，就一直输出
            while(node.getRightType() == 1){
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的节点
            node = node.getRight();
        }
    }

    //编写对二叉树进行中序线索化的方法
    /**
     *
     * @param node  就是当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node){
        //如果node==null,不能线索化
        if(node == null){
            return;
        }

        //1)先线索化左子树
        threadedNodes(node.getLeft());
        //2）线索化当前节点
        //处理当前节点的前驱节点
        if(node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点左指针的类型,指向前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre != null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!! 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //3）线索化右子树
        threadedNodes(node.getRight());

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

    //删除节点
    public void delNode(int no){
        if(root != null){
            //如果只有一个root节点
            if(root.getNo() == no){
                root = null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }
}

//先创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //1.如果leftType == 0表示左子树，如果1 表示指向前驱节点
    //2.如果rightType == 0表示指向右子树，如果1表示指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
        //1.左递归前序查找，找到节点则返回。否则继续判断，当前节点的右子节点是否为空，如果不为空，则继续向右递归前序查找
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

    //递归删除节点
    //如果删除的节点是叶子节点，则删除该节点；如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no ==no){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }
}