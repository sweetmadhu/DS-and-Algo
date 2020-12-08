/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    private double median=0.0;
    
    private double printMedian(int num){
        int sizeMin = minHeap.size();
        int sizeMax = maxHeap.size();
        if(sizeMax<sizeMin){
            if(num>=median){
                int top = minHeap.peek();
                minHeap.poll();
                maxHeap.add(top);
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
            median = (minHeap.peek() + maxHeap.peek())/2;
        }else if (sizeMax>sizeMin){
            
            if(num<=median){
                int top = maxHeap.peek();
                maxHeap.poll();
                minHeap.add(top);
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            median = (minHeap.peek() + maxHeap.peek())/2;
        }else{
            if(num>=median){
               minHeap.add(num);
               median = minHeap.peek();
            }else{
               maxHeap.add(num); 
               median = maxHeap.peek();
            }
            
        }
      return median;  
    }
    
    public void streamProcessing(int arr[]){
        for( int i =0;i<arr.length;i++){
            double median = printMedian(arr[i]);
            System.out.println(median);
        }
    }
	public static void main (String[] args) {
		GFG gfg = new GFG();
		int input[]= {2,4,8,6,10};
		gfg.streamProcessing(input);
	}
}
