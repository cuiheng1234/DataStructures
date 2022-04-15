package DataStructures.leetcode;

import com.sun.scenario.effect.impl.state.AccessHelper;
import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class Queen8 {
    // 定义一个max表示共有的多少个皇后
    int max = 8;
    static int count = 0;
    //定义一个数组array，保存皇后放置位置的结果，比如arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);

    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if(n == max){  //n = 8,其实8个皇后已经放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for(int i=0; i<max; i++){
            //先把当前这个皇后n,放到该行的第i列
            array[n] = i;
            //判断当放置第n个皇后到i列时是否冲突
            if(judge(n)){
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i
        }
    }
    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for(int i = 0; i<n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置打印出来
    private void print(){
        count++;
        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
