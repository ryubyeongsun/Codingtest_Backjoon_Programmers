import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[] arr;       
    static boolean[] visit; 
    static int mindist;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[(N+2) * 2];  
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[N];
            mindist = Integer.MAX_VALUE;

           
            dfs(0, arr[0], arr[1], 0);

            System.out.println("#" + test_case + " " + mindist);
        }
    }

    public static void dfs(int cnt, int x, int y, int dist) {
        if (dist >= mindist) return; 

        if (cnt == N) { 
            dist += Math.abs(x - arr[2]) + Math.abs(y - arr[3]); 
            mindist = Math.min(mindist, dist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int cx = arr[4 + i*2];
                int cy = arr[5 + i*2]; 
                dfs(cnt+1, cx, cy, dist + Math.abs(x - cx) + Math.abs(y - cy));
                visit[i] = false;
            }
        }
    }
}
