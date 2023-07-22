package DAA_Assignments;

import java.util.*;
public class MatrixMultiplication {
    
    static int MAX = 3, MAX_THREADS = 3, step = 0;
    static int[][] matA = new int[MAX][MAX];
    static int[][] matB = new int[MAX][MAX];
    static int[][] matC = new int[MAX][MAX];
    
    static class Worker implements Runnable {
        int i;
        
        Worker(int i) {
            this.i = i;
        }
    
        @Override
        public void run() {
            for(int j = 0; j < MAX; j++) {
                for(int k = 0; k < MAX; k++) {
                    matC[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }
    }
    
    public static void main(String[] args){
        Random rand = new Random();
        
        // Adding elements in matA and matB
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                matA[i][j] = rand.nextInt(10);
                matB[i][j] = rand.nextInt(10);
            }
        }
        
        System.out.println("Matrix A");
        // Displaying matA
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                System.out.print(matA[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Matrix B");
        // Displaying matB
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                System.out.print(matB[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        // Creating Threads
        Thread[] threads = new Thread[MAX_THREADS];
        
        for(int i = 0; i < MAX_THREADS; i++) {
            threads[i] = new Thread(new Worker(step++));
            threads[i].start();
        }
        
        // Joining Threads
        for(int i = 0; i < MAX_THREADS; i++) {
            try {
                threads[i].join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Displaying matC
        System.out.println("Matrix C");
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                System.out.print(matC[i][j] + " ");
            }
            System.out.println();
        }
    }
}