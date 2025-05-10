import java.util.*;
import java.io.*;

class Solution {
	static int arr[];
    static int max = 0;
    static int change;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            change = Integer.parseInt(st.nextToken());
            String snum = Integer.toString(num);
            arr = new int[snum.length()];
            
            for(int i=0; i<snum.length(); i++){
            	arr[i] = snum.charAt(i)-'0';
            }
            if(arr.length < change) {	
            	change = arr.length;	
            }
			dfs(0);
            System.out.println("#" + test_case + " " + max);
            max = 0;
        }
    }
    static void dfs(int dep){
    	if(dep == change){
        	int val = 0; 
            for(int i=0; i<arr.length; i++){
            	val = val*10 + arr[i];
            }
            if(val>max){
            	max=val;
            }
            return;
        }
        for(int i=0; i<arr.length; i++){
        	for(int j=i+1; j<arr.length; j++){
            	swap(i,j);
                dfs(dep+1);
                swap(i,j);
            }
        }
        
    }
    static void swap(int i, int j){
    	int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
   