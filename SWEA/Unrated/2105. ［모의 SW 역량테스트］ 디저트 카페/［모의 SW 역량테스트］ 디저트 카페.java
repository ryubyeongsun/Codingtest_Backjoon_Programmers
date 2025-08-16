import java.util.*;
import java.io.*;

class Solution
{
    static int N;	
    static int arr[][];
    static int dx[] = {1,1,-1,-1};
    static int dy[] = {1,-1,-1,1};
    static boolean visit[][];
    static boolean eat[];
    static int max;
    public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visit = new boolean[N][N];
            eat = new boolean[101];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = -1;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    visit[i][j] = true;
                    eat[arr[i][j]] =true;
                    dfs(i, j, i, j, 1,0);
                    visit[i][j] = false;
                    eat[arr[i][j]] = false;
                }
            }
            System.out.println("#" + test_case + " " +max);

		}

	}
    public static void dfs(int x, int y, int initX, int initY, int count,int dir){
        for(int i=dir; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx == initX && ny == initY && count>=4){
                max = Math.max(max, count);
                return;
            }
            
            
            if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && !eat[arr[nx][ny]] ){
                visit[nx][ny] = true;
                eat[arr[nx][ny]] = true;
                dfs(nx, ny, initX, initY, count+1,i);
                visit[nx][ny] = false;
                eat[arr[nx][ny]]= false;

            }

        }

    }

    
}