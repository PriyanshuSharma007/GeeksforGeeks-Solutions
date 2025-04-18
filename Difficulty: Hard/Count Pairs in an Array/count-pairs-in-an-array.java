//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        
System.out.println("~");
}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution 
{
    static int merging(int arr[], int low, int mid, int high)
    {
        int i = low, j = mid + 1, count = 0, k = 0, n = high - low + 1;
        int temp[] = new int[n];
        
        while(i <= mid && j <= high) 
        {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else 
            {
                count += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid)
            temp[k++] = arr[i++];
            
        while(j <= high)
            temp[k++] = arr[j++];
            
        for(i = 0, j = low; i < n; i++, j++)
            arr[j] = temp[i];
            
        return count;
    }
    static int mergeSort(int arr[], int low, int high) 
    {
        int count = 0;
        
        if(low < high) 
        {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merging(arr, low, mid, high);
        }
        
        return count;
    }
    static int countPairs(int arr[] , int n ) 
    {
        for(int i = 0; i < n; i++)
            arr[i] *= i;
            
        return mergeSort(arr, 0, n - 1);
    }
}