//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to calculate the number of subsets with a given sum
    public int dp[][];
    public  int  printSub(int idx , int arr[], int s, int sum ){
        int n= arr.length ;
        if(s > sum) return 0;
        if(idx == n) {
            if(s == sum){
               return 1;
                
            }
            return 0 ;
        }
        if(dp[idx][s] != -1) return dp[idx][s];
        s += arr[idx];
        int l = printSub(idx+1  ,arr ,s , sum );
        
        s -= arr[idx];
        
        //not take
        int r = printSub(idx+1, arr , s , sum );
        return dp[idx][s] = l +r;
    }
    public int perfectSum(int[] nums, int sum) {
        // code here
       
        int n = nums.length;
        dp = new int [n][sum+1];
        for(int row [] : dp){
            Arrays.fill(row , -1);
        }
        return printSub(0 ,nums ,0, sum ); 
        
    }
}