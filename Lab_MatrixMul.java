import java.util.Arrays;

public class Lab_MatrixMul {
    public static void main(String[] args) {
        int[][] inputA = {{5, 6, 7}, {4, 8, 9}};
        int[][] inputB = {{6, 4}, {5, 7}, {1, 1}};
        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);
        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;
        MyData matC = new MyData(matC_r, matC_c);
        
        //Q4
        Thread[] t = new Thread[matC_r*matC_c];
        int tIdx = 0;
        for (int r = 0; r < matC.data.length; r++) {
            for (int c = 0; c < matC.data[0].length; c++) {
                t[tIdx] = new Thread(new MatrixMulThread(r, c, matA, matB, matC));
                t[tIdx].start();
                tIdx++;
            }
        }
        
        //Q5
        try{
            for(Thread thread : t){
                thread.join();
            }
        }catch(Exception e){
            System.out.println(e);
        }        
        
        matC.show();
    }
}

class MatrixMulThread implements Runnable{
    int processing_row;
    int processing_col;
    MyData datA;
    MyData datB;
    MyData datC;

    MatrixMulThread(int tRow, int tCol, 
                    MyData a, MyData b, MyData c){
        //Q1
        processing_row = tRow;
        processing_col = tCol;
        datA = a;
        datB = b;
        datC = c;
                        
    }
    //Q2
    public void run() {
        // Q3
        int total = 0;
        for(int i = 0; i < datA.data[0].length; i++){
            total += (datA.data[processing_row][i]*datB.data[i][processing_col]);
        }    
        datC.data[processing_row][processing_col] = total;    
        
        // System.out.println("perform sum of
        // multipication of assigned row and col");
    }
}

class MyData{
    int[][] data;
    MyData(int[][] m){
        data = m;
    }
    MyData(int r, int c){
        data = new int[r][c];
        for(int[] aRow : data){
            Arrays.fill(aRow, 9);
        }
    }
    void show(){
        System.out.println(Arrays.deepToString(data));
    }
}