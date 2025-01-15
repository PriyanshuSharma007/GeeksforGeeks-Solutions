//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver_class {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int grid[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) grid[i][j] = sc.nextInt();
            }

            Solution ob = new Solution();

            if (ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("No solution exists");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static boolean isValid(int grid[][], int row, int col, int value)
    {
        for(int vari=0; vari<9; vari++)
        {
            if ( grid[row][vari] == value)
                return false;
                
            if( grid[vari][col]==value)
                return false;
            //int sub= ((row/3)*3 + vari/3) + ((col/3)*3) + vari/3);
        }
        int subrow= 3*(row/3);
        int subcol= 3*(col/3);
        for(int x=0;x<3;x++)
        {
            for(int y=0; y<3; y++)
            {
                if(grid[subrow+x][subcol+y]==value)
                    return false;
            }
        }
        
        return true;
        
        
    }
    
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        for(int x=0; x<9 ; x++)
        {
            for(int y=0; y<9; y++)
            {
                
                if(grid[x][y]==0)
                {
                    for(int value=1; value<=9 ; value++)
                    {
                        if(isValid(grid, x,y,value))
                        {
                            grid[x][y] = value;
                            if(SolveSudoku(grid))
                                return true;
                            grid[x][y]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int x=0;x<9; x++)
        {
            for(int y=0; y<9 ; y++)
            {
                System.out.print(grid[x][y]+" ");
            }
            //System.out.println();
        }
    }
}