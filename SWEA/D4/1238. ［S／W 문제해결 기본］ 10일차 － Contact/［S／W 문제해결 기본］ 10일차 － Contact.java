
import java.util.*;
import java.io.*;

class Solution
{
    static ArrayList<Integer> list[];
    static int N,S;
    static boolean visit[];
    static int maxDepth, result;
    
	public static void main(String args[]) throws IOException
	{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[101];
            visit = new boolean[101];

            for(int i=1; i<101; i++){
                list[i] = new ArrayList<>();

            }

            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());         
            }
            for(int i=0; i<N-1; i++){
                if(i%2==0){
                    list[arr[i]].add(arr[i+1]);
                }
            }
            maxDepth = -1;
            result = -1;
            int ans = bfs(S);

            System.out.println("#" + test_case + " " + result);
		}

	}
    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        result = start;

        while (!q.isEmpty()) {
            int size = q.size();
            int maxNum = 0;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                maxNum = Math.max(maxNum, cur);

                for (int next : list[cur]) {
                    if (!visit[next]) {
                        visit[next] = true;
                        q.offer(next);
                    }
                }
            }
            result = maxNum;
        }
        return result;
    }
}