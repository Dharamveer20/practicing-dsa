package dsa;

import java.util.*;
public class HelloWorld {
    public static final int CHAR = 256;

    // public static void f(String s, String c,int i){
    //     if(i==s.length()) {
    //         System.out.println(c);
    //         return;
    //     }
    //     f(s,c,i+1);
    //     f(s,c+s.charAt(i),i+1);
    // } 
    // public static int f(int[]a,int sum, int ip, int i){
    //     if(ip == 0) return 1;
    //     if(i==a.length){
    //             if(ip == sum) return 1;
    //             else return 0;
    //     }
    //     return f(a,sum,ip,i+1) + f(a,sum+a[i],ip,i+1) >= 1 ? 1 : 0;
    
    // }

    // public static void th(int n, char s,char a, char d){
    //     if(n==1) {
    //         System.out.println(s+ "->"+ d);
    //         return;
    //     }
    //     th(n-1,s,d,a);
    //     th(1,s,a,d);
    //     th(n-1,a,s,d);
    // }
    // public static int rainWater(int[]arr){
    //     int sum =0;
    //     int n= arr.length;
    //     int [] lMax= new int[n];
    //     int [] rMax = new int[n];
    //     lMax[0] = arr[0];
    //     rMax[n-1] = arr[n-1];

    //     for(int i=1; i<n; i++) lMax[i] = Math.max(arr[i],lMax[i-1]);
    //     for(int i=n-2; i>=0; i--) rMax[i] = Math.max(arr[i],rMax[i+1]);

    //     for(int i=0; i<n; i++) sum += Math.min(lMax[i],rMax[i]) - arr[i];
    //     return sum;
    // }
    
    // public static int fo(int[]a,int key){
    //     int l=0,h=a.length-1;
    //     int fo=-1;
    //     while(l<=h){
    //         int mid = (l+h)/2;
    //         if(a[mid] == key) {
    //             if(mid == 0) return mid;
    //             fo = mid;
    //             h = mid - 1;
    //         }
    //         else if(a[mid] > key) h = mid-1;
    //         else l=mid+1;

    //     }
    //     return fo;
    // }

    // public static int peakEl(int[]arr,int l,int h){
    //     if(arr[0] > arr[1]) return arr[0];
    //     else if (arr[arr.length-1] > arr[arr.length-2]) return arr[arr.length-1];
    //     else{
    //         while(l<=h){
    //             int mid=(l+h)/2;
    //             if(arr[mid] >= arr[mid-1] && arr[mid] >= arr[mid+1]) return arr[mid];
    //             else if(arr[mid] <= arr[mid-1]) h = mid-1;
    //             else if(arr[mid] <= arr[mid+1]) l = mid+1;
    //         }
    //         return -1;
    //     }
    // }

    // public static void inter(int[]a,int[]b,int m,int n){
    //     int i=0,j=0;
    //     while(i<m && j<n){
    //         if(i>0 && a[i] == a[i-1]) {
    //             i++;
    //             continue;
    //         }
    //         if(a[i] == b[j]) {
    //             System.out.print(a[i] + " ");
    //             i++;
    //             j++;
    //         }
    //         else if(a[i] < b[j]) i++;
    //         else if(b[j]< a[i])j++;
    //     }
    // }
    
    public static void boundTraversal(int[][]arr,int n,int m){
        if(n==0) for(int j=0; j<=m; j++) System.out.print(arr[0][j] + " ");
        else if(m==0) for(int i=0; i<=n; i++) System.out.print(arr[i][0] + " ");

        else{
            for(int j=0; j<=m; j++) System.out.print(arr[0][j] + " ");
            if(n>=1 && m !=0){

                if(n>=2) for(int i=1; i<n; i++) System.out.print(arr[i][m] + " ");
                
                for(int j=m; j>=0; j--) System.out.print(arr[n][j] + " ");

                if (n>=2) for(int i=n-1; i>0; i--) System.out.print(arr[i][0] + " ");
            }
        }
        System.out.println();
    }

