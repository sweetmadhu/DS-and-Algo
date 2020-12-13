import java.util.*;
public class GFG{

private int calSum(int [][] arr,int [][] dp,int i, int j,int row,int col){

    if(dp[i][j]!=-1)
    return dp[i][j];
    
    int right=Integer.MIN_VALUE, left=Integer.MIN_VALUE, top=Integer.MIN_VALUE,bottom=Integer.MIN_VALUE;
    
    if(j+1<col && arr[i][j]+1==arr[i][j+1]){
    right = 1+ calSum(arr,dp,i,j+1,row,col);
    }
    if(j-1>=0 && arr[i][j]+1==arr[i][j-1]){
    left = 1+ calSum(arr,dp,i,j-1,row,col);
    }
    if(i-1>=0 && arr[i][j]+1==arr[i-1][j]){
    top = 1+ calSum(arr,dp,i-1,j,row,col);
    }
    if(i+1<row && arr[i][j]+1==arr[i+1][j]){
    bottom = 1+ calSum(arr,dp,i+1,j,row,col);
    }
    dp[i][j]= ( Math.max(Math.max(Math.max(Math.max(right,left),top),bottom),1));
    
    return dp[i][j];
}

public int getMaxLength(int [][] arr){
    int maxLen =Integer.MIN_VALUE; 
    int row = arr.length;
    int col = arr[0].length;
    int dp[][] = new int[row][col];
    for( int i = 0;i<row;i++){
    Arrays.fill(dp[i],-1);
    }
    for( int i =0;i<row;i++){
      for( int j =0;j<col;j++){
      if(dp[i][j]==-1){
          int len=calSum(arr,dp,i,j,row,col);
        if(len>maxLen) maxLen = len;
      }}}
    return maxLen; 
}

public static void main(String arg[]){
    int[][] arr =
     { { 1,8,7 },
    {2,3,6},
    {9,4,5}
    };
    
    GFG sol = new GFG();
    System.out.println(sol.getMaxLength(arr));

}
}
