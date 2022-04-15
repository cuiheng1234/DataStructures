package DataStructures.sparsearray;

public class SparseArray {
    public static void main(String[] args){
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 原始的二维数组
        for (int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 将二维数组转稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for(int i=0; i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0值存放
        int count = 0;
        for(int i=0; i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[0].length;j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到稀疏数组为：");
        for(int i = 0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        //将稀疏数组转换成二维数组：省略

    }
}
