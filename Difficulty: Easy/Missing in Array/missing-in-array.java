class Solution {
    int missingNum(int arr[]) {
        // code here
    //     int sum=0;
        int n=arr.length+1;
    //     int totalsum=0;
    // for(int i=0;i<arr.length;i++){
    //     sum+=arr[i];
    // }
    // totalsum=(n*(n+1))/2;
    // int result=totalsum-sum;
    // return result; 
    int xor1=0, xor2=0;
    
    
        for(int i=0;i<n-1;i++){
            xor2 = xor2 ^ arr[i];
            xor1= xor1 ^ (i+1);
        }
        xor1= xor1 ^ n;
        return xor1 ^ xor2;
    }
}