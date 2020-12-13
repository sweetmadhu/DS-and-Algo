/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class GFG{

private int getMax(int arr[], int dp[][], int s, int e, int sum){
    if(s+1==e){
    return Math.max(arr[s],arr[e]);
    }
    
    if(dp[s][e]!=-1) return dp[s][e];
    
    dp[s][e] = Math.max( (sum - getMax(arr, dp, s+1,e,sum-arr[s])),
    (sum - getMax(arr, dp, s,e-1,sum-arr[e])));
    return dp[s][e];

}

public void findMax(int arr[]){
    int n = arr.length;
    int sum =0;
    int dp[][] = new int[n][n];
    for( int i =0;i<n;i++){
    sum +=arr[i];
    }
    
    for( int i =0;i<n;i++){
    Arrays.fill(dp[i],-1);
    }
    
     System.out.println(getMax(arr,dp,0,n-1,sum)); 


}

public static void main(String arg[]){
    GFG gfg = new GFG();
    int arr[] = {5,4,8,6 }; 
    gfg.findMax(arr);

}

}
