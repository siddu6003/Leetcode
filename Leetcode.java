import java.util.*;


public class Leetcode{


    // Arrays 

//  73 . set matrix zeroes

public static void setZeroes(int[][] matrix) {
    List<List<Integer>> l=new ArrayList<>();
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                List<Integer> l2=new ArrayList<>();
                l2.add(i);
                l2.add(j);
                l.add(l2);
            }
        }
    }
    
    for(int i=0;i<l.size();i++){
       int x=l.get(i).get(0);
       int y=l.get(i).get(1);
       for(int k=0;k<matrix.length;k++){
           matrix[k][y]=0;
       }
        for(int k=0;k<matrix[0].length;k++){
            matrix[x][k]=0;
        }
    }
}

// 118 . pascal's triangle

public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> l=new ArrayList<>();
    List<Integer> x=new ArrayList<>();
    x.add(1);
    l.add(x);
    for(int i=1;i<numRows;i++){
        List<Integer> l2=new ArrayList<>();
        for(int j=0;j<=i;j++){
            if(j==0 || j==i){
                l2.add(1);
            }else{
              l2.add(l.get(i-1).get(j-1)+l.get(i-1).get(j));   
            }
        }
        l.add(l2);
    }
    return l;
}

// 31 . Next Permutation - pending 

// 53 . Maximum Subarray 

public int maxSubArray(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE, sum = 0;
    
    for(int i=0;i<n;i++){
        sum += nums[i];
        max = Math.max(sum,max);
        
        if(sum<0) sum = 0;
    }
    
    return max;
}

// 75 . sort arrays of 0,1,2

public void sortColors(int[] nums) {
    int a=0;
     int b=0;
     int c=0;
     for(int i : nums){
         if(i==0) a++;
         else if(i==1) b++;
         else c++;
     }
     
     for(int i=0;i<nums.length;i++){
         if(a>0){
             nums[i]=0;
             a--;
         }else if(b>0){
             nums[i]=1;
             b--;
         }else if(c>0){
             nums[i]=2;
             c--;
         }
     }
 }

 // 121 . Best time to buy and sell a stock 

 public int maxProfit(int[] prices) {
    int profit=0;
    int min=Integer.MAX_VALUE;
    for(int i=0;i<prices.length;i++){
        if(prices[i]<min){
            min=prices[i];
        }else if(prices[i]-min>profit){
            profit=prices[i]-min;
        }
    }
    
    return profit;
}

    public static void main(String args[]){
        
    }
}