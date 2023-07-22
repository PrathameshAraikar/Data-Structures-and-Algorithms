package DAA_Assignments;

import java.util.*;

public class NQueens {
    
    static int count = 0;
    static boolean[] col, d1, d2;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        makeGrid(n);
        System.out.println("Solutions: " + count);
        sc.close();
    }
    
    public static void makeGrid(int n) {
        List<List<String>> grid = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                temp.add(".");
            }
            grid.add(temp);
        }
        
        col = new boolean[n + 1];
        d1 = new boolean[2 * n + 1];
        d2 = new boolean[2 * n + 1];
        solveNQueens(n, 0, grid);
    }
    
    public static void solveNQueens(int n, int ind, List<List<String>> grid) {
        if(ind == n) {
            count++;
            printGrid(grid);
            System.out.println();
            System.out.println();
            return;
        }
        
        for(int c = 0; c < n; c++) {
            int d1Val = ind - c + n;
            int d2Val = ind + c;
            if(!d1[d1Val] && !d2[d2Val] && !col[c]) {
                d1[d1Val] = true;
                d2[d2Val] = true;
                col[c] = true;
                grid.get(ind).set(c, "Q");
                
                solveNQueens(n, ind + 1, grid);
                
                grid.get(ind).set(c, ".");
                d1[d1Val] = false;
                d2[d2Val] = false;
                col[c] = false;
            }
        }
    }
    
    public static void printGrid(List<List<String>> grid) {
        for(List<String> li: grid) {
            for(String str: li) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}