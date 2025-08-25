import java.io.*;
import java.util.*;

public class Solution {
	
   static int p[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());		
		
		for(int test_case = 1; test_case <= T; test_case++) {			
			
				StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());      
            p = new int[n+1];
            StringBuilder sb = new StringBuilder();

            for(int i=1; i<=n; i++){
               p[i] = i;
            }
            
            for(int i=1; i<=m; i++){
               st = new StringTokenizer(br.readLine());
               int op = Integer.parseInt(st.nextToken());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               
               if(op == 0){
                  union(a, b);
               }else if(op==1){
                  int pa = find(a);
                  int pb = find(b);
                  if(pa==pb){
                     sb.append(""+1);
                  }else{
                     sb.append(""+0);
                  }
               }

            }
            System.out.println("#" + test_case + " "+sb);
			}
		
		}
      public static int find(int a){
         if(p[a] == a) return a;
         else{
            return p[a] = find(p[a]);
         }

      }

      public static void union(int a, int b){
         int pa = find(a);
         int pb = find(b);

         p[pa] = pb;

      }
		
}

	
	



