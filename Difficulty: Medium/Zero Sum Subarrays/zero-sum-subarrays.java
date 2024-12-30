//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        int n=arr.length;
//         int  max = 0;
// 	for(int i = 0; i < a.length; ++i){
// 		int sum = 0;
// 		for(int j = i; j < a.length; ++j){
// 			sum += a[j];
// 			if(sum == 0){ 
// 				// max = Math.max(max, j-i+1);
// 				max++;
// 			}
// 		}
// 	}
// 	return max;


        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i =0 ; i < n ; i++){
            sum = sum + arr[i];
            if(!map.keySet().contains(sum)){
                map.put(sum,1);
            }
            else{
                map.put(sum,map.get(sum)+1);
            }
        }
        long ans = 0;
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(entry.getKey() == 0){
                ans = ans + ( ((val)*(val+1)) / 2 );
            }
            else{
                ans = ans + ( ((val-1)*(val)) / 2 );
            }
        }
        return (int)ans;
        
    }
}
