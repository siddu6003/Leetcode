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

// 48 . Rotate image

public void rotate(int[][] matrix) {
    int n=matrix.length;
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n/2;j++){
            int temp=matrix[i][n-j-1];
            matrix[i][n-j-1]=matrix[i][j];
            matrix[i][j]=temp;
        }
    }
}

// 56 . Merge Intervals - pending

// 88 . Merge Sorted Array

public void merge(int[] nums1, int m, int[] nums2, int n) {
    int a[]=new int[m+n];
    int i=0;
    int j=0;
    int k=0;
    while(i!=m && j!=n){
        if(nums1[i]>nums2[j]){
            a[k++]=nums2[j++];
        }else{
            a[k++]=nums1[i++];
        }
    }
    while(i<m){
        a[k++]=nums1[i++];
    }
    while(j<n){
        a[k++]=nums2[j++];
    }
    int p=0;
    for(int z : a){
        nums1[p++]=z;
    }
}

// 287. Find the Duplicate Number 

public int findDuplicate(int[] nums) {
    int x=0;
    Set<Integer> s=new HashSet<>();
    for(int i=0;i<nums.length;i++){
        if(!s.contains(nums[i])){
            s.add(nums[i]);
        }else{
            x=nums[i];
            break;
        }
    }
    return x;
}

// 74 . Search a 2d matrix

// binary search
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = m*n - 1;
    
    while(low <= high) {
        int mid = low + (high - low) / 2; 
        int row = mid / n;
        int col = mid % n;       
        if(matrix[row][col] == target) {
            return true;
        } else if(matrix[row][col]  > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
         
    }
    return false;
}

// 50 . Pow(x, n)

public double myPow(double x, int n) {
    double ans=1;
    while(n-->0){
        ans=ans*x;
    }
    return ans;
}

// 169 . Majority Element

public int majorityElement(int[] nums) {
    Map<Integer,Integer> m=new HashMap<>();
    for(int i : nums){
        if(!m.containsKey(i)){
            m.put(i,1);
        }else{
            m.put(i,m.get(i)+1);
        }
    }
    int p=0;
    for(Map.Entry k : m.entrySet()){
        int x=(int) k.getValue();
        if(x>nums.length/2){
            p=(int) k.getKey();
        }
    }
    return p;
}

// 229 . Majority Element II

public List<Integer> majorityElement2(int[] nums) {
    List<Integer> l=new ArrayList<>();
    Map<Integer,Integer> m=new HashMap<>();
    for(int i : nums){
        if(!m.containsKey(i)){
            m.put(i,1);
        }else{
            m.put(i,m.get(i)+1);
        }
    }
    int p=0;
    for(Map.Entry k : m.entrySet()){
        int x=(int) k.getValue();
        if(x>nums.length/3){
            p=(int) k.getKey();
            l.add(p);
        }
    }
    return l;
}


// 62 . Unique Paths - pending

// 493 . Reverse Pairs - pending




public static void main(String args[]){
        
    }
}