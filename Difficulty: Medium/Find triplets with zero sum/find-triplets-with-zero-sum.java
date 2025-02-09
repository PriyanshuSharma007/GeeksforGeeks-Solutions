//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]); // Parse the input array
            }

            Solution sol = new Solution();
            if (sol.findTriplets(arr))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find triplets with zero sum.
    public boolean findTriplets(int[] arr) {
        // code here.
         
        int start=0;
        int end=0;
        HashSet <Integer> seen = new HashSet();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int num=-(arr[i]+arr[j]);
                if(seen.contains(num))
                {
                    return true;
                }
                seen.add(arr[j]);
            }
            seen.clear();
        }
        return false;
    }
}