//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here 
        
        
        // this is my first approach
        
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]+arr[j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        
        // this is my second appraoch 
        // 1. first sort the array 
        // 2. then apply binary seacrh or do two pointer approach 
        // 3. then if sum== target return true else if < traget the shift left ++
        //   else do right --
        
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int sum=0;
        while(i<j){
            sum=arr[i]+arr[j];
            if(sum==target){
                return true; 
            } else if(sum<target){
                    i++;
                } else {
                    j--;
                }
        }
        return false;
    }
}