//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        // code here
        //  int n = A.size(); // size of the array.

        // // Step 1: Find the break point:
        // int ind = -1; // break point
        // for (int i = n - 2; i >= 0; i--) {
        //     if (A.get(i) < A.get(i + 1)) {
        //         // index i is the break point
        //         ind = i;
        //         break;
        //     }
        // }

        // // If break point does not exist:
        // if (ind == -1) {
        //     // reverse the whole array:
        //     Collections.reverse(A);
        //     return A;
        // }

        // // Step 2: Find the next greater element
        // //         and swap it with arr[ind]:

        // for (int i = n - 1; i > ind; i--) {
        //     if (A.get(i) > A.get(ind)) {
        //         int tmp = A.get(i);
        //         A.set(i, A.get(ind));
        //         A.set(ind, tmp);
        //         break;
        //     }
        // }

        // // Step 3: reverse the right half:
        // List<Integer> sublist = A.subList(ind , n);
        // Collections.reverse(sublist);

        // return A;
        
        
        
        
        int minIndex = -1;
        for (int i = arr.length-1; i>0;i--) {
            if (arr[i] > arr[i-1]) {
                minIndex = i-1;
                break;
            }
        }
        if(minIndex == -1) {
            Arrays.sort(arr);
        } else {
        
        int swapIndex = -1;
        int value = Integer.MAX_VALUE;
        for (int i = arr.length-1; i > minIndex;i--) {
            if (arr[i] > arr[minIndex] && arr[i] < value) {
                swapIndex = i;
                value = arr[i];
            }
        }
        int swap = arr[minIndex];
        arr[minIndex] = arr[swapIndex];
        arr[swapIndex] = swap;
        
        Arrays.sort(arr, minIndex + 1, arr.length);
        }
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends