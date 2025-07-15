class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest=Integer.MIN_VALUE;
        int seclargest=Integer.MIN_VALUE; 
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i]){
                seclargest=largest;
                largest=arr[i];
            }
            else if(seclargest<arr[i] && arr[i]!=largest){
                seclargest=arr[i];
            }
        }
        if(seclargest == Integer.MIN_VALUE){
            return -1;
        }
        else {
            return seclargest;
        }
        
    }
}