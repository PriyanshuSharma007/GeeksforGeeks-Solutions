//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans =
                ob.lenOfLongestSubarr(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        // code here
        // int sum=0;
        // int leng=0;
        // for(int i=0;i<arr.length;i++){
        //     sum+=arr[i];
        //     if(sum==k){
        //         leng=Math.max(leng, i+1);
        //     }
        //     if(sum<0){
        //         sum=0;
        //     }
        // }
        // return leng;
        // int maxleng=0;
        // long sum=0;
        // int left=0;
        // int right=0;
        // while(right<arr.length) {
        //     sum+=arr[right];
            
        //     while(sum>k && left<=right  ) {
        //         sum-=arr[left];
        //         left++;
        //     }
        //     if(sum==k){
        //         maxleng=Math.max(maxleng, right-left+1);
        //     }
        //     right++;
        //     // if(right<arr.length){
        //     //     sum+=arr[right];
        //     // }
        // }
        // return maxleng;
        
        
        // after learning hashing i will solve ot again 
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0; i<arr.length;i++){
            sum+=arr[i];
            if(sum == k){
                maxLen = i+1;
            }
            int remSum = sum-k;
            if(preSum.containsKey(remSum)){
                int subLen = i - preSum.get(remSum);
                maxLen = Math.max(maxLen, subLen);
            }
            
            if(!preSum.containsKey(sum)){
                preSum.put(sum, i);
            }
        }
        return maxLen;
    }
}