    public static void transpose(int[][]a,int l,int m){
        for(int i=0; i<l;i++){
            for(int j=0;j<m;j++){
                if(j>i) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
        for(int i=0; i<l;i++){
            for(int j=0;j<m;j++){
                System.out.print(a[i][j] + " ");
                }
            System.out.println();
            }
    }

    // public static void rot(int[][]arr,int m,int n){
    //     int [][] temp = new int[m][n];
    //     int k = arr.length-1;
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             temp[i][j] = arr[j][k];
    //         }
    //         k--;
    //     }

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             System.out.print(temp[i][j] + " ");
    //         }
    //        System.out.println();
            
    //     }
    // }

    public static void rot(int[][]arr,int m){
        int k = m-1;
        for(int i=0; i<m;i++){
            for(int j=0;j<m;j++){
                if(j>i) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

        for(int i=0; i<m;i++){
            if(i>k) break;
            for(int j=0;j<m;j++){
                int temp = arr[i][j];
                    arr[i][j] = arr[k][j];
                    arr[k][j] = temp;
            }
            k--;
        }
           System.out.println();

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
           System.out.println();
        }
    }

    public static boolean sub0(int[]arr){
        int pre=0;
        HashSet<Integer> hs = new HashSet<>();

        for(int val:arr){
            pre+=val;
            if(pre == 0) return true;
            if(hs.contains(pre)) return true;
            hs.add(pre);
        }
        return false;
    }
    public static boolean isPair(int [] arr,int key){
        HashSet<Integer> hs = new HashSet<>();  
        int sum = 0;
        for(int val: arr){
            if(hs.contains(key-val)) return true;
            hs.add(val);
        }
        return false;
    } 
    public static int lgSubArray(int [] arr,int m,int s){
        int p=0;
        int res=0;
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i=0; i<m; i++){
            p+=arr[i];
            if(p == s) res = i + 1;
            if(hm.containsKey(p-s)) res = Math.max(res,i - hm.get(p-s));
            if(!(hm.containsKey(p))) hm.put(p,i);
        }
        return res;
    }

    public static int lgSubArraySum0(int [] arr, int m){
        int res=0,preSum=0;
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<m;i++)
            if(arr[i] == 0) arr[i] = -1;
        
        for(int i=0; i<m; i++){
            preSum += arr[i];
            if(hm.containsKey(preSum)) res = Math.max(res, i-hm.get(preSum));
            if(hm.containsKey(preSum) == false) hm.put(preSum,i);
        }   
        return res;
    }
    public static int lgSpanSubArr(int [] arr, int [] arr1, int n){
        int span = 0,tempSpan = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == arr1[i]) tempSpan++;
            span = Math.max(span,tempSpan);
            if(arr[i] != arr1[i]) tempSpan = 0;
        }
        return tempSpan;
    }
    public static int max(int arr[], int []arr1, int n){
        int res=0;
         for(int i=0; i<n;i++){
            int sum1=0,sum2=0;
            for(int j=0;j<n; j++){
                sum1+=arr[j];
                sum2+=arr1[j];
                if(sum1==sum2) res = Math.max(res,j-i+1);
            }
         }
         return res;
    }

    // public static int longest0(int arr1[], int arr2[],int n){
    //     int [] arr = new int[n];
    //     for(int i=0; i<n; i++) arr[i] = arr1[i]-arr2[i];
        
    //     int res =0,preSum=0;
    //     Map <Integer,Integer> hm = new HashMap<>();

    //     for(int i=0; i<n; i++){
    //         if(arr[i] == 0){ 
    //             res++;
    //             continue;
    //         }
    //         preSum +=arr[i];
    //         if(hm.containsKey(preSum)) res = Math.max(res, i-hm.get(arr[i])+1);
    //         else hm.put(arr[i],i);
    //     }
    //     return res;
    // }
    
    // public static int cons(int []arr){
    //     int res = 0;
    //     int temp = 1;
    //     Set<Integer> hs = new HashSet<>();

    //     for(int x : arr) hs.add(x);

    //     for(int x : hs){
    //         if(hs.contains(x-1)) continue;
    //         temp =1;
    //         while(hs.contains(x+1)) temp++;
    //         res = Math.max(res,temp);
    //     }
    //     return res;
    // }

    // public static void countDistinct(int arr [], int k){
    //     Map<Integer> hs = new HashMap<>();
    //     int i=0,z=0,count=0;
    //     while(true){
    //         if(!(hs.contains(arr[i]))) {
    //             hs.add(arr[i]);
    //             z++;
    //             i++;
    //         }
    //         if(z==k) {

    //         } 
    //     }
    // }

    // public static boolean subSeq(String s1, String s2){
    //     int l2 = s2.length();
    //     int z2 = 0;

    //     for(int i=0; i<s1.length(); i++)
    //         if(s2.contains(Character.toString(s1.charAt(i)))) z2++;

    //     if(z2 < l2) return false;
    //     return true;
    // }

    // public static boolean ana(String s1, String s2){
    //     int b [] = new int[256];
    //     if(s1.length() != s2.length())return false;
    //     for(int i=0; i<s1.length(); i++){
    //         b[s1.charAt(i)]++;
    //         b[s2.charAt(i)]--; 
    //     }
    //     for(int x : b) if(x!=0)return false;
    //     return true;
    // }
    // public static int leftNonRepOccur(String str){
        // int res = Integer.MAX_VALUE;
    //     HashMap<Character,Integer>hm = new HashMap<>();

    //     for(int i=0; i<str.length(); i++){
    //         if(hm.containsKey(str.charAt(i))) hm.put(str.charAt(i), -1);
    //         else hm.put(str.charAt(i),i);
    //     }

    //     for(int i=0; i<str.length();i++){
    //         if(hm.get(str.charAt(i)) != -1) return i;
    //     }
    //     return -1;
    // }

    // public static String revWordStr(String str){
    //     int start = 0;
    //     for(int end=0; end<str.length(); end++){
    //       if(str.charAt(end) == ' '){
    //           str = reverse(str,start,end-1);
    //           start = end + 1;
    //       }
    //     }
    //     str = reverse(str,start,str.length()-1);
    //     str = reverse(str,0,str.length()-1);
  
    //     return str;
    //   }
    //   public static String reverse(String str, int low,int high){
    //     String rep = "";
    //     while(low<=high){
    //         rep = str.replace(str.charAt(low),str.charAt(high));
    //         low++;
    //         high--;
    //     }
    //     return rep;
    //   }

    // public static void pattern(String patt,String txt, int m, int n) {
    //     for(int i=0; i<=n-m; i++){
    //         int j;
    //         for(j=0; j<m;j++) if(patt.charAt(j) != txt.charAt(i+j)) break;
    //         if(j==m) System.out.print(i + " ");
    //     }
    // }

    // public static void pattern1(String patt,String txt, int m, int n) {
    //     for(int i=0; i<=n-m;){
    //         int j;
    //         for(j=0; j<m;j++) if(patt.charAt(j) != txt.charAt(i+j)) break;
    //         if(j==m) System.out.print(i + " ");
    //         if(j==0) i++;
    //         else i += j;
    //     }
    // }

    // public static boolean checkRot(String str, String rot){
    //     String tempStr = str;
    //     int i=1;
    //     while(i%str.length() != 0){
    //         tempStr = rotate(tempStr);
    //         if(tempStr.equals(rot)) return true;
    //         i++;
    //     }
    //     return false;
    // }
    // public static String rotate(String str){
    //     char [] strArr = str.toCharArray();
    //     char temp = strArr[0];
    //     for(int i=0; i<strArr.length-1; i++){
    //         strArr[i] = strArr[i+1];
    //     }
    //     strArr[strArr.length-1]=temp;
    //     return new String(strArr);
    // }

    // public static boolean anagram(String txt, String patt, int m, int n){
    //     boolean visited[] = new boolean[256];
    //     int curr =0;
    //     // visited = truthPatt(visited,patt,n);
    //     truthPatt(visited,patt,n);

    //     // for(int x=0; x<n; x++){
    //     //     System.out.print(visited[patt.charAt(x)] + " ");
    //     // }
    //     for(int i=0;i<m;i++){
    //         if(visited[txt.charAt(i)]){
    //             curr++;
    //             if(curr == n) return true;
    //             visited[txt.charAt(i)]= false;

    //         }
    //         else{
    //             truthPatt(visited,patt,n);
    //         }
    //     }
    //     return false;
    // }
    // public static void truthPatt(boolean [] visited, String patt, int n){
    //     for(int x=0; x<n; x++){
    //         visited[patt.charAt(x)] = true;
    //     }
    //     // return visited;
    // }
    // public static boolean checkAna(String txt, String patt, int m, int n){
    //     int [] txtArr = new int[CHAR];
    //     int [] pattArr = new int[CHAR];

    //     for(int i=0; i<n; i++){
    //         txtArr[txt.charAt(i)]++;
    //         pattArr[patt.charAt(i)]++;
    //     }
    //     if(arrayMatch(txtArr,pattArr)) return true;

    //     for(int i=n; i<m;i++){
    //         txtArr[txt.charAt(i)]++;
    //         txtArr[txt.charAt(i-n)]--;
    //         if (arrayMatch(txtArr, pattArr)) {
    //             return true; // Found anagram
    //         }
    //     }
        
    //     return false;
    // }
    // public static boolean arrayMatch(int[]a,int[]b){
    //     for(int i=0; i<CHAR; i++){
    //         if(a[i] != b[i]) return false;
    //     }
    //     return true;
    // }
    public static void main(String[] args){
        String str = "abcdef";
        String str1 = "cefd";
        System.out.print("jed");
        // System.out.println(checkAna(str,str1,6,4));

        // String str2 = "abcdef";
        // String str3 = "cfzd";
        // System.out.println(checkAna(str2,str3,6,4));
        // String str = "abcdabdabcdab";
        // String str1 = "abcd";
        // pattern1(str1,str,4,str.length());

        // String str2 = "djpkgfntrfkgf";
        // String str3 = "kgf";
        // pattern1(str3,str2,3,str2.length());
        // System.out.println(leftNonRepOccur(str)); 
        // String s1="Pappu";`
        // String s1 = "LeviOy";
        // String s2 = "ieevz";
        // System.out.println(subSeq(s1,s2));

        // String s3 = "LevdfiOy";
        // String s4 = "ieevif";
        // System.out.println(subSeq(s3,s4));
        // int arr[] = {7,3,5,9,10,4,6,11,12,12};
        // System.out.println(cons(arr));
        // int [] arr={3,4,5,9,0};
        // int [] arr1 = {4,8,3,1,5,-6,6,2,2};
        // int [] arr1 = {4,8,3,1,5,-6,6,2,2};
        // int [] arr1= {1,1,1,1,0,1,0,0};
        // int [] arr2= {1,1,1,1,0,1,0,0,0,1};
        // int [] arr = {0,1,1,1};
        // int [] arr1 = {1,0,1,1};
        // System.out.println(longest0(arr,arr1,4));

        // System.out.println(lgSubArraySum0(arr1,8));
        // System.out.println(lgSubArraySum0(arr2,10));

        // System.out.println(lgSubArray(arr,5,14));
        // System.out.println(lgSubArray(arr1,9,4));

        // System.out.println(isPair(arr,6));
        // System.out.println(sub0(arr));
        // int [][] arr ={{5,6,7,1},{8,9,10,2},{11,12,13,3},{14,15,16,17}};
        // rot(arr,4);     

        // // transpose(arr,3,3);
        // int [][] arr1 ={{5,6,7}};

        // int [][] arr2 = {{1},{2},{3}};
        // int [][] arr3 ={{5,6,7},{8,9,10}};
        // boundTraversal(arr,2,2);
       
        // boundTraversal(arr1,0,2);
        // boundTraversal(arr2,2,0);
        // boundTraversal(arr3,1,2);

        // int [] a = {3,4,6,7,89,99};
        // int []b= {6,67,78,89,99,100};
        // inter(a,b,6,6);

        // int [] arr = {0,0,0,2,2,3,3,5,4};
        // System.out.println(peakEl(arr,0,8));
        // System.out.println(fo(arr,3));
        // System.out.println(fo(arr,5));
        // System.out.println(fo(arr,-3));
        // System.out.println(fo(arr,0));


        // System.out.println(rainWater(arr));
        // th(3,'A','B','C');
        // int []arr = {1,2,3,4};
        // System.out.print(f(arr,0,3,0));
        // f("ABC","",0);
    }
}
