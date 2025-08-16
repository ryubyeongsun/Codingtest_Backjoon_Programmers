import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int M;
    static int L;
    static int arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visit[][];
    static int pipe[][] = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
    static int count;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visit = new boolean[N][M];

            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = 1;
            bfs(R, C, 1);
            System.out.println("#" + test_case + " " + count);

		}
	}
    public static void bfs(int x,int y, int time){
        Queue<int []> q = new LinkedList<>();
        visit[x][y] = true;
        q.offer(new int[]{x,y,time});
        
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            if(t==L) continue;

            int type = arr[r][c];

            for(int p : pipe[type]){
                int nx = r+dx[p];
                int ny = c+dy[p];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || arr[nx][ny]==0) continue;

                int op = p % 2 ==0 ? p+1 : p-1;
                boolean chk = false;

                for(int p1 : pipe[arr[nx][ny]]){
                    if(p1 == op){
                        chk = true;
                        break;
                    }
                }

                if(!chk) continue;

                visit[nx][ny] = true;
                q.offer(new int[] {nx,ny,t+1});
                
                count++;
            }

        }


    }
}