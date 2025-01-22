//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
            out.println("~");
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here 
         int low = 1, high = 1000000; // Range of possible values as per constraints
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(arr, mid);
            
            if (count < k) {
                low = mid + 1; // kth smallest is greater than mid
            } else {
                high = mid; // kth smallest is less than or equal to mid
            }
        }
        return low; // low (or high) will point to the kth smallest element
    }

    // Helper function to count elements less than or equal to a given value
    private static int countLessEqual(int[] arr, int value) {
        int count = 0;
        for (int num : arr) {
            if (num <= value) {
                count++;
            }
        }
        return count;
    }
}
