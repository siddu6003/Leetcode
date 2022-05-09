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

// 1. Two Sum

public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
   Map<Integer, Integer> map = new HashMap<Integer, Integer>();
   for (int i = 0; i < nums.length; i++) {
       if (map.containsKey(target - nums[i])) {
           result[1] = i;
           result[0] = map.get(target - nums[i]);
           return result;
       }
       map.put(nums[i], i);
   }
   return result;
}

// 18 . 4 sum - pending

// 128 . Longest Consecutive Sequence - pending

// Largest subarray with 0 sum - pending

// 3 . Longest Substring Without Repeating Characters  - pending



// Linked List 

public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 206 . Reverse Linked List

// Using stack 

public ListNode reverseList(ListNode head) {
    Stack<ListNode> s=new Stack<>();
    ListNode temp=head;
    while(temp!=null){
        s.push(temp);
        temp=temp.next;
    }
    ListNode x=new ListNode(0);
    ListNode p=x;
    while(!s.isEmpty()){
        p.next=s.pop();
        p=p.next;
    }
    p.next=null;
    return x.next;
}

// O(1) space

public ListNode reverseList2(ListNode head) {
    
    ListNode l=head;
    ListNode prev=null;
    while(l!=null){
     ListNode nextTemp = l.next;
        l.next=prev;
        prev=l;
        l=nextTemp;
       
    }
     return prev;
}

// 876 . Middle of the Linked List

public ListNode middleNode(ListNode head) {
    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
}

// 21 . Merge Two Sorted Lists

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode temp=new ListNode(0);
    ListNode x=temp;
    ListNode head1=l1;
    ListNode head2=l2;
    while(head1!=null && head2!=null){
        if(head1.val>head2.val){
            temp.next=head2;
            temp=temp.next;
            head2=head2.next;
        }else{
            temp.next=head1;
            temp=temp.next;
            head1=head1.next;
        }
    }
    
    while(head1!=null){
        temp.next=head1;
        temp=temp.next;
        head1=head1.next;
    }
    
     while(head2!=null){
        temp.next=head2;
        temp=temp.next;
        head2=head2.next;
    }
    
    return x.next;
}

// 19 . Remove Nth Node From End of List

public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode();
     start.next = head;
     ListNode fast = start;
     ListNode slow = start;     

     for(int i = 1; i <= n; ++i)
         fast = fast.next;
 
     while(fast.next != null)
     {
         fast = fast.next;
         slow = slow.next;
     }
     
     slow.next = slow.next.next;
     
     return start.next;
 }

 // 2. Add Two Numbers

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

// 237 . Delete Node in a Linked List

public void deleteNode(ListNode node) {
    node.val=node.next.val;
    node.next=node.next.next;
}


// 160 . Intersection of Two Linked Lists

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode tem1=headA;
    ListNode tem2=headB;
    int s1=0;
    int s2=0;
    while(tem1!=null){
        s1++;
        tem1=tem1.next;
    }
    while(tem2!=null){
        s2++;
        tem2=tem2.next;
    }
    int diff=Math.abs(s1-s2);
    
    for(int i=0;i<diff;i++){
        if(s1>s2){
            headA=headA.next;
        }else{
            headB=headB.next;
        }
    }
    
    while(headA!=headB){
        headA=headA.next;
        headB=headB.next;
    }
    return headA;
}

// 141 . Linked List Cycle

public boolean hasCycle(ListNode head) {
    if(head==null || head.next==null) return false;
    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(fast==slow){
            return true;
        }
    }
    return false;
}

// 25 . Reverse Nodes in k-Group - pending

// 234 . Palindrome Linked List - pending

public boolean isPalindrome(ListNode head) {
    Stack<Integer> s=new Stack<>();
    ListNode temp=head;
    while(temp!=null){
        s.push(temp.val);
        temp=temp.next;
    }
    while(!s.isEmpty()){
        int k=s.pop();
        if(head.val!=k){
            return false;
        }
        head=head.next;
    }
    return true;
}

// 142 . Linked List Cycle II

public ListNode detectCycle(ListNode head) {
    if(head==null || head.next==null) return null;
    ListNode slow=head;
    ListNode fast=head;
    ListNode x=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(fast==slow){
             while(slow!=x){
                x = x.next;
                slow = slow.next;
            }
            return slow;
        }
    }
 return null;
}

// Day 7 pending 



public static void main(String args[]){
        
    }
}