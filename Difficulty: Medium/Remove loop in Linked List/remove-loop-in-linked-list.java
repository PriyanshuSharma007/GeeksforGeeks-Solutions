//{ Driver Code Starts
// driver code

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
}

class GFG {
    public static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x) {
        if (x == 0) return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x) {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null) last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head) {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise) {
            if (hare == null || hare.next == null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head) {
        int ret = 0;
        while (head != null) {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            int num = Integer.parseInt(str[0]);
            Node head = newNode(num);
            Node tail = head;

            for (int i = 1; i < n; i++) {
                num = Integer.parseInt(str[i]);
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = Integer.parseInt(read.readLine());
            makeLoop(head, pos);

            Solution x = new Solution();
            x.removeLoop(head);

            if (detectLoop(head) || length(head) != n)
                System.out.println("false");
            else
                System.out.println("true");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

// Remove loop without using hash map :)
class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        
        // Same problem like : find the entry point in the loop in given linked list.
        // Optimised Approach : 2 steps
        /* 1. Find the entry point of the loop in the list
           2. now just update the prev node of entry point*/
        
        // taking three pointers to traverse on the list
        Node fast = head;
        Node slow = head;
        
        // this node would point to the previous node of the slow.
        Node prev = null;
        
        
        // keep updating until you get the loop or the list finishes
        while(fast != null && fast.next != null){
            // updating the fast by two places
            fast = fast.next.next;
            
            // updating the prev pointer as the prev node of slow pointer
            
            prev = slow;
            
            // updating the slow pointer by one move.
            slow = slow.next;
            
            
            // if fast and slow becomes equal, that means, you got the loop
            if(fast == slow){ 
                Node start = head;
                
                // keep moving by one place until start and slow does not become equal
                while(start != slow){
                    prev = slow;
                    slow = slow.next;
                    start = start.next;
                }
                
                // at the moment they become equal, then make the next pointer of prev of slow as null.
                prev.next = null;
            }
        }
        
        
        
    }
}